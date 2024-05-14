/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DanhGiaDAO;
import java.util.ArrayList;
import model.DanhGia;
/**
 *
 * @author Lenovo
 */

public class TimKiemDanhGia {
    public static TimKiemDanhGia getInstance() {
        return new TimKiemDanhGia();
    }

    public ArrayList<DanhGia> tkTatCa(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getMaDG().toLowerCase().contains(text.toLowerCase())
                || Integer.toString(i.getSoDiem()).contains(text.toLowerCase())
                || i.getNoiDung().toLowerCase().contains(text.toLowerCase())
                || i.getMaHopDong().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DanhGia> tkMaDG(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getMaDG().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DanhGia> tkSoDiem(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getSoDiem()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DanhGia> tkNoiDung(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getNoiDung().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DanhGia> tkMaHopDong(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getMaHopDong().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}
