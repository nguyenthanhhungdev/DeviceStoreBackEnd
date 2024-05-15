package com.example.UserManament.Model.Thietbi;

import com.example.UserManament.Model.Gerneric;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public interface ThietbiModel<Thietbi> extends Gerneric<Thietbi > {
    @Autowired
        Iterable<Thietbi> findAll();
        List<Thietbi> listForSearch();
        List<Thietbi> search(String term);
        Thietbi add(Thietbi tb);
        Thietbi update(Thietbi tb);
        Optional<Thietbi> findById(Integer id);
        void deleteAllById(Integer id);
        int maxID();
}
