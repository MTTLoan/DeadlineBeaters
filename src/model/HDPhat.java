
package model;

import java.time.LocalDateTime;

public class HDPhat {
    private String MaHDP;
    private LocalDateTime NgayTao;
    private long SoTien;
    private String ChuThich;
    private String TinhTrang;
    private String MaHopDong;

    public HDPhat() {
    }

    public HDPhat(String MaHDP, LocalDateTime NgayTao, long SoTien, String ChuThich, String TinhTrang, String MaHopDong) {
        this.MaHDP = MaHDP;
        this.NgayTao = NgayTao;
        this.SoTien = SoTien;
        this.ChuThich = ChuThich;
        this.TinhTrang = TinhTrang;
        this.MaHopDong = MaHopDong;
    }
    
    // Getter and Setter for MaHDP
    public String getMaHDP() {
        return MaHDP;
    }

    public void setMaHDP(String MaHDP) {
        this.MaHDP = MaHDP;
    }

    // Getter and Setter for NgayTao
    public LocalDateTime getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(LocalDateTime NgayTao) {
        this.NgayTao = NgayTao;
    }

    // Getter and Setter for SoTien
    public long getSoTien() {
        return SoTien;
    }

    public void setSoTien(long SoTien) {
        this.SoTien = SoTien;
    }

    // Getter and Setter for ChuThich
    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

    // Getter and Setter for TinhTrang
    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    // Getter and Setter for MaHopDong
    public String getMaHopDong() {
        return MaHopDong;
    }

    public void setMaHopDong(String MaHopDong) {
        this.MaHopDong = MaHopDong;
    }
}
