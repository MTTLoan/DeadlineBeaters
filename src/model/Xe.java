package model;

public class Xe {
    private Integer MaXe;
    private String TenXe;
    private String BienSo;
    private String TrangThai; 
    private int TGBaoDuong;
    private long DonGia;
    private String ThuongHieu;
    private long TienCoc; 
    private int MaLX;

    public Xe() {
    }
    
    public Xe(Integer MaXe, String TenXe, String BienSo, String TrangThai, int TGBaoDuong, long DonGia, String ThuongHieu, long TienCoc, int MaLX) {
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

    // Getter and Setter for MaXe
    public Integer getMaXe() {
        return MaXe;
    }

    public void setMaXe(Integer MaXe) {
        this.MaXe = MaXe;
    }

    // Getter and Setter for TenXe
    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    // Getter and Setter for BienSo
    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    // Getter and Setter for TrangThai
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    // Getter and Setter for TGBaoDuong
    public int getTGBaoDuong() {
        return TGBaoDuong;
    }

    public void setTGBaoDuong(int TGBaoDuong) {
        this.TGBaoDuong = TGBaoDuong;
    }

    // Getter and Setter for DonGia
    public long getDonGia() {
        return DonGia;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

    // Getter and Setter for ThuongHieu
    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    // Getter and Setter for TienCoc
    public long getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(long TienCoc) {
        this.TienCoc = TienCoc;
    }

    // Getter and Setter for MaLX
    public int getMaLX() {
        return MaLX;
    }

    public void setMaLX(int MaLX) {
        this.MaLX = MaLX;
    }
}
