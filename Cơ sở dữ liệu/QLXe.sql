create user sinhvien18 identified by sinhvien18;
grant connect,resource,oem_monitor, dba  to sinhvien18;

CREATE DIRECTORY HINHXE AS 'D:\hinh xe';
GRANT READ,WRITE ON DIRECTORY HINHXE TO sinhvien18;

set feedback off

CREATE TABLE KHACHHANG (
	MaKH VARCHAR2(10),
	TenKH VARCHAR2(100),
	GioiTinh VARCHAR2(5),
	NgaySinh DATE,
	DiaChi VARCHAR2(150),
	SDT	VARCHAR2(15),
	TongDoanhThu NUMBER
)
/

CREATE TABLE TAIKHOAN (
	MaNV VARCHAR2(10),
	TenTK VARCHAR2(20),
	MatKhau	VARCHAR2(20),
	HoTen VARCHAR2(100),
    GioiTinh VARCHAR2(5),
	NgaySinh DATE,
	ChucVu VARCHAR2(15),
	Luong NUMBER,
    NgayVaoLam DATE,
    MaQL VARCHAR2(10)
)
/

CREATE TABLE HOADON (
    MaHD VARCHAR2(10),
    NgayTao DATE,
    TongTien NUMBER,
    TGNhan DATE,
    TGTra DATE,
    TinhTrang VARCHAR2(20),
    ChuThich VARCHAR2(100),
    MaKH VARCHAR2(10),
    MaNV VARCHAR2(10)
)
/

CREATE TABLE CHITIETHD (
    MaHD VARCHAR2(10),
    MaXe VARCHAR2(10),
    SoGio NUMBER,
    SoTien NUMBER
)
/

CREATE TABLE LoaiXe (
    MaLX VARCHAR2(10),
    TenLX VARCHAR2(100),
    SoLuong NUMBER,
    SoCho NUMBER
);
/

CREATE TABLE XE(
    MaXe VARCHAR2(10), 
	TenXe VARCHAR2(100), 
	BienSo VARCHAR2(20), 
	TrangThai VARCHAR2(50), 
	TGBaoDuong NUMBER, 
	DonGia NUMBER, 
	ThuongHieu VARCHAR2(50), 
	TienCoc NUMBER, 
	HinhAnh BLOB, 
	MaLX VARCHAR2(10)
) 
/
/*=============================================================================================*/    
CREATE OR REPLACE NONEDITIONABLE PROCEDURE sinhvien18."INSERT_CAR_DETAILS" (
  p_car_id VARCHAR2,
  p_car_name VARCHAR2,
  p_license_plate VARCHAR2,
  p_status VARCHAR2,
  p_maintenance_time NUMBER,
  p_price NUMBER,
  p_brand VARCHAR2,
  p_deposit NUMBER,
  p_image_filename VARCHAR2,
  p_category_id VARCHAR2
) AS
  l_bfile  BFILE;
  l_blob   BLOB;
  l_dest_offset INTEGER := 1;
  l_src_offset  INTEGER := 1;
  l_lobmaxsize CONSTANT INTEGER := DBMS_LOB.LOBMAXSIZE;
BEGIN
  INSERT INTO XE ( MaXe, TenXe, BienSo, TrangThai, TGBaoDuong,DonGia, ThuongHieu, TienCoc, HinhAnh, MaLX)
  VALUES (p_car_id, p_car_name, p_license_plate, p_status, p_maintenance_time,p_price, p_brand, p_deposit, empty_blob(), p_category_id)
  RETURN HinhAnh INTO l_blob;

  l_bfile := BFILENAME('HINHXE', p_image_filename); -- Thay 'THUMUC' bằng thư mục thực tế chứa hình ảnh

  DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);

  DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);

  DBMS_LOB.fileclose(l_bfile);

  DBMS_OUTPUT.PUT_LINE('Size of the Image is: ' || DBMS_LOB.GETLENGTH(l_blob));

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    ROLLBACK;
END Insert_Car_Details;
/*=============================================================================================*/    
/

CREATE TABLE HOPDONG (
    MaHopDong VARCHAR2(10),
    NgayBD DATE,
    NgayKT DATE,
    TongTienCoc NUMBER,
    MaHD VARCHAR2(10)
)
/

CREATE TABLE HDPHAT (
    MaHDP VARCHAR2(10),
    NgayTao DATE,
    SoTien NUMBER,
    ChuThich VARCHAR2(100),
    TinhTrang VARCHAR2(50),
    HinhAnh BLOB,
    MaHopDong VARCHAR2(10)
);
/
/*=============================================================================================*/   
CREATE OR REPLACE PROCEDURE sinhvien18."INSERT_HDPHAT_DETAILS" (
  p_ma_hdp VARCHAR2,
  p_ngay_tao DATE,
  p_so_tien NUMBER,
  p_chu_thich VARCHAR2,
  p_tinh_trang VARCHAR2,
  p_image_filename VARCHAR2,
  p_ma_hop_dong VARCHAR2
) AS
  l_bfile  BFILE;
  l_blob   BLOB;
  l_dest_offset INTEGER := 1;
  l_src_offset  INTEGER := 1;
  l_lobmaxsize CONSTANT INTEGER := DBMS_LOB.LOBMAXSIZE;
BEGIN
  INSERT INTO HDPHAT (MaHDP, NgayTao, SoTien, ChuThich, TinhTrang, HinhAnh, MaHopDong)
  VALUES (p_ma_hdp, p_ngay_tao, p_so_tien, p_chu_thich, p_tinh_trang, empty_blob(), p_ma_hop_dong)
  RETURNING HinhAnh INTO l_blob;

  l_bfile := BFILENAME('HINHXE', p_image_filename);
  DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);

  DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);

  DBMS_LOB.fileclose(l_bfile);

  DBMS_OUTPUT.PUT_LINE('Size of the Image is: ' || DBMS_LOB.GETLENGTH(l_blob));

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
    ROLLBACK;
END INSERT_HDPHAT_DETAILS;
/*=============================================================================================*/   
/

