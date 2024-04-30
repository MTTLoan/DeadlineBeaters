
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
    
    
}
