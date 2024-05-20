
package model;

import java.time.LocalDate;


public class HoaDon {
    private int MaHD;
    private LocalDate TGTao;
    private int TongTienThue;
    private LocalDate TGNhan;
    private LocalDate TGTra;
    private int TongTienCoc;
    private LocalDate TGCapNhat;
    private String TinhTrang;
    private String ChuThich;
    private int MaKH;
    private int MaNV;

    public HoaDon() {
    }

    public HoaDon(int MaHD, LocalDate TGTao, int TongTienThue, LocalDate TGNhan, LocalDate TGTra, int TongTienCoc, LocalDate TGCapNhat, String TinhTrang, String ChuThich, int MaKH, int MaNV) {
        this.MaHD = MaHD;
        this.TGTao = TGTao;
        this.TongTienThue = TongTienThue;
        this.TGNhan = TGNhan;
        this.TGTra = TGTra;
        this.TongTienCoc = TongTienCoc;
        this.TGCapNhat = TGCapNhat;
        this.TinhTrang = TinhTrang;
        this.ChuThich = ChuThich;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }

    public int getMaHD() {
        return MaHD;
    }

    public LocalDate getTGTao() {
        return TGTao;
    }

    public int getTongTienThue() {
        return TongTienThue;
    }

    public LocalDate getTGNhan() {
        return TGNhan;
    }

    public LocalDate getTGTra() {
        return TGTra;
    }

    public int getTongTienCoc() {
        return TongTienCoc;
    }

    public LocalDate getTGCapNhat() {
        return TGCapNhat;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public int getMaKH() {
        return MaKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setTGTao(LocalDate TGTao) {
        this.TGTao = TGTao;
    }

    public void setTongTienThue(int TongTienThue) {
        this.TongTienThue = TongTienThue;
    }

    public void setTGNhan(LocalDate TGNhan) {
        this.TGNhan = TGNhan;
    }

    public void setTGTra(LocalDate TGTra) {
        this.TGTra = TGTra;
    }

    public void setTongTienCoc(int TongTienCoc) {
        this.TongTienCoc = TongTienCoc;
    }

    public void setTGCapNhat(LocalDate TGCapNhat) {
        this.TGCapNhat = TGCapNhat;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    
}
