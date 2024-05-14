
package model;

public class DanhGia {
    private String MaDG;
    private int SoDiem;
    private String NoiDung;
    private String MaHopDong;

    public DanhGia() {
    }

    public DanhGia(String MaDG, int SoDiem, String NoiDung, String MaHopDong) {
        this.MaDG = MaDG;
        this.SoDiem = SoDiem;
        this.NoiDung = NoiDung;
        this.MaHopDong = MaHopDong;
    }
    
        // Getter and Setter for MaDG
    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    // Getter and Setter for SoDiem
    public int getSoDiem() {
        return SoDiem;
    }

    public void setSoDiem(int SoDiem) {
        this.SoDiem = SoDiem;
    }

    // Getter and Setter for NoiDung
    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    // Getter and Setter for MaHopDong
    public String getMaHopDong() {
        return MaHopDong;
    }

    public void setMaHopDong(String MaHopDong) {
        this.MaHopDong = MaHopDong;
    }
}
