/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._nguyenthuhuyen;

import java.util.ArrayList;
import java.util.List;

public class DANHSACHBENHNHAN {
    private List<BENHNHAN> danhSach;

    public DANHSACHBENHNHAN() {
        this.danhSach = new ArrayList<>();
    }

    public void themBenhNhan(BENHNHAN benhNhan) {
        danhSach.add(benhNhan);
    }

    public void xoaBenhNhan(String maBenhNhan) {
        danhSach.removeIf(benhNhan -> benhNhan.maBenhNhan.equals(maBenhNhan));
    }

    public BENHNHAN timKiemBenhNhan(String maBenhNhan) {
        for (BENHNHAN benhNhan : danhSach) {
            if (benhNhan.maBenhNhan.equals(maBenhNhan)) {
                return benhNhan;
            }
        }
        return null;
    }
    
    public List<BENHNHAN> getDanhSachBenhNhan() {
        return danhSach;
    }

    public double tinhTongVienPhi(Class<?> loaiBenhNhan) {
        double tongTien = 0;
        for (BENHNHAN benhNhan : danhSach) {
            if (loaiBenhNhan.isInstance(benhNhan)) {
                tongTien += ((IVIENPHI) benhNhan).tinhHoaDonVienPhi();
            }
        }
        return tongTien;
    }
}
