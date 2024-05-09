package com.example.UserManament.Controller;

import com.example.UserManament.Entity.Thietbi;
import com.example.UserManament.Model.Thietbi.ThietbiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ThietBiController {
    @Autowired
    private ThietbiModel thietBiModel;

    @GetMapping("/thiet-bi")
    @ResponseBody
    public List<Thietbi> getAllThietBi() {
        return thietBiModel.getAll();
    }

}
