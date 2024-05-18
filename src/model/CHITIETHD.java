
package model;

import java.util.Objects;

public class ChiTietHD {
    private int MaHD;
    private int MaXe;
    private int SoNgay;
    private int SoTien;
    private int MaHopDong;

    public ChiTietHD() {
    }

    public ChiTietHD(int MaHD, int MaXe, int SoNgay, int SoTien, int MaHopDong) {
        this.MaHD = MaHD;
        this.MaXe = MaXe;
        this.SoNgay = SoNgay;
        this.SoTien = SoTien;
        this.MaHopDong = MaHopDong;
    }

    public int getMaHD() {
        return MaHD;
    }

    public int getMaXe() {
        return MaXe;
    }

    public int getSoNgay() {
        return SoNgay;
    }

    public int getSoTien() {
        return SoTien;
    }

    public int getMaHopDong() {
        return MaHopDong;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaXe(int MaXe) {
        this.MaXe = MaXe;
    }

    public void setSoNgay(int SoNgay) {
        this.SoNgay = SoNgay;
    }

    public void setSoTien(int SoTien) {
        this.SoTien = SoTien;
    }

    public void setMaHopDong(int MaHopDong) {
        this.MaHopDong = MaHopDong;
    }
    
    
}
