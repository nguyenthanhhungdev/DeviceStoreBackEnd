package com.example.UserManament.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "thietbi")
public class Thietbi {
    @Id
    @Column(name = "MaTB", nullable = false)
    private Integer id;

    @Column(name = "TenTB", nullable = false, length = 100)
    private String tenTB;

    @Lob
    @Column(name = "MoTaTB")
    private String moTaTB;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getMoTaTB() {
        return moTaTB;
    }

    public void setMoTaTB(String moTaTB) {
        this.moTaTB = moTaTB;
    }

}