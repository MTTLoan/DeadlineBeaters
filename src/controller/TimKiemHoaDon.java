/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.HoaDonDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.HoaDon;

/**
 *
 * @author ASUS
 */
public class TimKiemHoaDon {
    
    public static TimKiemHoaDon getInstance() {
        return new TimKiemHoaDon();
    }
    
    public ArrayList<HoaDon> tkTatCa(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY HH24:MI");
        for (var i : ds) {
            if (i.getMaHD().toLowerCase().contains(text.toLowerCase())
                || i.getTGTao().format(dtf).contains(text.toLowerCase())
                || Long.toString(i.getTongTien()).contains(text.toLowerCase())
                || i.getTGNhan().format(dtf).contains(text.toLowerCase())
                || i.getTGTra().format(dtf).contains(text.toLowerCase())
                || Long.toString(i.getTongTienCoc()).toLowerCase().contains(text.toLowerCase())
                || i.getTinhTrang().toLowerCase().contains(text.toLowerCase())
                || i.getMaKH().toLowerCase().contains(text.toLowerCase())
                || i.getMaNV().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkMaHD(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getMaHD().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTGTao(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY HH24:MI");
        for (var i : ds) {
            if (i.getTGTao().format(dtf).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTongTien(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Long.toString(i.getTongTien()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTGNhan(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY HH24:MI");
        for (var i : ds) {
            if (i.getTGNhan().format(dtf).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTGTra(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY HH24:MI");
        for (var i : ds) {
            if (i.getTGTra().format(dtf).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTongTienCoc(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Long.toString(i.getTongTienCoc().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTinhTrang(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getTinhTrang().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkMaKH(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getMaKH().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkMaNV(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getMaNV().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}