CREATE TABLE DANHGIA (
    MaDG VARCHAR2(10),
    SoDiem NUMBER,
    NoiDung VARCHAR2(300),
    MaHopDong VARCHAR2(10)
)
/

ALTER TABLE KHACHHANG
 ADD CONSTRAINT INST_TenKH_NNULL CHECK ('TenKH' IS NOT NULL)
 ADD CONSTRAINT INST_NgaySinh_NNULL CHECK ('NgaySinh' IS NOT NULL)
 ADD CONSTRAINT INST_DiaChi_NNULL CHECK ('DiaChi' IS NOT NULL)
 ADD CONSTRAINT INST_SDT_NNULL CHECK ('SDT' IS NOT NULL)
/

ALTER TABLE TAIKHOAN
ADD CONSTRAINT INST_MaNV_NNULL CHECK ('MaNV' IS NOT NULL)
ADD CONSTRAINT INST_TenTK_NNULL CHECK ('TenTK' IS NOT NULL)
ADD CONSTRAINT INST_MatKhau_NNULL CHECK ('MatKhau' IS NOT NULL)
ADD CONSTRAINT INST_HoTen_NNULL CHECK ('HoTen' IS NOT NULL)
ADD CONSTRAINT INST_NgaySinh_TAIKHOAN_NNULL CHECK ('NgaySinh' IS NOT NULL)
ADD CONSTRAINT INST_ChucVu_NNULL CHECK ('ChucVu' IS NOT NULL)
ADD CONSTRAINT INST_Luong_NNULL CHECK ('Luong' IS NOT NULL)
ADD CONSTRAINT INST_NgayVaoLam_NNULL CHECK ('NgayVaoLam' IS NOT NULL)
/

ALTER TABLE HOADON
ADD CONSTRAINT INST_MaHD_NNULL CHECK ('MaHD' IS NOT NULL)
ADD CONSTRAINT INST_NgayTao_NNULL CHECK ('NgayTao' IS NOT NULL)
ADD CONSTRAINT INST_TongTien_NNULL CHECK ('TongTien' IS NOT NULL)
ADD CONSTRAINT INST_TGNhan_NNULL CHECK ('TGNhan' IS NOT NULL)
ADD CONSTRAINT INST_TGTra_NNULL CHECK ('TGTra' IS NOT NULL)
ADD CONSTRAINT INST_TinhTrang_NNULL CHECK ('TinhTrang' IS NOT NULL)
ADD CONSTRAINT INST_MaKH_NNULL CHECK ('MaKH' IS NOT NULL)
ADD CONSTRAINT INST_MaNV_HOADON_NNULL CHECK ('MaNV' IS NOT NULL)
/

ALTER TABLE CHITIETHD
ADD CONSTRAINT INST_MaHD_CHITIETHD_NNULL CHECK ('MaHD' IS NOT NULL)
ADD CONSTRAINT INST_MaXe_NNULL CHECK ('MaXe' IS NOT NULL)
ADD CONSTRAINT INST_SoGio_NNULL CHECK ('SoGio' IS NOT NULL)
ADD CONSTRAINT INST_SoTien_NNULL CHECK ('SoTien' IS NOT NULL)
/

ALTER TABLE LoaiXe
ADD CONSTRAINT INST_TenLX_NNULL CHECK ('TenLX' IS NOT NULL)
ADD CONSTRAINT INST_SoLuong_NNULL CHECK ('SoLuong' IS NOT NULL)
ADD CONSTRAINT INST_SoCho_NNULL CHECK ('SoCho' IS NOT NULL)
/

ALTER TABLE XE
ADD CONSTRAINT INST_MaXe_XE_NNULL CHECK ('MaXe' IS NOT NULL)
ADD CONSTRAINT INST_TenXe_NNULL CHECK ('TenXe' IS NOT NULL)
ADD CONSTRAINT INST_BienSo_NNULL CHECK ('BienSo' IS NOT NULL)
ADD CONSTRAINT INST_TrangThai_NNULL CHECK ('TrangThai' IS NOT NULL)
ADD CONSTRAINT INST_TGBaoDuong_NNULL CHECK ('TGBaoDuong' IS NOT NULL)
ADD CONSTRAINT INST_DonGia_NNULL CHECK ('DonGia' IS NOT NULL)
ADD CONSTRAINT INST_ThuongHieu_NNULL CHECK ('ThuongHieu' IS NOT NULL)
ADD CONSTRAINT INST_TienCoc_NNULL CHECK ('TienCoc' IS NOT NULL)
ADD CONSTRAINT INST_MaLX_XE_NNULL CHECK ('MaLX' IS NOT NULL)
/

ALTER TABLE HOPDONG
ADD CONSTRAINT INST_MaHopDong_HOPDONG_NNULL CHECK ('MaHopDong' IS NOT NULL)
ADD CONSTRAINT INST_NgayBD_NNULL CHECK ('NgayBD' IS NOT NULL)
ADD CONSTRAINT INST_NgayKT_NNULL CHECK ('NgayKT' IS NOT NULL)
ADD CONSTRAINT INST_TongTienCoc_NNULL CHECK ('TongTienCoc' IS NOT NULL)
/

ALTER TABLE HDPHAT
ADD CONSTRAINT INST_MaHDP_HDPHAT_NNULL CHECK ('MaHDP' IS NOT NULL)
ADD CONSTRAINT INST_NgayTao_HDPHAT_NNULL CHECK ('NgayTao' IS NOT NULL)
ADD CONSTRAINT INST_SoTien_HDPHAT_NNULL CHECK ('SoTien' IS NOT NULL)
ADD CONSTRAINT INST_MaHopDong_HDPHAT_NNULL CHECK ('MaHopDong' IS NOT NULL)
/

ALTER TABLE DANHGIA
ADD CONSTRAINT INST_MaDG_DANHGIA_NNULL CHECK ('MaDG' IS NOT NULL)
ADD CONSTRAINT INST_SoDiem_NNULL CHECK ('SoDiem' IS NOT NULL)
ADD CONSTRAINT INST_NoiDung_NNULL CHECK ('NoiDung' IS NOT NULL)
ADD CONSTRAINT INST_MaHopDong_DANHGIA_NNULL CHECK ('MaHopDong' IS NOT NULL)
/

