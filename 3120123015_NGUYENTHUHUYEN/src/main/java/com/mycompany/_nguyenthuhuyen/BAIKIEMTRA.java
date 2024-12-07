package com.mycompany._nguyenthuhuyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class BAIKIEMTRA {
    public static void main(String[] args) {
        DANHSACHBENHNHAN danhSach = new DANHSACHBENHNHAN();
        Scanner scanner = new Scanner(System.in);

        String filePath = "BENHNHAN.txt";

        try {
            docFile(filePath, danhSach);

            System.out.println("\n=== DANH SACH BENH NHAN BAN DAU ===");
            inDanhSachBenhNhan(danhSach);

            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Them benh nhan");
                System.out.println("2. Xoa benh nhan");
                System.out.println("3. Tim kiem benh nhan");
                System.out.println("4. Thoat");
                System.out.print("Chon chuc nang: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // Chức năng thêm bệnh nhân nhập tay
                        BENHNHAN benhNhanMoi = nhapBenhNhan(scanner);
                        danhSach.themBenhNhan(benhNhanMoi);
                        System.out.println("Them benh nhan thanh cong!");
                        break;

                    case 2:
                        System.out.print("Nhap ma benh nhan can xoa: ");
                        String maBenhNhanXoa = scanner.nextLine();
                        danhSach.xoaBenhNhan(maBenhNhanXoa);
                        break;

                    case 3:
                        System.out.print("Nhap ma benh nhan can tim: ");
                        String maBenhNhanTim = scanner.nextLine();
                        BENHNHAN benhNhanTimThay = danhSach.timKiemBenhNhan(maBenhNhanTim);
                        if (benhNhanTimThay != null) {
                            System.out.println("Thong tin benh nhan tim thay:");
                            System.out.println(benhNhanTimThay);
                        } else {
                            System.out.println("Khong tim thay benh nhan.");
                        }
                        break;

                    case 4:
                        System.out.println("Thoat chuong trinh.");
                        return;

                    default:
                        System.out.println("Lua chon khong hop le.");
                }

                System.out.println("\n=== DANH SACH BENH NHAN SAU CAP NHAT ===");
                inDanhSachBenhNhan(danhSach);
            }
        } catch (IOException e) {
            System.err.println("Da xay ra loi khi doc file: " + e.getMessage());
        }
    }

    public static BENHNHAN nhapBenhNhan(Scanner scanner) {
        System.out.println("\nNhap thong tin benh nhan:");

        System.out.print("Nhap loai benh nhan (1 - Bao Hiem Xa Hoi, 2 - Bao Hiem Y Te): ");
        int loaiBenhNhan = scanner.nextInt();
        scanner.nextLine(); // Xóa ký tự xuống dòng thừa

        System.out.print("Nhap ma benh nhan: ");
        String maBenhNhan = scanner.nextLine();

        System.out.print("Nhap ho ten benh nhan: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhap ngay nhap vien (YYYY-MM-DD): ");
        LocalDate ngayNhapVien = LocalDate.parse(scanner.nextLine());

        System.out.print("Nhap so dien thoai: ");
        String soDienThoai = scanner.nextLine();

        System.out.print("Nhap email (hoac nhap 'none' neu khong co): ");
        String email = scanner.nextLine();
        email = email.equalsIgnoreCase("none") ? null : email;

        System.out.print("Benh nhan co phong theo yeu cau hay khong? (true/false): ");
        boolean phongTheoYeuCau = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Nhap ma bao hiem: ");
        String maBaoHiem = scanner.nextLine();

        // Tạo đối tượng bệnh nhân tương ứng
        if (loaiBenhNhan == 1) {
            return new BENHNHANBAOHIEMXAHOI(
                    maBenhNhan, hoTen, ngayNhapVien, LocalDate.now(),
                    soDienThoai, email, phongTheoYeuCau, maBaoHiem
            );
        } else if (loaiBenhNhan == 2) {
            return new BENHNHANBAOHIEMYTE(
                    maBenhNhan, hoTen, ngayNhapVien, LocalDate.now(),
                    soDienThoai, email, phongTheoYeuCau, maBaoHiem
            );
        } else {
            System.out.println("Loai benh nhan khong hop le. Mac dinh la Bao Hiem Y Te.");
            return new BENHNHANBAOHIEMYTE(
                    maBenhNhan, hoTen, ngayNhapVien, LocalDate.now(),
                    soDienThoai, email, phongTheoYeuCau, maBaoHiem
            );
        }
    }

    public static void docFile(String filePath, DANHSACHBENHNHAN danhSach) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",\\s*");
                int loaiBenhNhan = Integer.parseInt(fields[0]);
                String maBenhNhan = fields[1];
                String hoTen = fields[2];
                LocalDate ngayNhapVien = LocalDate.parse(fields[3]);
                String soDienThoai = fields[4];
                String email = fields[5].equals("none") ? null : fields[5];
                boolean phongTheoYeuCau = Boolean.parseBoolean(fields[6]);
                String maBaoHiem = fields[7];

                if (loaiBenhNhan == 1) {
                    BENHNHAN benhNhan = new BENHNHANBAOHIEMXAHOI(
                            maBenhNhan, hoTen, ngayNhapVien, LocalDate.now(),
                            soDienThoai, email, phongTheoYeuCau, maBaoHiem
                    );
                    danhSach.themBenhNhan(benhNhan);
                } else if (loaiBenhNhan == 2) {
                    BENHNHAN benhNhan = new BENHNHANBAOHIEMYTE(
                            maBenhNhan, hoTen, ngayNhapVien, LocalDate.now(),
                            soDienThoai, email, phongTheoYeuCau, maBaoHiem
                    );
                    danhSach.themBenhNhan(benhNhan);
                }
            }
        }
    }

    public static void inDanhSachBenhNhan(DANHSACHBENHNHAN danhSach) {
        for (BENHNHAN benhNhan : danhSach.getDanhSachBenhNhan()) {
            System.out.println(benhNhan);
        }
    }
}
