
package model;

public class LoaiXe {
    private String MaLX;
    private String TenLX;
    private int SoLuong;
    private int SoCho;

    public LoaiXe() {
    }

    public LoaiXe(String MaLX, String TenLX, int SoLuong, int SoCho) {
        this.MaLX = MaLX;
        this.TenLX = TenLX;
        this.SoLuong = SoLuong;
        this.SoCho = SoCho;
    }
    
        // Getter and Setter for MaLX
    public String getMaLX() {
        return MaLX;
    }

    public void setMaLX(String MaLX) {
        this.MaLX = MaLX;
    }

    // Getter and Setter for TenLX
    public String getTenLX() {
        return TenLX;
    }

    public void setTenLX(String TenLX) {
        this.TenLX = TenLX;
    }

    // Getter and Setter for SoLuong
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    // Getter and Setter for SoCho
    public int getSoCho() {
        return SoCho;
    }

    public void setSoCho(int SoCho) {
        this.SoCho = SoCho;
    }
}
