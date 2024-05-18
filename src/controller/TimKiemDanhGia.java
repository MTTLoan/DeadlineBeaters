package controller;

import dao.DanhGiaDAO;
import java.util.ArrayList;
import model.DanhGia;

public class TimKiemDanhGia {

    public static TimKiemDanhGia getInstance() {
        return new TimKiemDanhGia();
    }

    public ArrayList<DanhGia> tkTatCa(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaDG()).contains(text.toLowerCase())
                || Integer.toString(i.getSoDiem()).contains(text.toLowerCase())
                || i.getNoiDung().toLowerCase().contains(text.toLowerCase())
                || Integer.toString(i.getMaHD()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<DanhGia> tkMaDG(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaDG()).contains(text.toLowerCase())) {
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

    public ArrayList<DanhGia> tkMaHD(String text) {
        ArrayList<DanhGia> result = new ArrayList<>();
        ArrayList<DanhGia> ds = DanhGiaDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaHD()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}
