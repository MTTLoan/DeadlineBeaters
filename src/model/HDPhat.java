
package model;

import java.time.LocalDate;

public class HDPhat {
    private int MaHDP;
    private LocalDate NgayTao;
    private int TongTienPhat;
    private String TinhTrang;
    private int MaHD;

    public HDPhat() {
    }

    public HDPhat(int MaHDP, LocalDate NgayTao, int TongTienPhat, String TinhTrang, int MaHD) {
        this.MaHDP = MaHDP;
        this.NgayTao = NgayTao;
        this.TongTienPhat = TongTienPhat;
        this.TinhTrang = TinhTrang;
        this.MaHD = MaHD;
    }

    
}
