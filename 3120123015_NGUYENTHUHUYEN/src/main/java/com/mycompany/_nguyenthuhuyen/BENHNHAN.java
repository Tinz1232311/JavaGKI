/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._nguyenthuhuyen;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BENHNHAN {
    protected String maBenhNhan;
    protected String hoTen;
    protected LocalDate ngayNhapVien;
    protected LocalDate ngayRaVien;
    protected String soDienThoai;
    protected String email;
    protected boolean phongTheoYeuCau;

    public BENHNHAN(String maBenhNhan, String hoTen, LocalDate ngayNhapVien, LocalDate ngayRaVien,
                    String soDienThoai, String email, boolean phongTheoYeuCau) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.phongTheoYeuCau = phongTheoYeuCau;
    }

    public long tinhSoNgayNhapVien() {
        return ChronoUnit.DAYS.between(ngayNhapVien, ngayRaVien);
    }
    
    @Override
    public String toString() {
        return "Ma Benh Nhan: " + maBenhNhan +
               ", Ho Ten: " + hoTen +
               ", Ngay Nhap Vien: " + ngayNhapVien +
               ", Ngay Xuat Vien: " + ngayRaVien +
               ", So Dien Thoai: " + soDienThoai +
               ", Email: " + (email != null ? email : "Khong co") +
               ", Phong Theo Yeu Cau: " + (phongTheoYeuCau ? "Co" : "Khong");
    }
}