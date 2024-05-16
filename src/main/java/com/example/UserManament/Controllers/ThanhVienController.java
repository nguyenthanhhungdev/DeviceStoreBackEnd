/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UserManament.Controllers;

import com.example.UserManament.Models.Thanhvien;
import com.example.UserManament.Services.ThanhVien.ThanhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author DELL
 */

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping(value = "/")
public class ThanhVienController {

    @Autowired
    private ThanhvienService um;

    @RequestMapping(value = "/")
    public String ViewLogin(Model model){
        model.addAttribute("user", new Thanhvien());
        return "index";
    }

    @RequestMapping(value = "/error")
    public String ViewError(){
        return "error";
    }

    @RequestMapping(value = "/test")
    public String ViewTest(){
        return "test";
    }
    @RequestMapping(value = "/Home")
    public String ViewHome(){
        return "Home";
    }

    @PostMapping(value="/login")
    public String login(@RequestParam("username") int MaTV,@RequestParam("password")  String password, Model model) {

        System.out.println(MaTV);
        System.out.println(password);

        Thanhvien user = um.login(MaTV, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "Home";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/process_register")
    public String signup(@ModelAttribute("user") Thanhvien user) {
        um.signup(user);
        return "redirect:/";
    }
}