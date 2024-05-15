/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UserManament.Model.Thongtinsd;

import com.example.UserManament.Entity.Thongtinsd;


import com.example.UserManament.Repository.ThongTinSDRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vi Hao
 */
@Service
public class ThongTinSDModelImpl implements ThongtinsdModel {
    @Autowired
    private ThongTinSDRepository thongTinSDRepository;

    @Override
    public Iterable<Thongtinsd> findAll() {
        return thongTinSDRepository.findAll();
    }

    @Override
    public List<Thongtinsd> search(String term) {
        return null;
    }

    @Override
    public Thongtinsd add(Thongtinsd tv) {
        return thongTinSDRepository.save(tv);
    }

    @Override
    public Thongtinsd update(Thongtinsd tv) {
        return thongTinSDRepository.save(tv);
    }

    @Override
    public Optional<Thongtinsd> findById(Integer id) { // handle case if Thongtinsd is not exist in database
        return thongTinSDRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteByMaTV(Integer matv) {
        thongTinSDRepository.deleteByMaTV(matv);
    }

    @Override
    public int getCountTVAll() {
        return thongTinSDRepository.getCountTVAll();
    }

    @Override
    public ArrayList<Object[]> getCountTVTheoKhoa() {
        return thongTinSDRepository.getCountTVTheoKhoa();
    }

    @Override
    public ArrayList<Object[]> getCountTVTheoNganh() {
        return thongTinSDRepository.getCountTVTheoNganh();
    }

    @Override
    public ArrayList<Object[]> getCountTVTheoNgay(Date date) {
        return thongTinSDRepository.getCountTVTheoNgay(date);
    }

    @Override
    public ArrayList<Object[]> getCountTVTheoThang(int month, int year) {
        return thongTinSDRepository.getCountTVThang(month, year);
    }

    @Override
    public ArrayList<Object[]> getCountTVTheoNam(int year) {
        return thongTinSDRepository.getCountTVTheoNam(year);
    }

    @Override
    public ArrayList<Object[]> getCountTVTheoKhoang(Date date1, Date date2) {
        return thongTinSDRepository.getCountTVTheoKhoang(date1, date2);
    }

    @Override
    public ArrayList<Object[]> getCountTBTheoKhoang(Date date1, Date date2) {
        return thongTinSDRepository.getCountTBTheoKhoang(date1, date2);
    }

    @Override
    public ArrayList<Thongtinsd> getThietBiDangMuon() {
        return thongTinSDRepository.getThietBiDangMuon();
    }

    @Override
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongNgay(Date date) {
        return thongTinSDRepository.getThietBiDangMuonTrongNgay(date);
    }

    @Override
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongKhoangThoiGian(Date startDate, Date endDate) {
        return thongTinSDRepository.getThietBiDangMuonTrongKhoangThoiGian(startDate, endDate);
    }

    @Override
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongThang(int year, int month) {
        return thongTinSDRepository.getThietBiDangMuonTrongThang(year, month);
    }

    @Override
    public ArrayList<Thongtinsd> getThietBiDangMuonTrongNam(int year) {
        return thongTinSDRepository.getThietBiDangMuonTrongNam(year);
    }
}
