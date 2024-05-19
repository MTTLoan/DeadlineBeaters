
package model;

import java.time.LocalDate;

public class HDPhat {
    private int MaHDP;
    private LocalDate TGTao;
    private int TongTienPhat;
    private String TinhTrang;
    private int MaHD;

    public HDPhat() {
    }

    public HDPhat(int MaHDP, LocalDate TGTao, int TongTienPhat, String TinhTrang, int MaHD) {
        this.MaHDP = MaHDP;
        this.TGTao = TGTao;
        this.TongTienPhat = TongTienPhat;
        this.TinhTrang = TinhTrang;
        this.MaHD = MaHD;
    }

    public int getMaHDP() {
        return MaHDP;
    }

    public LocalDate getTGTao() {
        return TGTao;
    }

    public int getTongTienPhat() {
        return TongTienPhat;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHDP(int MaHDP) {
        this.MaHDP = MaHDP;
    }

    public void setTGTao(LocalDate TGTao) {
        this.TGTao = TGTao;
    }

    public void setTongTienPhat(int TongTienPhat) {
        this.TongTienPhat = TongTienPhat;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }
    
}
