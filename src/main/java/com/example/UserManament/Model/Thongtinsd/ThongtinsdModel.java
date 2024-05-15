/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.UserManament.Model.Thongtinsd;

import com.example.UserManament.Model.Gerneric;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LE HOANG
 */
public interface ThongtinsdModel<Thongtinsd> extends Gerneric<Thongtinsd >  {
    @Autowired
    Iterable<Thongtinsd> findAll();
    List<Thongtinsd> search(String term);
    Thongtinsd add(Thongtinsd tv);
    Thongtinsd update(Thongtinsd tv);
    Optional<Thongtinsd> findById(Integer id);
    void deleteByMaTV(Integer id);
    public int getCountTVAll();
    public ArrayList<Object[]> getCountTVTheoKhoa();
    public ArrayList<Object[]> getCountTVTheoNganh();
    public ArrayList<Object[]> getCountTVTheoNgay(Date date);
    public ArrayList<Object[]> getCountTVTheoThang(int month, int year);
    public ArrayList<Object[]> getCountTVTheoNam(int year);
    public ArrayList<Object[]> getCountTVTheoKhoang(Date date1, Date date2);
    public ArrayList<Object[]> getCountTBTheoKhoang(Date date1, Date date2);
    public ArrayList<Thongtinsd> getThietBiDangMuon();
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongNgay(Date date);
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongKhoangThoiGian(Date startDate, Date endDate);
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongThang(int year, int month);
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongNam(int year);
}
