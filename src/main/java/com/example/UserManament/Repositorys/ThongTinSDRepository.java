/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.UserManament.Repositorys;


import com.example.UserManament.Models.Thongtinsd;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ThongTinSDRepository extends CrudRepository<Thongtinsd,Integer>{
    @Modifying
    @Transactional
    @Query("DELETE FROM Thongtinsd x WHERE x.maTV = :maTV")
    void deleteByMaTV(@Param("maTV") Integer maTV);
    
    @Query("SELECT COUNT(t.TGVao) FROM Thongtinsd t WHERE t.TGVao IS NOT NULL")
    int getCountTVAll();
    
    @Query("SELECT tv.Khoa, COUNT(DISTINCT tv.MaTV) as Count FROM ThanhVien tv, Thongtinsd tt WHERE tv.MaTV = tt.thanhVien.MaTV GROUP BY tv.Khoa") // Sử dụng alias cho bảng
    ArrayList<Object[]> getCountTVTheoKhoa();
    
    @Query("SELECT tv.Nganh, CAST(COUNT(DISTINCT tv.MaTV) AS int) as Count FROM ThanhVien tv, Thongtinsd tt WHERE tv.MaTV = tt.thanhVien.MaTV GROUP BY tv.Nganh")
    ArrayList<Object[]> getCountTVTheoNganh();
    
    @Query(value = "SELECT\n" +
        "    CONCAT(HOUR(TGVao), 'h-', HOUR(TGVao) + 1, 'h') AS HourRange,\n" +
        "    COUNT(*) AS Count, \n" +
        "    DATE(TGVao) AS Ngay\n" +
        "FROM\n" +
        "    Thongtinsd\n" +
        "WHERE\n" +
        "    TGVao IS NOT NULL AND\n" +
        "    DATE(TGVao) = :date\n" +
        "GROUP BY\n" +
        "    DATE(TGVao), HOUR(TGVao)")
    ArrayList<Object[]> getCountTVTheoNgay(@Param("date") Date date);
    
    @Query(value = "SELECT DAY(TGVao) AS Ngay, COUNT(TGVao) AS Count " +
                   "FROM Thongtinsd " +
                   "WHERE MONTH(TGVao) = ?1 AND YEAR(TGVao) = ?2 " +
                   "GROUP BY DAY(TGVao)")
    ArrayList<Object[]> getCountTVThang(int month, int year);
    
    @Query(value = "SELECT MONTH(TGVao) AS Thang, COUNT(TGVao) "
            + "FROM Thongtinsd "
            + "WHERE YEAR(TGVao) = :year AND TGVao IS NOT NULL "
            + "GROUP BY MONTH(TGVao)")
    ArrayList<Object[]> getCountTVTheoNam(int year);
    

    @Query("SELECT tb.TenTB, tb.MaTB, COUNT(tt.thietBi.MaTB) AS Count " +
           "FROM ThietBi tb, Thongtinsd tt " +
           "WHERE tb.MaTB = tt.thietBi.MaTB AND tt.TGMuon >= :date1 AND tt.TGMuon <= :date2 " +
           "GROUP BY tb.MaTB")
    ArrayList<Object[]> getCountTBTheoKhoang(@Param("date1") Date date1, @Param("date2") Date date2);
    
    @Query(value = "SELECT  " +
            "CONCAT(HOUR(TGVao), 'h-', HOUR(TGVao) + 1, 'h') AS HourRange, " +
            "COUNT(*) AS Count, DATE(TGVao) AS Ngay " +
            "FROM Thongtinsd " +
            "WHERE TGVao IS NOT NULL AND " +
            "DATE(TGVao) BETWEEN ?1 AND ?2 " +
            "GROUP BY HOUR(TGVao)", nativeQuery = true)
    ArrayList<Object[]> getCountTVTheoKhoang(Date startDate, Date endDate);

    @Query("SELECT x FROM Thongtinsd x WHERE x.TGMuon IS NOT NULL AND x.TGTra IS NULL")
    ArrayList<Thongtinsd> getThietBiDangMuon();


    @Query("FROM Thongtinsd WHERE TGMuon IS NOT NULL AND TGTra IS NULL AND DATE(TGMuon) = :ngayCanThongKe")
    ArrayList<Thongtinsd> getThietBiDangMuonTrongNgay(@Param("ngayCanThongKe") Date ngayCanThongKe);

    @Query("FROM Thongtinsd WHERE TGMuon IS NOT NULL AND TGTra IS NULL " +
            "AND TGMuon BETWEEN :startDate AND :endDate")
    ArrayList<Thongtinsd> getThietBiDangMuonTrongKhoangThoiGian(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    @Query("SELECT t FROM Thongtinsd t WHERE t.TGMuon IS NOT NULL AND t.TGTra IS NULL AND MONTH(t.TGMuon) = :month AND YEAR(t.TGMuon) = :year")
    ArrayList<Thongtinsd> getThietBiDangMuonTrongThang(@Param("year") int year, @Param("month") int month);

    @Query("SELECT t FROM Thongtinsd t WHERE t.TGMuon IS NOT NULL AND t.TGTra IS NULL AND YEAR(t.TGMuon) = :year")
    ArrayList<Thongtinsd> getThietBiDangMuonTrongNam(@Param("year") int year);
}
