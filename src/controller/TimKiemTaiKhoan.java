/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TaiKhoanDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.TaiKhoan;
/**
 *
 * @author Lenovo
 */
public class TimKiemTaiKhoan {
    
    public static TimKiemTaiKhoan getInstance() {
        return new TimKiemTaiKhoan();
    }

    public ArrayList<TaiKhoan> tkTatCa(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (var i : ds) {
            if (Integer.toString(i.getMaNV()).contains(text.toLowerCase())
                || i.getTenTK().toLowerCase().contains(text.toLowerCase())
                || i.getMatKhau().toLowerCase().contains(text.toLowerCase())
                || i.getHoTen().toLowerCase().contains(text.toLowerCase())
                || i.getGioiTinh().toLowerCase().contains(text.toLowerCase())
                || i.getNgaySinh().format(dtf).contains(text.toLowerCase())
                || i.getChucVu().toLowerCase().contains(text.toLowerCase())
                || Integer.toString(i.getLuong()).contains(text.toLowerCase())
                || i.getNgayVaoLam().format(dtf).contains(text.toLowerCase())
                || Integer.toString(i.getMaQL()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkMaNV(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaNV()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkTenTK(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getTenTK().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkHoTen(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getHoTen().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkGioiTinh(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getGioiTinh().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkNgaySinh(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (var i : ds) {
            if (i.getNgaySinh().format(dtf).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkChucVu(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getChucVu().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkLuong(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getLuong()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkNgayVaoLam(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (var i : ds) {
            if (i.getNgayVaoLam().format(dtf).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoan> tkMaQL(String text) {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        ArrayList<TaiKhoan> ds = TaiKhoanDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaQL()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}
