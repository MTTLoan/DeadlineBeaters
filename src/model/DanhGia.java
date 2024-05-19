
package model;

public class DanhGia {
    private int MaDG;
    private int SoDiem;
    private String NoiDung;
    private int MaHD;

    public DanhGia() {
    }

    public DanhGia(int MaDG, int SoDiem, String NoiDung, int MaHD) {
        this.MaDG = MaDG;
        this.SoDiem = SoDiem;
        this.NoiDung = NoiDung;
        this.MaHD = MaHD;
    }

    public int getMaDG() {
        return MaDG;
    }

    public int getSoDiem() {
        return SoDiem;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaDG(int MaDG) {
        this.MaDG = MaDG;
    }

    public void setSoDiem(int SoDiem) {
        this.SoDiem = SoDiem;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    
}
