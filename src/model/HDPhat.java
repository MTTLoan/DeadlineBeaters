
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
    
    
}
