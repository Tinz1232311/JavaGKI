/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._nguyenthuhuyen;

import java.time.LocalDate;

public class BENHNHANBAOHIEMYTE extends BENHNHAN implements IVIENPHI {
    private String maBaoHiemYTe;

    public BENHNHANBAOHIEMYTE(String maBenhNhan, String hoTen, LocalDate ngayNhapVien, LocalDate ngayRaVien,
                               String soDienThoai, String email, boolean phongTheoYeuCau, String maBaoHiemYTe) {
        super(maBenhNhan, hoTen, ngayNhapVien, ngayRaVien, soDienThoai, email, phongTheoYeuCau);
        this.maBaoHiemYTe = maBaoHiemYTe;
    }

    @Override
    public double tinhHoaDonVienPhi() {
        long soNgay = tinhSoNgayNhapVien();
        if (phongTheoYeuCau) {
            double tienPhong = soNgay * DON_GIA_PHONG * 200000;
            double tienBaoHiem = (soNgay * DON_GIA_PHONG) * 0.7;
            return tienPhong - tienBaoHiem;
        } else {
            double tienPhong = soNgay * DON_GIA_PHONG;
            double tienBaoHiem = tienPhong * 0.7;
            return tienPhong - tienBaoHiem;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Ma Bao Hiem: " + maBaoHiemYTe + " (BHYT)";
    }
}
