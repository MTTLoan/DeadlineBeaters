package controller;

import dao.XeDAO;
import java.util.ArrayList;
import model.Xe;

public class TimKiemXe {
    
    public static TimKiemXe getInstance() {
        return new TimKiemXe();
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
}

