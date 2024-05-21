
package controller;

import dao.ChiTietHDPhatDAO;
import java.util.ArrayList;
import model.ChiTietHDPhat;

public class TimKiemCTHDP {
    public static TimKiemCTHDP getInstance() {
        return new TimKiemCTHDP();
    }
    
    public ArrayList<ChiTietHDPhat> tkTatCa(String text) {
        ArrayList<ChiTietHDPhat> result = new ArrayList<>();
        ArrayList<ChiTietHDPhat> ds = ChiTietHDPhatDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaHDP()).contains(text.toLowerCase())
                || Integer.toString(i.getMaXe()).contains(text.toLowerCase())
                || i.getLoaiPhat().toLowerCase().contains(text.toLowerCase())
                || i.getChuThich().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<ChiTietHDPhat> tkMaHDP(String text) {
        ArrayList<ChiTietHDPhat> result = new ArrayList<>();
        ArrayList<ChiTietHDPhat> ds = ChiTietHDPhatDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaHDP()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<ChiTietHDPhat> tkMaXe(String text) {
        ArrayList<ChiTietHDPhat> result = new ArrayList<>();
        ArrayList<ChiTietHDPhat> ds = ChiTietHDPhatDAO.getInstance().selectAll();
        for (var i : ds) {
            if (Integer.toString(i.getMaXe()).contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<ChiTietHDPhat> tkLoaiPhat(String text) {
        ArrayList<ChiTietHDPhat> result = new ArrayList<>();
        ArrayList<ChiTietHDPhat> ds = ChiTietHDPhatDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getLoaiPhat().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
    
    public ArrayList<ChiTietHDPhat> tkChuThich(String text) {
        ArrayList<ChiTietHDPhat> result = new ArrayList<>();
        ArrayList<ChiTietHDPhat> ds = ChiTietHDPhatDAO.getInstance().selectAll();
        for (var i : ds) {
            if (i.getChuThich().toLowerCase().contains(text.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}
