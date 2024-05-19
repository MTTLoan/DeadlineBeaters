
package model;

public class LoaiXe {
    private int MaLX;
    private String TenLX;
    private int SoLuong;
    private int SoCho;

    public LoaiXe() {
    }

    public LoaiXe(int MaLX, String TenLX, int SoLuong, int SoCho) {
        this.MaLX = MaLX;
        this.TenLX = TenLX;
        this.SoLuong = SoLuong;
        this.SoCho = SoCho;
    }

    public int getMaLX() {
        return MaLX;
    }

    public String getTenLX() {
        return TenLX;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public int getSoCho() {
        return SoCho;
    }

    public void setMaLX(int MaLX) {
        this.MaLX = MaLX;
    }

    public void setTenLX(String TenLX) {
        this.TenLX = TenLX;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setSoCho(int SoCho) {
        this.SoCho = SoCho;
    }
    
}
