/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UserManament.Services.ThanhVien;

import com.example.UserManament.Models.Thanhvien;
import com.example.UserManament.Repositorys.ThanhvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
@Service
public class ThanhvienService {
    
    @Autowired
    ThanhvienRepository ThanhvienRepository;
    
    public Thanhvien findById(int id){
        return this.ThanhvienRepository.findById(id);
    }
    public Thanhvien login(int Account,String password){
        return ThanhvienRepository.findByMaTVAndpassword(Account,password);
    }
    
    public void signup(Thanhvien Thanhvien){
        ThanhvienRepository.save(Thanhvien);
    }
    
    public List<Thanhvien> findAll(){
        List Thanhvien = new ArrayList();
        Thanhvien =ThanhvienRepository.findAll();
        return Thanhvien;
    }
    
}