-- Set Primary Keys
ALTER TABLE KHACHHANG ADD CONSTRAINT PK_KHACHHANG PRIMARY KEY (MaKH);
ALTER TABLE TAIKHOAN ADD CONSTRAINT PK_TAIKHOAN PRIMARY KEY (MaNV);
ALTER TABLE HOADON ADD CONSTRAINT PK_HOADON PRIMARY KEY (MaHD);
ALTER TABLE CHITIETHD ADD CONSTRAINT PK_CHITIETHD PRIMARY KEY (MaHD, MaXe);
ALTER TABLE LoaiXe ADD CONSTRAINT PK_LoaiXe PRIMARY KEY (MaLX);
ALTER TABLE XE ADD CONSTRAINT PK_XE PRIMARY KEY (MaXe);
ALTER TABLE HOPDONG ADD CONSTRAINT PK_HOPDONG PRIMARY KEY (MaHopDong);
ALTER TABLE HDPHAT ADD CONSTRAINT PK_HDPHAT PRIMARY KEY (MaHDP);
ALTER TABLE DANHGIA ADD CONSTRAINT PK_DANHGIA PRIMARY KEY (MaDG);
/

-- Set Foreign Keys
ALTER TABLE TAIKHOAN ADD CONSTRAINT FK_TAIKHOAN_MANAGER FOREIGN KEY (MaQL) REFERENCES TAIKHOAN(MaNV);
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH);
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_TAIKHOAN FOREIGN KEY (MaNV) REFERENCES TAIKHOAN(MaNV);
ALTER TABLE CHITIETHD ADD CONSTRAINT FK_CHITIETHD_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD);
ALTER TABLE CHITIETHD ADD CONSTRAINT FK_CHITIETHD_XE FOREIGN KEY (MaXe) REFERENCES XE(MaXe);
ALTER TABLE XE ADD CONSTRAINT FK_XE_LoaiXe FOREIGN KEY (MaLX) REFERENCES LoaiXe(MaLX);
ALTER TABLE HOPDONG ADD CONSTRAINT FK_HOPDONG_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD);
ALTER TABLE HDPHAT ADD CONSTRAINT FK_HDPHAT_HOPDONG FOREIGN KEY (MaHopDong) REFERENCES HOPDONG(MaHopDong);
ALTER TABLE DANHGIA ADD CONSTRAINT FK_DANHGIA_HOPDONG FOREIGN KEY (MaHopDong) REFERENCES HOPDONG(MaHopDong);
/

ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';

