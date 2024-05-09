
package model;

import java.time.LocalDateTime;


public class HoaDon {
    private String MaHD;
    private LocalDateTime TGTao;
    private long TongTien;
    private LocalDateTime TGNhan;
    private LocalDateTime TGTra;
    private long TongTienCoc;
    private LocalDateTime TGCapNhat;
    private String TinhTrang;
    private String ChuThich;
    private String MaKH;
    private String MaNV;

    public HoaDon() {
    }

    public HoaDon(String MaHD, LocalDateTime TGTao, long TongTien, LocalDateTime TGNhan, LocalDateTime TGTra, long TongTienCoc, LocalDateTime TGCapNhat, String TinhTrang, String ChuThich, String MaKH, String MaNV) {
        this.MaHD = MaHD;
        this.TGTao = TGTao;
        this.TongTien = TongTien;
        this.TGNhan = TGNhan;
        this.TGTra = TGTra;
        this.TongTienCoc = TongTienCoc;
        this.TGCapNhat = TGCapNhat;
        this.TinhTrang = TinhTrang;
        this.ChuThich = ChuThich;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }

    public String getMaHD() {
        return MaHD;
    }

    public LocalDateTime getTGTao() {
        return TGTao;
    }

    public long getTongTien() {
        return TongTien;
    }

    public LocalDateTime getTGNhan() {
        return TGNhan;
    }

    public LocalDateTime getTGTra() {
        return TGTra;
    }

    public long getTongTienCoc() {
        return TongTienCoc;
    }

    public LocalDateTime getTGCapNhat() {
        return TGCapNhat;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setTGTao(LocalDateTime TGTao) {
        this.TGTao = TGTao;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public void setTGNhan(LocalDateTime TGNhan) {
        this.TGNhan = TGNhan;
    }

    public void setTGTra(LocalDateTime TGTra) {
        this.TGTra = TGTra;
    }

    public void setTongTienCoc(long TongTienCoc) {
        this.TongTienCoc = TongTienCoc;
    }

    public void setTGCapNhat(LocalDateTime TGCapNhat) {
        this.TGCapNhat = TGCapNhat;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}
