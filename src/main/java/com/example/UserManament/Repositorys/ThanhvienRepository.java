/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UserManament.Repositorys;

import com.example.UserManament.Models.Thanhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanhvienRepository extends JpaRepository<Thanhvien, Integer> {
    
    @Query("select * from thanhvien where MaTV = :id")
    public Thanhvien findById(@Param("ïd") int id);
    
    @Query("select * from thanhvien where MaTV=:MaTV and password = :password")
    public Thanhvien findByMaTVAndpassword(@Param("MaTV")int Account,@Param("password") String password);
}