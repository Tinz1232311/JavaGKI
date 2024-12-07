/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._nguyenthuhuyen;

import java.time.LocalDate;

public class BENHNHANBAOHIEMXAHOI extends BENHNHAN implements IVIENPHI {
    private String maBaoHiemXaHoi;

    public BENHNHANBAOHIEMXAHOI(String maBenhNhan, String hoTen, LocalDate ngayNhapVien, LocalDate ngayRaVien,
                                 String soDienThoai, String email, boolean phongTheoYeuCau, String maBaoHiemXaHoi) {
        super(maBenhNhan, hoTen, ngayNhapVien, ngayRaVien, soDienThoai, email, phongTheoYeuCau);
        this.maBaoHiemXaHoi = maBaoHiemXaHoi;
    }

    @Override
    public double tinhHoaDonVienPhi() {
        long soNgay = tinhSoNgayNhapVien();
        if (phongTheoYeuCau) {
            return soNgay * DON_GIA_PHONG * 200000;
        } else {
            return soNgay * DON_GIA_PHONG;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Ma Bao Hiem: " + maBaoHiemXaHoi + " (BHXH)";
    }
}