PROMPT  	Inserting the data for KHACHHANG table....
INSERT INTO KHACHHANG  VALUES ('KH001', 'Nguyễn Văn A', 'Nam', '12-10-1998', '731 Trần Hưng Đạo, Quận 5, TP Hồ Chí Minh','0938776266', 2000000);
INSERT INTO KHACHHANG  VALUES ('KH002', 'Trần Ngọc Hân', 'Nữ', '25-01-2000', '23/5 Nguyễn Trãi, Quận 5, TP Hồ Chí Minh','0912300247', 2850000);
INSERT INTO KHACHHANG  VALUES ('KH003', 'Trần Minh Long', 'Nam', '23-08-1995', '45 Nguyễn cảnh Chân, Quận 1, TP Hồ Chí Minh','0915133607', 1560000);
INSERT INTO KHACHHANG  VALUES ('KH004', 'Lê Nhật Minh', 'Nam', '30-08-2003', '50/34 Lê Đại Hành, Quận 10, TP Hồ Chí Minh','0915391312', 6930000);
INSERT INTO KHACHHANG  VALUES ('KH005', 'Lê Hoài Thương', 'Nữ', '07-10-2004', '34 Trương Định, Quận 3, TP Hồ Chí Minh','0913602103', 825000);
INSERT INTO KHACHHANG  VALUES ('KH006', 'Lê Gia Hân', 'Nữ', '06-03-2000', '227 Nguyễn Văn Cừ, Quận 5, TP Hồ Chí Minh','0905372666', 600000);
INSERT INTO KHACHHANG  VALUES ('KH007', 'Lê Đức Thịnh', 'Nam', '23-05-2002', '32/3 Trần Bình Trọng, Quận 5, TP Hồ Chí Minh','0912222798', 2520000);
INSERT INTO KHACHHANG  VALUES ('KH008', 'Nguyễn Văn Tâm', 'Nam', '12-06-1983', '45/2 An Dương Vương, Quận 5, TP Hồ Chí Minh','0913295947', 240000);
INSERT INTO KHACHHANG  VALUES ('KH009', 'Phan Thị Thanh', 'Nữ', '31-12-1989', '873 Lê Hồng Phong, Quận 5, TP Hồ Chí Minh','0979749536', 2820000);
INSERT INTO KHACHHANG  VALUES ('KH010', 'Lê Hà Vinh', 'Nam', '10-01-1990', '34/34B Nguyễn Trãi, Quận 1, TP Hồ Chí Minh','0914418539', 120000);
INSERT INTO KHACHHANG  VALUES ('KH011', 'Hà Duy Lập', 'Nam', '02-05-1998', '197  Nguyễn Văn Thủ, Phường Đa Kao, Quận 1, TP Hồ Chí Minh','0944747978', 1680000);
INSERT INTO KHACHHANG  VALUES ('KH012', 'Nguyễn Tuấn Mạnh', 'Nam', '03-09-2000', '33/9A Đường số 08, Khu phố 01, Phường Linh Xuân, Thành phố Thủ Đức, TP Hồ Chí Minh','0949234388', 600000);
INSERT INTO KHACHHANG  VALUES ('KH013', 'Trần Văn Kiên', 'Nam', '15-08-1995', '58 đường 53, Phường Tân Phong, Quận 7, TP Hồ Chí Minh','0949522905', 1300000);
INSERT INTO KHACHHANG  VALUES ('KH014', 'Nguyễn Huy Hùng', 'Nam', '04-04-2001', '18 đường Trần Ngọc Diện, Phường Thảo Điền, Thành phố Thủ Đức, TP Hồ Chí Minh','0911375199', 1050000);
INSERT INTO KHACHHANG  VALUES ('KH015', 'Vũ Thị Anh', 'Nữ', '09-03-2004', '12, Đường số 2, Phường Phú Hữu, Thành phố Thủ Đức, TP Hồ Chí Minh','0919795257', 1550000);
INSERT INTO KHACHHANG  VALUES ('KH016', 'Trần Ngọc Anh', 'Nữ', '06-04-1994', '1A Nguyễn Văn Đậu, Phường 05, Quận Phú Nhuận, TP Hồ Chí Minh','0977097698', 900000);
INSERT INTO KHACHHANG  VALUES ('KH017', 'Ngô Thị Kiều Diễm', 'Nữ', '02-05-2002', '36/38 Quốc Lộ 1A, Khu Phố 3, phường An Phú Đông, Quận 12, TP Hồ Chí Minh','0912980878', 210000);
INSERT INTO KHACHHANG  VALUES ('KH018', 'Nguyễn Thị Thuỳ Giang', 'Nữ', '12-07-2003', '13 đường số 22, Phường Bình Trị Đông B, Quận Bình Tân, TP Hồ Chí Minh','0854569729', 1200000);
INSERT INTO KHACHHANG  VALUES ('KH019', 'Nguyễn Thị Minh Anh', 'Nữ', '22-10-1990', '371 Nguyễn Kiệm, Phường 3, Quận Gò Vấp, TP Hồ Chí Minh','0917822121', 900000);
INSERT INTO KHACHHANG  VALUES ('KH020', 'Trần Khang Ninh', 'Nam', '23-11-1991', '256/30 Phan Huy ích, Phường 12, Quận Gò Vấp, TP Hồ Chí Minh','0945951146', 795000);
/
PROMPT  	Inserting the data for TAIKHOAN table....
INSERT INTO TAIKHOAN  VALUES ('NV01', 'admin', '123456', 'Phạm Ngọc Tài', 'Nam','24-06-2000', 'Admin', 8000000, '13-12-2023', NULL);
INSERT INTO TAIKHOAN  VALUES ('NV02', 'quanly', '123456', 'Bùi Xuân Thường', 'Nữ','13-07-1990', 'Quản lý', 15200000, '21-11-2023', NULL);
INSERT INTO TAIKHOAN  VALUES ('NV03', 'nhanvien', '123456', 'Trần Thị Như  Ý', 'Nữ','04-05-2002', 'Nhân viên', 6100000, '21-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV04', 'linhnvl', 'linhnvl1234', 'Nguyễn Văn Linh', 'Nam','14-01-2002', 'Nhân viên', 6100000, '21-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV05', 'phuongntp', 'phuongntp1234', 'Nguyễn Thị Phương', 'Nữ','03-09-1998', 'Nhân viên', 8000000, '21-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV06', 'binhptb', 'binhptb1234', 'Phạm Thanh Bình', 'Nam','24-01-1989', 'Nhân viên', 8000000, '27-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV07', 'phongntp', 'phongntp1234', 'Nguyễn Thanh Phong', 'Nam','17-02-2000', 'Nhân viên', 8000000, '27-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV08', 'tuyetctt', 'tuyetctt1234', 'Cao Thị Tuyết', 'Nữ','02-05-2001', 'Nhân viên', 8000000, '27-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV09', 'hienndh', 'hienndh1234', 'Nguyễn Đức Hiền', 'Nam','12-06-1998', 'Nhân viên', 8000000, '27-12-2023', 'NV02');
INSERT INTO TAIKHOAN  VALUES ('NV10', 'tuanhat', 'tuanhat1234', 'Hoàng  Anh Tuấn', 'Nam','16-01-2001', 'Nhân viên', 8000000, '15-02-2024', 'NV02');
/

ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY HH24:MI';
PROMPT  	Inserting the data for HOADON table....
INSERT INTO HOADON VALUES ('B0001', '01-01-2024 9:35', 1200000, '01-01-2024  9:00', '01-01-2024 13:00', 'Đã trả xe', NULL, 'KH001', 'NV01');
INSERT INTO HOADON VALUES ('B0002', '18-01-2024 13:45', 1050000, '20-01-2024 8:00', '21-01-2024 8:00', 'Đã trả xe', NULL, 'KH002', 'NV03');
INSERT INTO HOADON VALUES ('B0003', '10-02-2024 10:23', 660000, '10-02-2024  10:30', '10-02-2024  18:30', 'Đã trả xe', NULL, 'KH003', 'NV04');
INSERT INTO HOADON VALUES ('B0004', '14-02-2024 15:12', 840000, '15-02-2024 10:00', '16-02-2024 10:00', 'Đã trả xe', NULL, 'KH004', 'NV03');
INSERT INTO HOADON VALUES ('B0005', '17-02-2024 16:00', 825000, '17-02-2024 16:20', '18-02-2024 4:20', 'Đã trả xe', NULL, 'KH005', 'NV03');
INSERT INTO HOADON VALUES ('B0006', '19-02-2024 20:00', 600000, '20-02-2024 18:20', '20-02-2024 22:20', 'Đã trả xe', NULL, 'KH006', 'NV06');
INSERT INTO HOADON VALUES ('B0007', '20-02-2024 19:02', 2520000, '20-02-2024 23:45', '22-02-2024 23:45', 'Đã trả xe', NULL, 'KH007', 'NV02');
INSERT INTO HOADON VALUES ('B0008', '01-03-2024  7:30', 240000, '02-03-2024 8:00', '02-03-2024 16:00 ', 'Đã trả xe', NULL, 'KH008', 'NV05');
INSERT INTO HOADON VALUES ('B0009', '01-03-2024  7:30', 1800000, '02-03-2024 6:00', '02-03-2024 14:00', 'Đã trả xe', NULL, 'KH009', 'NV07');
INSERT INTO HOADON VALUES ('B0010', '10-03-2024 8:12', 600000, '10-03-2024 8:20', '10-03-2024 12:12', 'Đã trả xe', NULL, 'KH009', 'NV08');
INSERT INTO HOADON VALUES ('B0011', '15-03-2024 17:45', 800000, '15-03-2024 18:00', '15-03-2024 22:00', 'Đã trả xe', NULL, 'KH001', 'NV09');
INSERT INTO HOADON VALUES ('B0012', '23-03-2024 7:00', 120000, '23-03-2024 7:15', '23-03-2024 15:15', 'Đã trả xe', NULL, 'KH010', 'NV10');
INSERT INTO HOADON VALUES ('B0013', '03-04-2024 5:00', 1680000, '03-04-2024 5:15', '03-04-2024 13:15', 'Đã trả xe', NULL, 'KH011', 'NV08');
INSERT INTO HOADON VALUES ('B0014', '07-04-2024 15:34', 600000, '08-04-2024 17:30', '08-04-2024 21:30', 'Đã trả xe', NULL, 'KH012', 'NV03');
INSERT INTO HOADON VALUES ('B0015', '13-04-2024 10:25', 750000, '15-04-2024 5:30', '15-04-2024 17:30', 'Đã trả xe', NULL, 'KH013', 'NV05');
INSERT INTO HOADON VALUES ('B0016', '14-04-2024 9:23', 1050000, '15-04-2024 7:30', '16-04-2024 7:30', 'Đã trả xe', NULL, 'KH014', 'NV02');
INSERT INTO HOADON VALUES ('B0017', '16-04-2024 9:20', 1550000, '16-04-2024 9:25', '16-04-2024 13:25', 'Đã trả xe', NULL, 'KH015', 'NV03');
INSERT INTO HOADON VALUES ('B0018', '16-04-2024 10:12', 900000, '16-04-2024 14:45', '16-04-2024 22:45', 'Đã trả xe', NULL, 'KH016', 'NV10');
INSERT INTO HOADON VALUES ('B0019', '17-04-2024 6:30', 210000, '17-04-2024 6:45', '18-04-2024 6:45', 'Đã nhận xe', NULL, 'KH017', 'NV04');
INSERT INTO HOADON VALUES ('B0020', '17-04-2024 11:10', 1200000, '18-04-2024 5:00', '18-04-2024 13:00', 'Đã đặt xe', NULL, 'KH018', 'NV06');
INSERT INTO HOADON VALUES ('B0021', '17-04-2024 11:30', 900000, '17-04-2024 11:40', '17-04-2024 23:40', 'Đã nhận xe', NULL, 'KH019', 'NV05');
INSERT INTO HOADON VALUES ('B0022', '17-04-2024 13:15', 195000, '18-04-2024 7:45', '18-04-2024 19:45', 'Đã đặt xe', NULL, 'KH020', 'NV03');
INSERT INTO HOADON VALUES ('B0023', '17-02-2024 13:20', 600000, '19-04-2024 5:15', '19-04-2024 9:15', 'Đã đặt xe', NULL, 'KH020', 'NV03');
INSERT INTO HOADON VALUES ('B0024', '17-02-2024 14:12', 900000, '18-04-2024 13:00', '18-04-2024  1:00', 'Đã đặt xe', NULL, 'KH003', 'NV04');
INSERT INTO HOADON VALUES ('B0025', '17-02-2024 14:13', 1800000, '18-04-2024 5:00', '18-04-2024 13:00', 'Đã đặt xe', NULL, 'KH002', 'NV05');
INSERT INTO HOADON VALUES ('B0026', '17-02-2024 15:00', 6090000, '17-04-2024 15:15', '19-04-2024 15:15', 'Đã nhận xe', NULL, 'KH004', 'NV06');
INSERT INTO HOADON VALUES ('B0027', '17-02-2024 15:27', 420000, '18-04-2024 8:00', '19-04-2024 8:00', 'Đã đặt xe', NULL, 'KH009', 'NV03');
INSERT INTO HOADON VALUES ('B0028', '17-02-2024 15:34', 550000, '17-04-2024 15:45', '17-04-2024 19:45', 'Đã nhận xe', NULL, 'KH013', 'NV07');
/

