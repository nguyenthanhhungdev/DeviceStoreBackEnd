package com.example.UserManament.Model.Thietbi;

import com.example.UserManament.Entity.Thietbi;
import com.example.UserManament.Repository.ThietBiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThietBiModelImpl implements ThietbiModel<Thietbi> {

    @Autowired
    private ThietBiRepository thietBiRepository;


    @Override
    public List<Thietbi> getAll() {
        return thietBiRepository.findAll();
    }

    @Override
    public Thietbi getById(int id) {
        return null;
    }
}
