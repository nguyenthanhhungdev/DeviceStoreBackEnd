package com.example.UserManament.Services.Thietbi;

import com.example.UserManament.Services.Gerneric;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public interface ThietbiService<Thietbi> extends Gerneric<Thietbi> {
    Iterable<Thietbi> findAll();

    List<Thietbi> listForSearch();

    List<Thietbi> search(String term);

    Thietbi add(Thietbi tb);

    Thietbi update(Thietbi tb);

    Optional<Thietbi> findById(Integer id);

    void deleteAllById(Integer id);

    int maxID();
}
