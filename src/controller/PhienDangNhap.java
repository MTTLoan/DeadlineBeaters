package controller;

import model.TaiKhoan;
import dao.TaiKhoanDAO;

public class PhienDangNhap {
    private TaiKhoan currentAcc;

    public PhienDangNhap() {
        // Initialize currentAcc, perhaps set to null initially
    }

    public TaiKhoan getCurrentAcc() {
        return currentAcc;
    }

    public void setCurrentAcc(TaiKhoan currentAcc) {
        this.currentAcc = currentAcc;
    }

    // Method to authenticate and set currentAcc
    public boolean dangNhap(String tenTaiKhoan, String matKhau) {
        TaiKhoan taiKhoan = TaiKhoanDAO.getInstance().kiemTraDangNhap(tenTaiKhoan, matKhau);
        if (taiKhoan != null) {
            currentAcc = taiKhoan;
            return true;
        }
        return false;
    }
}
