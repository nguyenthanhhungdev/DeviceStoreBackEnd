package com.example.UserManament.Services.Thietbi;

import com.example.UserManament.Models.Thietbi;
import com.example.UserManament.Repositorys.ThietBiRepository;
import com.example.UserManament.Repositorys.ThongTinSDRepository;
import com.example.UserManament.Repositorys.XuLyRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ThietBiServiceImpl implements ThietbiService<Thietbi> {

    @Autowired
    private ThietBiRepository thietBiRepository;
    @Autowired
    private XuLyRepository xuLyRepository; 
    @Autowired
    private ThongTinSDRepository thongTinSDRepository;
    
    @Override
    public Iterable<Thietbi> findAll() {
        return thietBiRepository.findAll();
    }
    
    @Override
    public Thietbi getById(int id) {
        return null;
    }

    @Override
    public List<Thietbi> search(String term) {
        return null;
    }
    
     @Override
    public List<Thietbi> listForSearch() {
        Iterable<Thietbi> iterable = thietBiRepository.findAll();

        List<Thietbi> list = new ArrayList<>();
        iterable.forEach(list::add);

        return list;
    }
    @Override
    public Thietbi add(Thietbi tv) {
        return thietBiRepository.save(tv);
    }

    @Override
    public Thietbi update(Thietbi tv) {
        return thietBiRepository.save(tv);
    }

    @Override
    public Optional<Thietbi> findById(Integer id) { // handle case if Thietbi does not exist in database
        return thietBiRepository.findById(id);
    }

    @Override
    public int maxID() {
        return thietBiRepository.getNextAutoIncrementValue();
    }
    
    
    @Override
    @Transactional
    public void deleteAllById(Integer id) {
        System.out.println(id);
        xuLyRepository.deleteByMaTV(id);
        thongTinSDRepository.deleteByMaTV(id);
        thietBiRepository.deleteById(id);
    }

    @Override
    public List<Thietbi> getAll() {
        List<Thietbi> target = new ArrayList<>();
        thietBiRepository.findAll().forEach(target::add);
        return target;
    }
    @Override
    public List<Thietbi> findByMaTV(Integer maTV) {
        return thietBiRepository.findByMaTV(maTV);
    }
}