PROMPT  	Inserting the data for LOAIXE table....
INSERT INTO LOAIXE (MaLX, TenLX, SoLuong, SoCho) VALUES ('LX001', 'Xe bốn chỗ', 10, 4);
INSERT INTO LOAIXE (MaLX, TenLX, SoLuong, SoCho) VALUES ('LX002', 'Xe bảy chỗ', 6, 7);
INSERT INTO LOAIXE (MaLX, TenLX, SoLuong, SoCho) VALUES ('LX003', 'Xe máy', 4, 2);
/

PROMPT  	Inserting the data for XE table....
BEGIN
Insert_Car_Details ('X01', 'HUYNDAI I10 SEDAN 2020', '51B - 22654', 'Không hư', 5, 500000, 'HUYNDAI', 10000000, 'X01.png', 'LX001');
Insert_Car_Details ('X02', 'TOYOTA VIOS 2018', '51B - 22655', 'Không hư', 3, 550000, 'TOYOTA', 10000000, 'X02.jpg', 'LX001');
Insert_Car_Details ('X03', 'MITSUBISHI ATTRAGE 2023', '51B - 22656', 'Không hư', 4, 600000, 'MITSUBISHI', 10000000, 'X03.jpg', 'LX001');
Insert_Car_Details ('X04', 'KIA SOLUTO 2020', '51B - 22657', 'Không hư', 5, 450000, 'KIA MORNING', 10000000, 'X04.jpg', 'LX001');
Insert_Car_Details ('X05', 'HONDA CITY 2017', '51B - 22658', 'Không hư', 3, 550000, 'HONDA', 10000000, 'X05.jpg', 'LX001');
Insert_Car_Details ('X06', 'HUYNDAI ACCENT 2021', '51B - 22659', 'Hư', 2, 500000, 'HUYNDAI', 10000000, 'X06.jpg', 'LX001');
Insert_Car_Details ('X07', 'KIA K3 LUXURY 2022', '51B - 22660', 'Không hư', 5, 600000, 'KIA MORNING', 10000000, 'X07.jpg', 'LX001');
Insert_Car_Details ('X08', 'MERCERDES C200 2016', '51B - 22661', 'Không hư', 6, 750000, 'MERCEDES', 10000000, 'X08.jpg', 'LX001');
Insert_Car_Details ('X09', 'MERCERDES C300 AMG 2017', '51B - 22662', 'Không hư', 7, 800000, 'MERCEDES', 10000000, 'X09.jpg', 'LX001');
Insert_Car_Details ('X10', 'LEXUS IS 300 2021', '51B - 22663', 'Không hư', 3, 700000, 'LEXUS', 10000000, 'X10.jpg', 'LX001');
Insert_Car_Details ('X11', 'TOYOTA FORTURN 2016', '51B - 22664', 'Không hư', 3, 700000, 'MITSUBISHI', 10000000, 'X11.jpg', 'LX002');
Insert_Car_Details ('X12', 'MITSUBISHI XPANDER 2023', '51B - 22665', 'Không hư', 3, 600000, 'TOYOTA', 10000000, 'X12.jpg', 'LX002');
Insert_Car_Details ('X13', 'TOYOTA AVANZA 2023', '51B - 22666', 'Không hư', 4, 600000, 'TOYOTA', 10000000, 'X13.jpg', 'LX002');
Insert_Car_Details ('X14', 'MAZDA CX8 2021', '51B - 22667', 'Không hư', 5, 750000, 'MAZDA', 10000000, 'X14.jpg', 'LX002');
Insert_Car_Details ('X15', 'HONDA CRV 2022', '51B - 22668', 'Không hư', 6, 750000, 'HONDA', 10000000, 'X15.jpg', 'LX002');
Insert_Car_Details ('X16', 'MERCEDES GLB 200 AMG 2020', '51B - 22669', 'Không hư', 4, 800000, 'MERCEDES', 10000000, 'X16.jpg', 'LX002');
Insert_Car_Details ('XM17', 'YAMAHA SIRIUS 110cc', '51B - 22670', 'Không hư', 4, 100000, 'YAMAHA', 0, 'X17.jpg', 'LX003');
Insert_Car_Details ('XM18', 'HONDA VISION 110cc', '51B - 22671', 'Không hư', 3, 130000, 'HONDA', 0, 'X18.jpg', 'LX003');
Insert_Car_Details ('XM19', 'HONDA AIR BLADE 125cc', '51B - 22672', 'Không hư', 4, 170000, 'HONDA', 0, 'X19.png', 'LX003');
Insert_Car_Details ('XM20', 'HONDA WINNERX 150cc', '51B - 22673', 'Không hư', 3, 200000, 'HONDA', 0, 'X20.jpg', 'LX003');
END;
/

