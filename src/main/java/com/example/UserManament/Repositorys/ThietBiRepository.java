/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.UserManament.Repositorys;


import com.example.UserManament.Models.Thietbi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ThietBiRepository extends CrudRepository<Thietbi,Integer>{
    @Modifying
    @Transactional
    
    // Thêm phương thức để lấy mã tiếp theo được tăng
    @Query(value = "SELECT MAX(maXL) FROM ThietBi", nativeQuery = true)
    Integer getNextAutoIncrementValue();

    // ...
    @Query("SELECT * FROM Thietbi tb JOIN Thongtinsd tt WHERE tt.maTB = tb.id AND tt.maTV = :maTV")
    List<Thietbi> findByMaTV(@Param("maTV") Integer maTV);
}
