package com.example.UserManament.Controllers;

import com.example.UserManament.Models.Thietbi;
import com.example.UserManament.Models.Thongtinsd;
import com.example.UserManament.Services.Thietbi.ThietbiService;
import java.util.ArrayList;

import com.example.UserManament.Services.Thongtinsd.ThongtinsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThietBiController {
    @Autowired
    private ThietbiService thietbiService;

    @GetMapping("/thiet-bi")
    @ResponseBody
    public List<Thietbi> getAllThietBi() {
        return thietbiService.getAll();
    }
    

    @Autowired
    private ThongtinsdService thongtinsdService;

    public boolean KiemTraThietBiChuaMuon(int matb) {
        List<Thongtinsd> list = (List) thongtinsdService.findAll();
        for (Thongtinsd tt : list) {
            if (tt.getId() != null)
                if (tt.getId() == matb
                        && ((tt.getTGTra() == null && tt.getTGMuon() != null) || tt.getTGVao() != null))
                    return false;
        }
        return true;
    }

    public boolean KiemtraThietBiDaMuon(int matv, int matb) {
        List<Thongtinsd> list = (List) thongtinsdService.findAll();
        for (Thongtinsd tt : list) {
            if (tt.getId() != null)
                if (tt.getId() == matb 
                        && tt.getMaTV() == matv 
                        && tt.getTGMuon() != null && tt.getTGTra() == null)
                    return true;
        }
        return false;
    }

    @GetMapping("/api/get-devices")
    public ResponseEntity<ArrayList<Thietbi>> getDevices(@RequestParam String status, @RequestParam String matv,
            @RequestParam String search) {
        Iterable<Thietbi> devices = thietbiService.findAll();
        ArrayList<Thietbi> results = new ArrayList<Thietbi>();
        if ("muon".equals(status)) {
            for (Thietbi tb : devices) {
                if (KiemTraThietBiChuaMuon(tb.getId()))
                    if (tb.getTenTB().toLowerCase().contains(search.toLowerCase()) ||
                            tb.getId().toString().toLowerCase().contains(search.toLowerCase()))
                        results.add(tb);
            }
        } else {
            for (Thietbi tb : devices) {
                if (KiemtraThietBiDaMuon(Integer.parseInt(matv), tb.getId()))
                    if (tb.getTenTB().toLowerCase().contains(search.toLowerCase()) ||
                            tb.getId().toString().toLowerCase().contains(search.toLowerCase()))
                        results.add(tb);
            }
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/api/get-devices-damuon")
    public ResponseEntity<ArrayList<Thongtinsd>> getUserViPham(@RequestParam Integer maTV) {
        Iterable<Thongtinsd> thongtin = thongtinsdService.findAll();
        ArrayList<Thongtinsd> results = new ArrayList<Thongtinsd>();

        for (Thongtinsd tt : thongtin) {
            if (tt.getMaTV() == maTV && tt.getId() != null && tt.getTGMuon() != null && tt.getTGTra() == null) {
                results.add(tt);
            }
        }
        return ResponseEntity.ok(results);
    }

    @GetMapping("/api/get-all-devices")
    @ResponseBody
    public ArrayList<Thietbi> getAllDevices() {
        Iterable<Thietbi> devices = thietbiService.findAll();
        ArrayList<Thietbi> results = new ArrayList<Thietbi>();
        for (Thietbi tb : devices) {
            results.add(tb);
        }
        return results;
    }

    @GetMapping("/thietbi")
    public String showAllThietBi(Model m) {
        Iterable<Thietbi> list = thietbiService.findAll();
        String item_id = "";
        for (Thietbi tb : list) {
            String id = Integer.toString(tb.getId()).substring(1, 3);
            item_id = id;
            break;
        }
        m.addAttribute("item_id", item_id);
        m.addAttribute("data", list);
        return "thietbi";
    }

    @GetMapping(value = { "thietbi/delete/{id}" })
    public String delete(@PathVariable("id") int id) {
        thietbiService.deleteAllById(id);
        return "redirect:/thietbi";
    }

    @GetMapping("thietbi/edit/{id}")
    public String editThietBi(@PathVariable Integer id, Model model) {
        Optional<Thietbi> optionalThietBi = thietbiService.findById(id);
        optionalThietBi.ifPresent(thietBi -> model.addAttribute("thietbi", thietBi));
        return "thietbi_edit";
    }

    @GetMapping("thietbi/search")
    public ResponseEntity<List<Thietbi>> searchThietBi() {
        List<Thietbi> results = thietbiService.listForSearch();
        return ResponseEntity.ok(results);
    }

    @GetMapping("thietbi/add")
    public String addThietbi(Model model) {

        return "thietbi_add";
    }

    @PostMapping("thietbi/update")
    public ResponseEntity<String> updateThietBi(@RequestBody Thietbi thietbi) {
        try {
            thietbiService.update(thietbi);
            return new ResponseEntity<>("redirect:/thietbi", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lưu dữ liệu không thành công: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("thietbi/save")
    public ResponseEntity<String> saveThietB(@RequestBody Thietbi thietbi) {
        try {
            thietbiService.add(thietbi);
            return new ResponseEntity<>("redirect:/thietbi", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lưu dữ liệu không thành công: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("thietbi/saveExcel")
    public ResponseEntity<String> saveThietBi(@RequestBody Thietbi thietbi) {
        System.out.println(thietbi.getId());
        Iterable<Thietbi> list = thietbiService.findAll();
        for (Thietbi tb : list) {
            if (tb.getId().equals(thietbi.getId())) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Mã thiết bị trùng !");
            }
        }
        try {
            thietbiService.add(thietbi);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Thêm thiết bị thành công !");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi máy chủ !");
        }
    }

}
