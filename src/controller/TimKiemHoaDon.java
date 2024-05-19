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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY");
        for (var i : ds) {
            if (Integer.toString(i.getMaHD()).contains(text.toLowerCase())
                || i.getTGTao().format(dtf).contains(text.toLowerCase())
                || Integer.toString(i.getTongTienThue()).contains(text.toLowerCase())
                || i.getTGNhan().format(dtf).contains(text.toLowerCase())
                || i.getTGTra().format(dtf).contains(text.toLowerCase())
                || Integer.toString(i.getTongTienCoc()).toLowerCase().contains(text.toLowerCase())
                || i.getTinhTrang().toLowerCase().contains(text.toLowerCase())
                || Integer.toString(i.getMaKH()).contains(text.toLowerCase())
                || Integer.toString(i.getMaNV()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkMaHD(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaHD()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTGTao(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY");
        for (var i : ds) {
            if (i.getTGTao().format(dtf).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTongTienThue(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getTongTienThue()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkTGNhan(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY");
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD-MM-YYYY");
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
            if (Integer.toString(i.getTongTienCoc()).contains(text.toLowerCase())) {
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
            if (Integer.toString(i.getMaKH()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<HoaDon> tkMaNV(String text) {
        ArrayList<HoaDon> result = new ArrayList<>();
        ArrayList<HoaDon> ds = HoaDonDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaNV()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}