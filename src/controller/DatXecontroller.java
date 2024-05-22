/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.XeDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Xe;

/**
 *
 * @author ASUS
 */
public class DatXecontroller {
    
    public static DatXecontroller getInstance() {
        return new DatXecontroller();
    }
    
    public ArrayList<Xe> tkTatCa(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaXe()).contains(text.toLowerCase())
                || i.getTenXe().toLowerCase().contains(text.toLowerCase())
                || i.getBienSo().toLowerCase().contains(text.toLowerCase())
                || i.getTrangThai().toLowerCase().contains(text.toLowerCase())
                || Integer.toString(i.getTGBaoDuong()).contains(text.toLowerCase())
                || Long.toString(i.getDonGia()).contains(text.toLowerCase())
                || i.getThuongHieu().toLowerCase().contains(text.toLowerCase())
                || Long.toString(i.getTienCoc()).contains(text.toLowerCase())
                || Integer.toString(i.getMaLX()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkMaXe(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaXe()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkTenXe(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getTenXe().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkBienSo(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getBienSo().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkTrangThai(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getTrangThai().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkTGBaoDuong(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getTGBaoDuong()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
        public ArrayList<Xe> tkDonGia(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Long.toString(i.getDonGia()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkThuongHieu(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getThuongHieu().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkTienCoc(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Long.toString(i.getTienCoc()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkMaLX(String text) {
        ArrayList<Xe> result = new ArrayList<>();
        ArrayList<Xe> ds = XeDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaLX()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Object[]> getTopRentedCars(int month, int year) {
        return XeDAO.getInstance().getTopRentedCars(month, year);
    }
    
    public ArrayList<Xe> tkMaXe(ArrayList<Xe> ds, String text) {
        ArrayList<Xe> result = new ArrayList<>();
        for (var i : ds) {
            if (Integer.toString(i.getMaXe()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkTenXe(ArrayList<Xe> ds, String text) {
        ArrayList<Xe> result = new ArrayList<>();
        for (var i : ds) {
            if (i.getTenXe().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkLoaiXe(ArrayList<Xe> ds, String text) {
        ArrayList<Xe> result = new ArrayList<>();
        for (var i : ds) {
            if (Integer.toString(i.getMaLX()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkDonGia(ArrayList<Xe> ds, String text) {
        ArrayList<Xe> result = new ArrayList<>();
        for (var i : ds) {
            if (i.getDonGia() < Integer.parseInt(text)) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkTG(LocalDate TGNhan, LocalDate TGTra) {
        ArrayList<Xe> result;
        result = XeDAO.getInstance().selectAllTG(TGNhan, TGTra);
        return result;
    }
    
}
