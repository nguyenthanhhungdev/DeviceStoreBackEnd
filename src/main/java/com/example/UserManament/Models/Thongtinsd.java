package com.example.UserManament.Models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "thongtinsd", indexes = {
        @Index(name = "MaTV", columnList = "MaTV, MaTB"),
        @Index(name = "MaTB", columnList = "MaTB")
})
public class Thongtinsd {
    @Id
    @Column(name = "MaTT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTV", nullable = false)
    private Thanhvien maTV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTB")
    private Thietbi maTB;

    @Column(name = "TGVao")
    private Instant tGVao;

    @Column(name = "TGMuon")
    private Instant tGMuon;

    @Column(name = "TGTra")
    private Instant tGTra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMaTV() {
        return maTV.getId();
    }

    public void setMaTV(Thanhvien maTV) {
        this.maTV = maTV;
    }

    public int getMaTB() {
        return maTB.getId();
    }

    public void setMaTB(Thietbi maTB) {
        this.maTB = maTB;
    }

    public Instant getTGVao() {
        return tGVao;
    }

    public void setTGVao(Instant tGVao) {
        this.tGVao = tGVao;
    }

    public Instant getTGMuon() {
        return tGMuon;
    }

    public void setTGMuon(Instant tGMuon) {
        this.tGMuon = tGMuon;
    }

    public Instant getTGTra() {
        return tGTra;
    }

    public void setTGTra(Instant tGTra) {
        this.tGTra = tGTra;
    }

}