PROMPT  	Inserting the data for CHITIETHD table....
INSERT INTO CHITIETHD VALUES ('B0001', 'X01', 4, 500000);
INSERT INTO CHITIETHD VALUES ('B0001', 'X11', 4, 700000);
INSERT INTO CHITIETHD VALUES ('B0002', 'X16', 24, 1050000);
INSERT INTO CHITIETHD VALUES ('B0003', 'X02', 8, 660000);
INSERT INTO CHITIETHD VALUES ('B0004', 'XM17', 24, 210000);
INSERT INTO CHITIETHD VALUES ('B0004', 'XM18', 24, 273000);
INSERT INTO CHITIETHD VALUES ('B0004', 'XM19', 24, 357000);
INSERT INTO CHITIETHD VALUES ('B0005', 'X02', 12, 825000);
INSERT INTO CHITIETHD VALUES ('B0006', 'X03', 4, 600000);
INSERT INTO CHITIETHD VALUES ('B0007', 'X03', 48, 2520000);
INSERT INTO CHITIETHD VALUES ('B0008', 'XM20', 8, 240000);
INSERT INTO CHITIETHD VALUES ('B0009', 'X04', 8, 540000);
INSERT INTO CHITIETHD VALUES ('B0009', 'X05', 8, 660000);
INSERT INTO CHITIETHD VALUES ('B0009', 'X06', 8, 600000);
INSERT INTO CHITIETHD VALUES ('B0010', 'X07', 4, 600000);
INSERT INTO CHITIETHD VALUES ('B0011', 'X09', 4, 800000);
INSERT INTO CHITIETHD VALUES ('B0012', 'XM17', 8, 120000);
INSERT INTO CHITIETHD VALUES ('B0013', 'X09', 8, 960000);
INSERT INTO CHITIETHD VALUES ('B0013', 'X12', 8, 720000);
INSERT INTO CHITIETHD VALUES ('B0014', 'X13', 4, 600000);
INSERT INTO CHITIETHD VALUES ('B0015', 'X06', 12, 750000);
INSERT INTO CHITIETHD VALUES ('B0016', 'X16', 24, 1050000);
INSERT INTO CHITIETHD VALUES ('B0017', 'X08', 4, 750000);
INSERT INTO CHITIETHD VALUES ('B0017', 'X09', 4, 800000);
INSERT INTO CHITIETHD VALUES ('B0018', 'X08', 8, 900000);
INSERT INTO CHITIETHD VALUES ('B0019', 'XM17', 24, 210000);
INSERT INTO CHITIETHD VALUES ('B0020', 'X04', 8, 540000);
INSERT INTO CHITIETHD VALUES ('B0020', 'X05', 8, 660000);
INSERT INTO CHITIETHD VALUES ('B0021', 'X07', 12, 900000);
INSERT INTO CHITIETHD VALUES ('B0022', 'XM18', 12, 195000);
INSERT INTO CHITIETHD VALUES ('B0023', 'X12', 4, 600000);
INSERT INTO CHITIETHD VALUES ('B0024', 'X12', 12, 900000);
INSERT INTO CHITIETHD VALUES ('B0025', 'X15', 8, 900000);
INSERT INTO CHITIETHD VALUES ('B0025', 'X14', 8, 900000);
INSERT INTO CHITIETHD VALUES ('B0026', 'X08', 48, 3150000);
INSERT INTO CHITIETHD VALUES ('B0026', 'X10', 48, 2940000);
INSERT INTO CHITIETHD VALUES ('B0027', 'XM20', 24, 420000);
INSERT INTO CHITIETHD VALUES ('B0028', 'X05', 4, 550000);
/

