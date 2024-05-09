package com.example.UserManament.Entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "xuly", indexes = {
        @Index(name = "MaTV", columnList = "MaTV"),
        @Index(name = "MaTV_2", columnList = "MaTV")
})
public class Xuly {
    @Id
    @Column(name = "MaXL", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTV", nullable = false)
    private Thanhvien maTV;

    @Column(name = "HinhThucXL", length = 250)
    private String hinhThucXL;

    @Column(name = "SoTien")
    private Integer soTien;

    @Column(name = "NgayXL")
    private Instant ngayXL;

    @Column(name = "TrangThaiXL")
    private Integer trangThaiXL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Thanhvien getMaTV() {
        return maTV;
    }

    public void setMaTV(Thanhvien maTV) {
        this.maTV = maTV;
    }

    public String getHinhThucXL() {
        return hinhThucXL;
    }

    public void setHinhThucXL(String hinhThucXL) {
        this.hinhThucXL = hinhThucXL;
    }

    public Integer getSoTien() {
        return soTien;
    }

    public void setSoTien(Integer soTien) {
        this.soTien = soTien;
    }

    public Instant getNgayXL() {
        return ngayXL;
    }

    public void setNgayXL(Instant ngayXL) {
        this.ngayXL = ngayXL;
    }

    public Integer getTrangThaiXL() {
        return trangThaiXL;
    }

    public void setTrangThaiXL(Integer trangThaiXL) {
        this.trangThaiXL = trangThaiXL;
    }

}