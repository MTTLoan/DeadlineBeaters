
package model;

public class DanhGia {
    private int MaDG;
    private int SoDiem;
    private String NoiDung;
    private int MaHopDong;

    public DanhGia() {
    }

    public DanhGia(int MaDG, int SoDiem, String NoiDung, int MaHopDong) {
        this.MaDG = MaDG;
        this.SoDiem = SoDiem;
        this.NoiDung = NoiDung;
        this.MaHopDong = MaHopDong;
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

    public int getMaHopDong() {
        return MaHopDong;
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

    public void setMaHopDong(int MaHopDong) {
        this.MaHopDong = MaHopDong;
    }
}