PROMPT  	Inserting the data for HOPDONG table....
INSERT INTO HOPDONG VALUES ('C0001', '01-01-2024  9:00', '01-01-2024 13:00', 20000000, 'B0001');
INSERT INTO HOPDONG VALUES ('C0002', '20-01-2024 8:00', '21-01-2024 8:00', 10000000, 'B0002');
INSERT INTO HOPDONG VALUES ('C0003', '10-02-2024  10:30', '10-02-2024  18:30', 10000000, 'B0003');
INSERT INTO HOPDONG VALUES ('C0004', '15-02-2024 10:00', '16-02-2024 10:00', 0, 'B0004');
INSERT INTO HOPDONG VALUES ('C0005', '17-02-2024 16:20', '18-02-2024 4:20', 10000000, 'B0005');
INSERT INTO HOPDONG VALUES ('C0006', '20-02-2024 18:20', '20-02-2024 22:20', 10000000, 'B0006');
INSERT INTO HOPDONG VALUES ('C0007', '20-02-2024 23:45', '22-02-2024 23:45', 10000000, 'B0007');
INSERT INTO HOPDONG VALUES ('C0008', '02-03-2024 8:00', '02-03-2024 16:00 ', 0, 'B0008');
INSERT INTO HOPDONG VALUES ('C0009', '02-03-2024 6:00', '02-03-2024 14:00', 30000000, 'B0009');
INSERT INTO HOPDONG VALUES ('C0010', '10-03-2024 8:20', '10-03-2024 12:12', 10000000, 'B0010');
INSERT INTO HOPDONG VALUES ('C0011', '15-03-2024 18:00', '15-03-2024 22:00', 10000000, 'B0011');
INSERT INTO HOPDONG VALUES ('C0012', '23-03-2024 7:15', '23-03-2024 15:15', 0, 'B0012');
INSERT INTO HOPDONG VALUES ('C0013', '03-04-2024 5:15', '03-04-2024 13:15', 20000000, 'B0013');
INSERT INTO HOPDONG VALUES ('C0014', '08-04-2024 17:30', '08-04-2024 21:30', 10000000, 'B0014');
INSERT INTO HOPDONG VALUES ('C0015', '15-04-2024 5:30', '15-04-2024 17:30', 10000000, 'B0015');
INSERT INTO HOPDONG VALUES ('C0016', '15-04-2024 7:30', '16-04-2024 7:30', 10000000, 'B0016');
INSERT INTO HOPDONG VALUES ('C0017', '16-04-2024 9:25', '16-04-2024 13:25', 20000000, 'B0017');
INSERT INTO HOPDONG VALUES ('C0018', '16-04-2024 14:45', '16-04-2024 22:45', 10000000, 'B0018');
INSERT INTO HOPDONG VALUES ('C0019', '17-04-2024 6:45', '18-04-2024 6:45', 0, 'B0019');
INSERT INTO HOPDONG VALUES ('C0020', '18-04-2024 5:00', '18-04-2024 13:00', 20000000, 'B0020');
INSERT INTO HOPDONG VALUES ('C0021', '17-04-2024 11:40', '17-04-2024 23:40', 10000000, 'B0021');
INSERT INTO HOPDONG VALUES ('C0022', '18-04-2024 7:45', '18-04-2024 19:45', 0, 'B0022');
INSERT INTO HOPDONG VALUES ('C0023', '19-04-2024 5:15', '19-04-2024 9:15', 10000000, 'B0023');
INSERT INTO HOPDONG VALUES ('C0024', '18-04-2024 13:00', '18-04-2024 1:00', 10000000, 'B0024');
INSERT INTO HOPDONG VALUES ('C0025', '18-04-2024 5:00', '18-04-2024 13:00', 20000000, 'B0025');
INSERT INTO HOPDONG VALUES ('C0026', '17-04-2024 15:15', '19-04-2024 15:15', 20000000, 'B0026');
INSERT INTO HOPDONG VALUES ('C0027', '18-04-2024 8:00', '19-04-2024 8:00', 0, 'B0027');
INSERT INTO HOPDONG VALUES ('C0028', '17-04-2024 15:45', '17-04-2024 19:45', 10000000, 'B0028');
/

PROMPT  	Inserting the data for HDPHAT table....
BEGIN
  INSERT_HDPHAT_DETAILS('P0001', '21-01-2024 13:00', 1000000, 'Vết xước lớn', 'Đã thanh toán', 'xh02.jpg', 'C0002');
  INSERT_HDPHAT_DETAILS('P0002', '16-02-2024 10:12', 3000000, 'Bể đèn hậu', 'Đã thanh toán', 'xh04.jpg', 'C0004');
  INSERT_HDPHAT_DETAILS('P0003', '02-03-2024 14:12', 5000000, 'Móp xe', 'Đã thanh toán', 'xh09.jpg', 'C0009');
  INSERT_HDPHAT_DETAILS('P0004', '02-03-2024 16:10', 7000000, 'Bể gương', 'Đã thanh toán', 'xh08.jpg', 'C0008');
  INSERT_HDPHAT_DETAILS('P0005', '15-03-2024 22:08', 2000000, 'Vết xước lớn', 'Đã thanh toán', 'xh11.jpg', 'C0011');
  INSERT_HDPHAT_DETAILS('P0006', '15-04-2024 17:45', 7000000, 'Bể gương', 'Đã thanh toán', 'xh15.jpg', 'C0015');
  INSERT_HDPHAT_DETAILS('P0007', '16-04-2024 09:35', 500000, 'Trễ hẹn trả xe không thông báo', 'Đã thanh toán', null, 'C0016');
