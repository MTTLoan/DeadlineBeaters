
package model;

public class Xe {
    private String MaXe;
    private String TenXe;
    private String BienSo;
    private String TrangThai; 
    private int TGBaoDuong;
    private long DonGia;
    private String ThuongHieu;
    private long TienCoc; 
    private String MaLX;

    public Xe() {
    }
    
    public Xe(String MaXe, String TenXe, String BienSo, String TrangThai, int TGBaoDuong, long DonGia, String ThuongHieu, long TienCoc, String MaLX) {
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
    
    
}
