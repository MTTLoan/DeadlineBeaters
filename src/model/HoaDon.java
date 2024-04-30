
package model;

import java.time.LocalDateTime;


public class HoaDon {
    private String MaHD;
    private LocalDateTime NgayTao;
    private int TongTien;
    private LocalDateTime TGNhan;
    private LocalDateTime TGTra;
    private String TinhTrang;
    private String ChuThich;
    private String MaKH;
    private String MaNV;

    public HoaDon() {
    }

    public HoaDon(String MaHD, LocalDateTime NgayTao, int TongTien, LocalDateTime TGNhan, LocalDateTime TGTra, String TinhTrang, String ChuThich, String MaKH, String MaNV) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.TGNhan = TGNhan;
        this.TGTra = TGTra;
        this.TinhTrang = TinhTrang;
        this.ChuThich = ChuThich;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
    }
    
    
}