END;
/
INSERT INTO HDPHAT (MaHDP, NgayTao, SoTien, ChuThich, TinhTrang, HinhAnh, MaHopDong) 
VALUES ('P0007', '16-04-2024 09:35', 500000, 'Trễ hẹn trả xe không thông báo', 'Đã thanh toán', empty_blob(), 'C0016');
/

PROMPT  	Inserting the data for DANHGIA table....
INSERT INTO DANHGIA  VALUES ('DG0001', 9, 'Giá cả phải chăng và dễ dàng đặt xe', 'C0001');
INSERT INTO DANHGIA  VALUES ('DG0002', 9, 'Xe được cung cấp đều mới và sạch sẽ, đảm bảo an toàn và thoải mái ', 'C0002');
INSERT INTO DANHGIA  VALUES ('DG0003', 10, 'Đội ngũ nhân viên thân thiện và chuyên nghiệp, luôn sẵn lòng hỗ trợ và giải đáp mọi thắc mắc của khách hàng.', 'C0003');
INSERT INTO DANHGIA  VALUES ('DG0004', 9, 'Quy trình thuê xe linh hoạt và tiện lợi, tiết kiệm thời gian và công sức.', 'C0004');
INSERT INTO DANHGIA  VALUES ('DG0005', 9, 'Giá cả hợp lý và minh bạch, không có phí ẩn hay phụ phí bất ngờ khi thuê xe', 'C0005');
INSERT INTO DANHGIA  VALUES ('DG0006', 9, 'Xe đạt tiêu chuẩn an toàn cao, được trang bị đầy đủ các tính năng an toàn và kiểm soát hiện đại.', 'C0006');
INSERT INTO DANHGIA  VALUES ('DG0007', 10, 'Quy trình trả xe đơn giản và thuận tiện,tiết kiệm thời gian và không gặp phải bất kỳ rắc rối nào.', 'C0007');
INSERT INTO DANHGIA  VALUES ('DG0008', 9, 'Xe được trang bị đầy đủ các tính năng hiện đại và tiện nghi, tạo nên một trải nghiệm lái xe thoải mái và tiện lợi.', 'C0008');
INSERT INTO DANHGIA  VALUES ('DG0009', 9, 'Quy trình thuê xe được tổ chức rõ ràng và minh bạch, giúp hiểu rõ về các điều khoản và điều kiện thuê xe trước khi đồng ý với đơn hàng', 'C0009');
INSERT INTO DANHGIA  VALUES ('DG0010', 9, 'Tôi đã thấy rất hài lòng với chất lượng và tính đa dạng của các loại xe được cung cấp bởi công ty, đáp ứng được mọi nhu cầu và sở thích của khách hàng.', 'C0010');
INSERT INTO DANHGIA  VALUES ('DG0011', 9, 'Dịch vụ khách hàng của công ty là một trong những điểm mạnh, với nhân viên luôn sẵn lòng lắng nghe và giúp đỡ khách hàng trong mọi tình huống.', 'C0011');
INSERT INTO DANHGIA  VALUES ('DG0012', 9, 'Dịch vụ đặt xe qua ứng dụng di động của công ty hoạt động mượt mà và tiện lợi, cho phép tôi dễ dàng quản lý đơn đặt hàng và nhận thông tin cập nhật về đơn hàng của mình.', 'C0012');
INSERT INTO DANHGIA  VALUES ('DG0013', 10, 'Tôi đã thấy rất ấn tượng với sự linh hoạt của công ty trong việc đáp ứng nhu cầu đặc biệt của khách hàng, như yêu cầu đặc biệt về loại xe hoặc điều kiện thuê xe.', 'C0013');
INSERT INTO DANHGIA  VALUES ('DG0014', 9, 'Tôi đã được hướng dẫn chi tiết về các tính năng và trang thiết bị của xe khi nhận xe, giúp tôi cảm thấy tự tin và thoải mái khi lái xe', 'C0014');
INSERT INTO DANHGIA  VALUES ('DG0015', 9, 'Tôi đã nhận được một dịch vụ thuê xe linh hoạt và tiện lợi, với các lựa chọn đa dạng cho thuê xe ngắn hạn và dài hạn', 'C0015');
INSERT INTO DANHGIA  VALUES ('DG0016', 9, 'Tôi đã được hỗ trợ và giải quyết mọi vấn đề kỹ thuật hoặc sự cố với xe một cách nhanh chóng và chuyên nghiệp từ nhân viên kỹ thuật của công ty', 'C0016');
INSERT INTO DANHGIA  VALUES ('DG0017', 10, 'Tôi đã nhận được sự hài lòng tối đa từ dịch vụ thuê xe của công ty, với sự kết hợp hoàn hảo giữa chất lượng, tiện ích và giá trị, làm cho trải nghiệm thuê xe trở nên thú vị và tiện lợi hơn bao giờ hết', 'C0017');
INSERT INTO DANHGIA  VALUES ('DG0018', 9, 'Công ty cung cấp các chương trình thưởng và điểm thưởng cho khách hàng thân thiết, tạo động lực cho tôi quay lại sử dụng dịch vụ của họ một cách thường xuyên.', 'C0018');
INSERT INTO DANHGIA  VALUES ('DG0019', 9, 'Tôi đã nhận được sự hỗ trợ tận tình và chuyên nghiệp từ nhân viên khi gặp phải vấn đề hoặc câu hỏi liên quan đến việc thuê xe, giúp tôi cảm thấy an tâm và tin tưởng.', 'C0019');
INSERT INTO DANHGIA  VALUES ('DG0020', 10, 'Tôi đã được nhận một chiếc xe sạch sẽ và đảm bảo an toàn khi nhận xe, tạo sự yên tâm và tin tưởng trong suốt thời gian thuê xe.', 'C0020');
/

