
package model;

public class Xe {
    private int MaXe;
    private String TenXe;
    private String BienSo;
    private String TrangThai; 
    private int TGBaoDuong;
    private int DonGia;
    private String ThuongHieu;
    private int TienCoc; 
    private int MaLX;

    public Xe() {
    }

    public Xe(int MaXe, String TenXe, String BienSo, String TrangThai, int TGBaoDuong, int DonGia, String ThuongHieu, int TienCoc, int MaLX) {
        this.MaXe = MaXe;
        this.TenXe = TenXe;
        this.BienSo = BienSo;
        this.TrangThai = TrangThai;
        this.TGBaoDuong = TGBaoDuong;
        this.DonGia = DonGia;
        this.ThuongHieu = ThuongHieu;
        this.TienCoc = TienCoc;
        this.MaLX = MaLX;
    }

    public int getMaXe() {
        return MaXe;
    }

    public String getTenXe() {
        return TenXe;
    }

    public String getBienSo() {
        return BienSo;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public int getTGBaoDuong() {
        return TGBaoDuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public int getTienCoc() {
        return TienCoc;
    }

    public int getMaLX() {
        return MaLX;
    }

    public void setMaXe(int MaXe) {
        this.MaXe = MaXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setTGBaoDuong(int TGBaoDuong) {
        this.TGBaoDuong = TGBaoDuong;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public void setTienCoc(int TienCoc) {
        this.TienCoc = TienCoc;
    }

    public void setMaLX(int MaLX) {
        this.MaLX = MaLX;
    }
    
}
