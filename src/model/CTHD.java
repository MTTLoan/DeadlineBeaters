
package model;

public class CTHD {
    private String MaHD;
    private String MaXe;
    private int SoGio;
    private long SoTien;

    public CTHD() {
    }

    public CTHD(String MaHD, String MaXe, int SoGio, long SoTien) {
        this.MaHD = MaHD;
        this.MaXe = MaXe;
        this.SoGio = SoGio;
        this.SoTien = SoTien;
    }
    
     // Getter and Setter for MaHD
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    // Getter and Setter for MaXe
    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    // Getter and Setter for SoGio
    public int getSoGio() {
        return SoGio;
    }

    public void setSoGio(int SoGio) {
        this.SoGio = SoGio;
    }

    // Getter and Setter for SoTien
    public long getSoTien() {
        return SoTien;
    }

    public void setSoTien(long SoTien) {
        this.SoTien = SoTien;
    }
}

