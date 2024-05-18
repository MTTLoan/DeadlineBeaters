
package model;

public class DanhGia {
    private Integer MaDG;
    private int SoDiem;
    private String NoiDung;
    private int MaHD;

    public DanhGia() {
    }

    public DanhGia(Integer MaDG, int SoDiem, String NoiDung, int MaHD) {
        this.MaDG = MaDG;
        this.SoDiem = SoDiem;
        this.NoiDung = NoiDung;
        this.MaHD = MaHD;
    }

    public DanhGia(Object object, String SoDiem, String NoiDung, String MaHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        // Getter and Setter for MaDG
    public Integer getMaDG() {
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

    public void setMaDG(Integer MaDG) {
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
