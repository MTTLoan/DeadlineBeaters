
package model;

import java.sql.Blob;

public class ChiTietHDPhat {
    private int MaHDP;
    private int MaXe;
    private String LoaiPhat;
    private int SoTien;
    private Blob HinhAnh;
    private String ChuThich;

    public ChiTietHDPhat() {
    }

    public ChiTietHDPhat(int MaHDP, int MaXe, String LoaiPhat, int SoTien, Blob HinhAnh, String ChuThich) {
        this.MaHDP = MaHDP;
        this.MaXe = MaXe;
        this.LoaiPhat = LoaiPhat;
        this.SoTien = SoTien;
        this.HinhAnh = HinhAnh;
        this.ChuThich = ChuThich;
    }

    public int getMaHDP() {
        return MaHDP;
    }

    public int getMaXe() {
        return MaXe;
    }

    public String getLoaiPhat() {
        return LoaiPhat;
    }

    public int getSoTien() {
        return SoTien;
    }

    public Blob getHinhAnh() {
        return HinhAnh;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setMaHDP(int MaHDP) {
        this.MaHDP = MaHDP;
    }

    public void setMaXe(int MaXe) {
        this.MaXe = MaXe;
    }

    public void setLoaiPhat(String LoaiPhat) {
        this.LoaiPhat = LoaiPhat;
    }

    public void setSoTien(int SoTien) {
        this.SoTien = SoTien;
    }

    public void setHinhAnh(Blob HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }
    
}
