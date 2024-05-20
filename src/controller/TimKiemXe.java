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
public class TimKiemXe {
    
    public static TimKiemXe getInstance() {
        return new TimKiemXe();
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
        int loaiXe = switch (text) {
                        case "Xe bốn chỗ " -> 3001;
                        case "Xe bảy chỗ " -> 3002;
                        default -> 3003;
                    };
        for (var i : ds) {
            if (i.getMaLX() == loaiXe) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<Xe> tkDonGia(ArrayList<Xe> ds, String text) {
        ArrayList<Xe> result = new ArrayList<>();
        for (var i : ds) {
            if (Integer.toString(i.getDonGia()).contains(text.toLowerCase())) {
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
