
package model;

import java.time.LocalDateTime;

public class HopDong {
    private String MaHopDong;
    private LocalDateTime NgayBD;
    private LocalDateTime NgayKT;
    private long TongTienCoc;
    private String MaHD;

    public HopDong() {
    }

    public HopDong(String MaHopDong, LocalDateTime NgayBD, LocalDateTime NgayKT, long TongTienCoc, String MaHD) {
        this.MaHopDong = MaHopDong;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.TongTienCoc = TongTienCoc;
        this.MaHD = MaHD;
    }
    
     // Getter and Setter for MaHopDong
    public String getMaHopDong() {
        return MaHopDong;
    }

    public void setMaHopDong(String MaHopDong) {
        this.MaHopDong = MaHopDong;
    }

    // Getter and Setter for NgayBD
    public LocalDateTime getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(LocalDateTime NgayBD) {
        this.NgayBD = NgayBD;
    }

    // Getter and Setter for NgayKT
    public LocalDateTime getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(LocalDateTime NgayKT) {
        this.NgayKT = NgayKT;
    }

    // Getter and Setter for TongTienCoc
    public long getTongTienCoc() {
        return TongTienCoc;
    }

    public void setTongTienCoc(long TongTienCoc) {
        this.TongTienCoc = TongTienCoc;
    }

    // Getter and Setter for MaHD
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
}
