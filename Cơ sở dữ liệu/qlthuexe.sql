/*
-- DROP TABLE
DROP TABLE "KHACHHANG" CASCADE CONSTRAINTS;
DROP TABLE "TAIKHOAN" CASCADE CONSTRAINTS;
DROP TABLE "LOAIXE" CASCADE CONSTRAINTS;
DROP TABLE "XE" CASCADE CONSTRAINTS;
DROP TABLE "HOADON" CASCADE CONSTRAINTS;
DROP TABLE "CHITIETHD" CASCADE CONSTRAINTS;
DROP TABLE "DANHGIA" CASCADE CONSTRAINTS;
DROP TABLE "HDPHAT" CASCADE CONSTRAINTS;
DROP TABLE "CHITIETHDPHAT" CASCADE CONSTRAINTS;
-- DROP SEQUENCE
DROP SEQUENCE KHACHHANG_SEQ;
DROP SEQUENCE DANHGIA_SEQ;
DROP SEQUENCE HOADON_SEQ;
DROP SEQUENCE LOAIXE_SEQ;
DROP SEQUENCE TAIKHOAN_SEQ;
DROP SEQUENCE HDPHAT_SEQ;
DROP SEQUENCE XE_SEQ;
DROP SEQUENCE HOPDONG_SEQ;
 ------------------ 
 -- sys tao hinh anh
CREATE DIRECTORY hinhxe AS 'D:\hinh xe';

GRANT READ, WRITE ON DIRECTORY hinhxe TO qlthuexe;

SELECT * FROM DBA_DIRECTORIES
-----------------------

--- Tao bang
set feedback off
*/

CREATE TABLE KHACHHANG (
	MaKH NUMBER,
	TenKH VARCHAR2(100),
	GioiTinh VARCHAR2(5),
	NgaySinh DATE,
	DiaChi VARCHAR2(150),
	SDT	VARCHAR2(15),
	TongDoanhThu NUMBER
)
/

CREATE TABLE TAIKHOAN (
	MaNV NUMBER,
	TenTK VARCHAR2(20),
	MatKhau	VARCHAR2(20),
	HoTen VARCHAR2(100),
    GioiTinh VARCHAR2(5),
	NgaySinh DATE,
	ChucVu VARCHAR2(15),
	Luong NUMBER,
    NgayVaoLam DATE,
    MaQL NUMBER
)
/

CREATE TABLE HOADON (
    MaHD NUMBER,
    TGTao DATE,
    TongTienThue NUMBER,
    TGNhan DATE,
    TGTra DATE,
    TongTienCoc NUMBER,
    TGCapNhat DATE,
    TinhTrang VARCHAR2(20),
    ChuThich VARCHAR2(100),
    MaKH NUMBER,
    MaNV NUMBER  
)
/
CREATE TABLE CHITIETHD (
    MaHD NUMBER,
    MaXe NUMBER,
    SoNgay NUMBER,
    SoTien NUMBER,
    MaHopDong NUMBER
)
/

CREATE TABLE LoaiXe (
    MaLX NUMBER,
    TenLX VARCHAR2(100),
    SoLuong NUMBER,
    SoCho NUMBER
)
/

CREATE TABLE XE(
    MaXe NUMBER, 
	TenXe VARCHAR2(100), 
	BienSo VARCHAR2(20), 
	TrangThai VARCHAR2(50), 
	TGBaoDuong NUMBER, 
	DonGia NUMBER, 
	ThuongHieu VARCHAR2(50), 
	TienCoc NUMBER, 
	MaLX NUMBER
) 
/
CREATE TABLE HDPHAT (
    MaHDP NUMBER,
    TGTao DATE,
    TongTienPhat NUMBER,
    TinhTrang VARCHAR2(50),
    MaHD NUMBER
)
/
CREATE TABLE CHITIETHDPHAT(
    MaHDP NUMBER,
    MaXe NUMBER,
    LoaiPhat VARCHAR2(20),
    SoTien NUMBER,
    HinhAnh BLOB,
    ChuThich VARCHAR(100)
)
/
CREATE TABLE DANHGIA (
    MaDG NUMBER,
    SoDiem NUMBER,
    NoiDung VARCHAR2(300),
    MaHD NUMBER
)
/

ALTER TABLE KHACHHANG
ADD CONSTRAINT INST_MaKH_NNULL CHECK ('MaKH' IS NOT NULL)
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
ADD CONSTRAINT UNIQUE_TenTK_UNI UNIQUE (TenTK);
/

ALTER TABLE HOADON
ADD CONSTRAINT INST_MaHD_NNULL CHECK ('MaHD' IS NOT NULL)
ADD CONSTRAINT INST_TGTao_NNULL CHECK ('TGTao' IS NOT NULL)
ADD CONSTRAINT INST_TongTienThue_NNULL CHECK ('TongTienThue' IS NOT NULL)
ADD CONSTRAINT INST_TGNhan_NNULL CHECK ('TGNhan' IS NOT NULL)
ADD CONSTRAINT INST_TGTra_NNULL CHECK ('TGTra' IS NOT NULL)
ADD CONSTRAINT INST_TongTienCoc_NNULL CHECK ('TongTienCoc' IS NOT NULL)
ADD CONSTRAINT INST_TGCapNhat_NNULL CHECK ('TGCapNhat' IS NOT NULL)
ADD CONSTRAINT INST_TinhTrang_NNULL CHECK ('TinhTrang' IS NOT NULL)
ADD CONSTRAINT INST_MaKH_HOADON_NNULL CHECK ('MaKH' IS NOT NULL)
ADD CONSTRAINT INST_MaNV_HOADON_NNULL CHECK ('MaNV' IS NOT NULL)
/

ALTER TABLE CHITIETHD
ADD CONSTRAINT INST_MaHD_CHITIETHD_NNULL CHECK ('MaHD' IS NOT NULL)
ADD CONSTRAINT INST_MaXe_CHITIETHD_NNULL CHECK ('MaXe' IS NOT NULL)
ADD CONSTRAINT INST_SoNgay_NNULL CHECK ('SoNgay' IS NOT NULL)
ADD CONSTRAINT INST_SoTien_NNULL CHECK ('SoTien' IS NOT NULL)
ADD CONSTRAINT INST_MaHopDong_NNULL CHECK ('MaHopDong' IS NOT NULL)
ADD CONSTRAINT UNIQUE_MaHopDong_UNI UNIQUE (MaHopDong);
/

ALTER TABLE LoaiXe
ADD CONSTRAINT INST_MaLX_NNULL CHECK ('MaLX' IS NOT NULL)
ADD CONSTRAINT INST_TenLX_NNULL CHECK ('TenLX' IS NOT NULL)
ADD CONSTRAINT INST_SoLuong_NNULL CHECK ('SoLuong' IS NOT NULL)
ADD CONSTRAINT INST_SoCho_NNULL CHECK ('SoCho' IS NOT NULL)
/

ALTER TABLE XE
ADD CONSTRAINT INST_MaXe_NNULL CHECK ('MaXe' IS NOT NULL)
ADD CONSTRAINT INST_TenXe_NNULL CHECK ('TenXe' IS NOT NULL)
ADD CONSTRAINT INST_BienSo_NNULL CHECK ('BienSo' IS NOT NULL)
ADD CONSTRAINT INST_TrangThai_NNULL CHECK ('TrangThai' IS NOT NULL)
ADD CONSTRAINT INST_TGBaoDuong_NNULL CHECK ('TGBaoDuong' IS NOT NULL)
ADD CONSTRAINT INST_DonGia_NNULL CHECK ('DonGia' IS NOT NULL)
ADD CONSTRAINT INST_ThuongHieu_NNULL CHECK ('ThuongHieu' IS NOT NULL)
ADD CONSTRAINT INST_TienCoc_NNULL CHECK ('TienCoc' IS NOT NULL)
ADD CONSTRAINT INST_MaLX_XE_NNULL CHECK ('MaLX' IS NOT NULL)
/

ALTER TABLE HDPHAT
ADD CONSTRAINT INST_MaHDP_NNULL CHECK ('MaHDP' IS NOT NULL)
ADD CONSTRAINT INST_TGTao_HDPHAT_NNULL CHECK ('TGTao' IS NOT NULL)
ADD CONSTRAINT INST_TongTienPhat_HDPHAT_NNULL CHECK ('TongTienPhat' IS NOT NULL)
ADD CONSTRAINT INST_MaHD_HDPHAT_NNULL CHECK ('MaHD' IS NOT NULL)
/

ALTER TABLE CHITIETHDPHAT
ADD CONSTRAINT INST_MaHDP_CHITIETHDPHAT_NNULL CHECK (MaHDP IS NOT NULL)
ADD CONSTRAINT INST_MaXe_CHITIETHDPHAT_NNULL CHECK (MaXe IS NOT NULL)
ADD CONSTRAINT INST_LoaiPhat_NNULL CHECK (LoaiPhat IS NOT NULL)
ADD CONSTRAINT CHK_SoTien_NonNegative CHECK (SoTien >= 0)
/

ALTER TABLE DANHGIA
ADD CONSTRAINT INST_MaDG_DANHGIA_NNULL CHECK ('MaDG' IS NOT NULL)
ADD CONSTRAINT INST_SoDiem_NNULL CHECK ('SoDiem' IS NOT NULL)
ADD CONSTRAINT INST_NoiDung_NNULL CHECK ('NoiDung' IS NOT NULL)
ADD CONSTRAINT INST_MaHD_DANHGIA_NNULL CHECK ('MaHD' IS NOT NULL)
/

-- Bảng KHACHHANG
ALTER TABLE KHACHHANG ADD CONSTRAINT PK_KHACHHANG PRIMARY KEY (MaKH);

-- Bảng TAIKHOAN
ALTER TABLE TAIKHOAN ADD CONSTRAINT PK_TAIKHOAN PRIMARY KEY (MaNV);
ALTER TABLE TAIKHOAN ADD CONSTRAINT FK_TAIKHOAN_TAIKHOAN FOREIGN KEY (MaQL) REFERENCES TAIKHOAN(MaNV);

-- Bảng LoaiXe
ALTER TABLE LoaiXe ADD CONSTRAINT PK_LOAIXE PRIMARY KEY (MaLX);

-- Bảng XE
ALTER TABLE XE ADD CONSTRAINT PK_XE PRIMARY KEY (MaXe);
ALTER TABLE XE ADD CONSTRAINT FK_XE_LOAIXE FOREIGN KEY (MaLX) REFERENCES LOAIXE(MaLX);

-- Bảng HOADON
ALTER TABLE HOADON ADD CONSTRAINT PK_HOADON PRIMARY KEY (MaHD);
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH);
ALTER TABLE HOADON ADD CONSTRAINT FK_HOADON_TAIKHOAN FOREIGN KEY (MaNV) REFERENCES TAIKHOAN(MaNV);

-- Bảng CHITIETHD
ALTER TABLE CHITIETHD ADD CONSTRAINT PK_CHITIETHD PRIMARY KEY (MaHD, MaXe);
ALTER TABLE CHITIETHD ADD CONSTRAINT FK_CHITIETHD_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD);
ALTER TABLE CHITIETHD ADD CONSTRAINT FK_CHITIETHD_XE FOREIGN KEY (MaXe) REFERENCES XE(MaXe);

-- Bảng HDPHAT
ALTER TABLE HDPHAT ADD CONSTRAINT PK_HDPHAT PRIMARY KEY (MaHDP);
ALTER TABLE HDPHAT ADD CONSTRAINT FK_HDPHAT_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD);

-- Bảng CHITIETHDPHAT
ALTER TABLE CHITIETHDPHAT ADD CONSTRAINT PK_CHITIETHDPHAT PRIMARY KEY (MaHDP, MaXe);
ALTER TABLE CHITIETHDPHAT ADD CONSTRAINT FK_CHITIETHDPHAT_HDPHAT FOREIGN KEY (MaHDP) REFERENCES HDPHAT(MaHDP);
ALTER TABLE CHITIETHDPHAT ADD CONSTRAINT FK_CHITIETHDPHAT_XE FOREIGN KEY (MaXe) REFERENCES XE(MaXe);

-- Bảng DANHGIA
ALTER TABLE DANHGIA ADD CONSTRAINT PK_DANHGIA PRIMARY KEY (MaDG);
ALTER TABLE DANHGIA ADD CONSTRAINT FK_DANHGIA_HOADON FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD);
/

/*=============================================================================================*/   
CREATE OR REPLACE PROCEDURE qlthuexe."INSERT_CTHDPHAT_DETAILS" (
  p_ma_hdp VARCHAR2,
  p_ma_xe VARCHAR2,
  p_loai_phat VARCHAR2,
  p_so_tien NUMBER,
  p_image_filename VARCHAR2,
  p_chu_thich VARCHAR2
) AS
  l_bfile  BFILE;
  l_blob   BLOB;
  l_dest_offset INTEGER := 1;
  l_src_offset  INTEGER := 1;
  l_lobmaxsize CONSTANT INTEGER := DBMS_LOB.LOBMAXSIZE;
BEGIN
  INSERT INTO CHITIETHDPHAT (MaHDP, MaXe, LoaiPhat, SoTien, HinhAnh, ChuThich)
  VALUES (p_ma_hdp, p_ma_xe, p_loai_phat, p_so_tien, empty_blob(), p_chu_thich)
  RETURNING HinhAnh INTO l_blob;

  IF p_image_filename IS NOT NULL THEN
    l_bfile := BFILENAME('HINHXE', p_image_filename);
    DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);
    DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);
    DBMS_LOB.fileclose(l_bfile);
    DBMS_OUTPUT.PUT_LINE('Size of the Image is: ' || DBMS_LOB.GETLENGTH(l_blob));
  ELSE
    DBMS_OUTPUT.PUT_LINE('No image provided.');
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
    ROLLBACK;
END INSERT_CTHDPHAT_DETAILS;
/
/*=============================================================================================*/   
CREATE SEQUENCE KHACHHANG_SEQ
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2000
    NOCYCLE;
/

CREATE SEQUENCE TAIKHOAN_SEQ
    START WITH 2001
    INCREMENT BY 1
    MINVALUE 2001
    MAXVALUE 3000
    NOCYCLE;
/

CREATE SEQUENCE LOAIXE_SEQ
    START WITH 3001
    INCREMENT BY 1
    MINVALUE 3001
    MAXVALUE 4000
    NOCYCLE;
/

CREATE SEQUENCE XE_SEQ
    START WITH 4001
    INCREMENT BY 1
    MINVALUE 4001
    MAXVALUE 5000
    NOCYCLE;
/

CREATE SEQUENCE HOADON_SEQ
    START WITH 5001
    INCREMENT BY 1
    MINVALUE 5001
    MAXVALUE 7000
    NOCYCLE;
/

CREATE SEQUENCE DANHGIA_SEQ
    START WITH 8001
    INCREMENT BY 1
    MINVALUE 8001
    MAXVALUE 9000
    NOCYCLE;
/

CREATE SEQUENCE HDPHAT_SEQ
    START WITH 9001
    INCREMENT BY 1
    MINVALUE 9001
    MAXVALUE 10000
    NOCYCLE;
/

CREATE SEQUENCE HOPDONG_SEQ
    START WITH 7001
    INCREMENT BY 1
    MINVALUE 7001
    MAXVALUE 8000
    NOCYCLE;
/

CREATE OR REPLACE TRIGGER trg_insert_khachhang
BEFORE INSERT ON KHACHHANG
FOR EACH ROW
BEGIN
    :new.MaKH := KHACHHANG_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_taikhoan
BEFORE INSERT ON TAIKHOAN
FOR EACH ROW
BEGIN
    :new.MaNV := TAIKHOAN_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_loaixe 
BEFORE INSERT ON LOAIXE 
FOR EACH ROW
BEGIN
    :new.MaLX := LOAIXE_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_xe
BEFORE INSERT ON XE
FOR EACH ROW
BEGIN
    :new.MaXe := XE_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_hoadon
BEFORE INSERT ON HOADON
FOR EACH ROW
BEGIN
    :new.MaHD := HOADON_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_mahopdong_chitiethoadon
BEFORE INSERT ON CHITIETHD
FOR EACH ROW
BEGIN
    :new.MaHopDong := HOPDONG_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_danhgia
BEFORE INSERT ON DANHGIA
FOR EACH ROW
BEGIN
    :new.MaDG := DANHGIA_SEQ.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER trg_insert_hdphat
BEFORE INSERT ON HDPHAT
FOR EACH ROW
BEGIN
    :new.MaHDP := HDPHAT_SEQ.NEXTVAL;
END;
/
/*=============================================================================================*/   
------

ALTER SESSION SET nls_date_format = 'DD/MM/YYYY';
-- INSERT DU LIEU
--KHACHANG
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Văn A', 'Nam','12-10-1998', '731 Trần Hưng Đạo, Quận 5, TP Hồ Chí Minh','938776266', 4400000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Ngọc Hân', 'Nữ','25-01-2000', '23/5 Nguyễn Trãi, Quận 5, TP Hồ Chí Minh','912300247', 13240000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Minh Long', 'Nam','23-08-1995', '45 Nguyễn cảnh Chân, Quận 1, TP Hồ Chí Minh','915133607', 7660000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Nhật Minh', 'Nam','30-08-2003', '50/34 Lê Đại Hành, Quận 10, TP Hồ Chí Minh','915391312', 24010000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Hoài Thương', 'Nữ','07-10-2004', '34 Trương Định, Quận 3, TP Hồ Chí Minh','913602103', 3840000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Gia Hân', 'Nữ','06-03-2000', '227 Nguyễn Văn Cừ, Quận 5, TP Hồ Chí Minh','905372666', 1350000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Đức Thịnh', 'Nam','23-05-2002', '32/3 Trần Bình Trọng, Quận 5, TP Hồ Chí Minh','912222798', 9450000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Văn Tâm', 'Nam','12-06-1983', '45/2 An Dương Vương, Quận 5, TP Hồ Chí Minh','913295947', 840000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Phan Thị Thanh', 'Nữ','31-12-1989', '873 Lê Hồng Phong, Quận 5, TP Hồ Chí Minh','979749536', 10190000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Hà Vinh', 'Nam','10-01-1990', '34/34B Nguyễn Trãi, Quận 1, TP Hồ Chí Minh','914418539', 420000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Hà Duy Lập', 'Nam','02-05-1998', '197  Nguyễn Văn Thủ, Phường Đa Kao, Quận 1, TP Hồ Chí Minh','944747978', 6100000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Tuấn Mạnh', 'Nam','03-09-2000', '33/9A Đường số 08, Khu phố 01, Phường Linh Xuân, Thành phố Thủ Đức, TP Hồ Chí Minh','949234388', 1350000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Văn Kiên', 'Nam','15-08-1995', '58 đường 53, Phường Tân Phong, Quận 7, TP Hồ Chí Minh','949522905', 5030000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Huy Hùng', 'Nam','04-04-2001', '18 đường Trần Ngọc Diện, Phường Thảo Điền, Thành phố Thủ Đức, TP Hồ Chí Minh','911375199', 7120000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Vũ Thị Anh', 'Nữ','09-03-2004', '12, Đường số 2, Phường Phú Hữu, Thành phố Thủ Đức, TP Hồ Chí Minh','919795257', 3200000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Ngọc Anh', 'Nữ','06-04-1994', '1A Nguyễn Văn Đậu, Phường 05, Quận Phú Nhuận, TP Hồ Chí Minh','977097698', 3000000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Ngô Thị Kiều Diễm', 'Nữ','02-05-2002', '36/38 Quốc Lộ 1A, Khu Phố 3, phường An Phú Đông, Quận 12, TP Hồ Chí Minh','912980878', 840000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Thị Thuỳ Giang', 'Nữ','12-07-2003', '13 đường số 22, Phường Bình Trị Đông B, Quận Bình Tân, TP Hồ Chí Minh','854569729', 4660000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Thị Minh Anh', 'Nữ','22-10-1990', '371 Nguyễn Kiệm, Phường 3, Quận Gò Vấp, TP Hồ Chí Minh','917822121', 4050000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Khang Ninh', 'Nam','23-11-1991', '256/30 Phan Huy ích, Phường 12, Quận Gò Vấp, TP Hồ Chí Minh','945951146', 2169000);
/
--TAIKHOAN
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('admin', '123456', 'Phạm Ngọc Tài', 'Nam','24-06-2000', 'Admin', 8000000, '13-12-2023', NULL);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('quanly', '123456', 'Bùi Xuân Thường', 'Nữ','13-07-1990', 'Quản lý', 15200000, '21-11-2023', NULL);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('nhanvien', '123456', 'Trần Thị Như  Ý', 'Nữ','04-05-2002', 'Nhân viên', 6100000, '21-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('linhnvl', 'linhnvl1234', 'Nguyễn Văn Linh', 'Nam','14-01-2002', 'Nhân viên', 6100000, '21-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('phuongntp', 'phuongntp1234', 'Nguyễn Thị Phương', 'Nữ','03-09-1998', 'Nhân viên', 8000000, '21-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('binhptb', 'binhptb1234', 'Phạm Thanh Bình', 'Nam','24-01-1989', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('phongntp', 'phongntp1234', 'Nguyễn Thanh Phong', 'Nam','25-02-2000', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('tuyetctt', 'tuyetctt1234', 'Cao Thị Tuyết', 'Nữ','02-05-2001', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('hienndh', 'hienndh1234', 'Nguyễn Đức Hiền', 'Nam','12-06-1998', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('tuanhat', 'tuanhat1234', 'Hoàng  Anh Tuấn', 'Nam','16-01-2001', 'Nhân viên', 8000000, '15-02-2024', 2002);
/
--LOAIXE
INSERT INTO LOAIXE (TenLX, SoLuong, SoCho) VALUES ('Xe bốn chỗ ', 10, 4);
INSERT INTO LOAIXE (TenLX, SoLuong, SoCho) VALUES ('Xe bảy chỗ ', 6, 7);
INSERT INTO LOAIXE (TenLX, SoLuong, SoCho) VALUES ('Xe máy', 4, 2);
/
-- XE
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HUYNDAI I10 SEDAN 2020', '51B - 22654', 'Không hư', 5, 1250000, 'HUYNDAI', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('TOYOTA VIOS 2018', '51B - 22655', 'Không hư', 3, 1280000, 'TOYOTA', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MITSUBISHI ATTRAGE 2023', '51B - 22656', 'Không hư', 4, 1350000, 'MITSUBISHI', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('KIA SOLUTO 2020', '51B - 22657', 'Không hư', 5, 1050000, 'KIA MORNING', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA CITY 2017', '51B - 22658', 'Không hư', 3, 1280000, 'HONDA', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HUYNDAI ACCENT 2021', '51B - 22659', 'Hư', 2, 1250000, 'HUYNDAI', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('KIA K3 LUXURY 2022', '51B - 22660', 'Không hư', 5, 1350000, 'KIA MORNING', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MERCERDES C200 2016', '51B - 22661', 'Không hư', 6, 1500000, 'MERCEDES', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MERCERDES C300 AMG 2017', '51B - 22662', 'Không hư', 7, 1700000, 'MERCEDES', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('LEXUS IS 300 2021', '51B - 22663', 'Không hư', 3, 1450000, 'LEXUS', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('TOYOTA FORTURN 2016', '51B - 22664', 'Không hư', 3, 1450000, 'MITSUBISHI', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MITSUBISHI XPANDER 2023', '51B - 22665', 'Không hư', 3, 1350000, 'TOYOTA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('TOYOTA AVANZA 2023', '51B - 22666', 'Không hư', 4, 1350000, 'TOYOTA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MAZDA CX8 2021', '51B - 22667', 'Không hư', 5, 1530000, 'MAZDA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA CRV 2022', '51B - 22668', 'Không hư', 6, 1530000, 'HONDA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MERCEDES GLB 200 AMG 2020', '51B - 22669', 'Không hư', 4, 1780000, 'MERCEDES', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('YAMAHA SIRIUS 110cc', '51B - 22670', 'Không hư', 4, 210000, 'YAMAHA', 0, 3003);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA VISION 110cc', '51B - 22671', 'Không hư', 3, 273000, 'HONDA', 0, 3003);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA AIR BLADE 125cc', '51B - 22672', 'Không hư', 4, 357000, 'HONDA', 0, 3003);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA WINNERX 150cc', '51B - 22673', 'Không hư', 3, 420000, 'HONDA', 0, 3003);
/
--HOADON
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('01-01-2024', 2700000, '01-01-2024', '01-01-2024 ', 20000000, '01-01-2024 ',  'Đã trả xe', NULL, 1, 2001);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('18-01-2024', 7120000, '20-01-2004', '23-01-2024', 10000000, '23-01-2024',  'Đã trả xe', NULL, 2, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('10-02-2024', 2560000, '10-02-2024', '11-02-2024', 10000000, '11-02-2024',  'Đã trả xe', NULL, 3, 2004);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('14-02-2024', 3360000, '15-02-2024', '18-02-2024', 0, '18-02-2024',  'Đã trả xe', NULL, 4, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024', 3840000, '17-02-2024', '19-02-2024', 10000000, '19-02-2024',  'Đã trả xe', NULL, 5, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('19-02-2024', 1350000, '20-02-2024', '20-02-2024', 10000000, '20-02-2024',  'Đã trả xe', NULL, 6, 2006);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('20-02-2024', 9450000, '20-02-2024', '26-02-2024', 10000000, '26-02-2024',  'Đã trả xe', NULL, 7, 2002);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('01-03-2024', 840000, '02-03-2024', '03-03-2024', 0, '03-03-2024',  'Đã trả xe', NULL, 8, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('01-03-2024', 7160000, '02-03-2024', '03-03-2024', 30000000, '03-03-2024',  'Đã trả xe', NULL, 9, 2007);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('10-03-2024', 1350000, '10-03-2024', '10-03-2024', 10000000, '10-03-2024',  'Đã trả xe', NULL, 9, 2008);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('15-03-2024', 1700000, '15-03-2024', '15-03-2024', 10000000, '16-03-2024',  'Đã trả xe', NULL, 1, 2009);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('23-03-2024', 420000, '23-03-2024', '24-03-2024', 0, '24-03-2024',  'Đã trả xe', NULL, 10, 2010);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('03-04-2024', 6100000, '03-04-2024', '04-04-2024', 20000000, '04-04-2024',  'Đã trả xe', NULL, 11, 2008);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('07-04-2024', 1350000, '08-04-2024', '08-04-2024', 10000000, '08-04-2024',  'Đã trả xe', NULL, 12, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('13-04-2024', 3750000, '15-04-2024', '17-04-2024', 10000000, '17-04-2024',  'Đã trả xe', NULL, 13, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('14-04-2024', 3560000, '15-04-2024', '16-04-2024', 10000000, '17-04-2024',  'Đã trả xe', NULL, 14, 2002);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('16-04-2024', 3200000, '16-04-2024', '16-04-2024', 20000000, '16-04-2024',  'Đã trả xe', NULL, 15, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('16-04-2024', 3000000, '16-04-2024', '17-04-2024', 10000000, '17-04-2024',  'Đã trả xe', NULL, 16, 2010);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 840000, '17-04-2024', '20-04-2024', 0, '20-04-2024',  'Đã nhận xe', NULL, 17, 2004);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 4660000, '18-04-2024', '19-04-2024', 20000000, '19-04-2024',  'Đã đặt xe', NULL, 18, 2006);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 4050000, '17-04-2024', '19-04-2024', 10000000, '19-04-2024',  'Đã nhận xe', NULL, 19, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 819000, '18-04-2024', '20-04-2024', 0, '20-04-2024',  'Đã đặt xe', NULL, 20, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 1350000, '19-04-2024', '19-04-2024', 10000000, '19-04-2024',  'Đã đặt xe', NULL, 20, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 5100000, '18-04-2024', '20-04-2024', 10000000, '20-04-2024',  'Đã đặt xe', NULL, 3, 2004);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 6120000, '18-04-2024', '19-04-2024', 20000000, '19-04-2024',  'Đã đặt xe', NULL, 2, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 20650000, '17-04-2024', '23-04-2024', 20000000, '23-04-2024',  'Đã nhận xe', NULL, 4, 2006);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 1680000, '18-04-2024', '21-04-2024', 0, '21-04-2024',  'Đã đặt xe', NULL, 9, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024', 1280000, '17-04-2024', '17-04-2024', 10000000, '17-04-2024',  'Đã nhận xe', NULL, 13, 2007);
/
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5001, 4001, 1, 1250000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5001, 4011, 1, 1450000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5002, 4016, 4, 7120000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5003, 4002, 2, 2560000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5004, 4017, 4, 840000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5004, 4018, 4, 1092000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5004, 4019, 4, 1428000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5005, 4002, 3, 3840000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5006, 4003, 1, 1350000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5007, 4003, 7, 9450000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5008, 4020, 2, 840000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5009, 4004, 2, 2100000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5009, 4005, 2, 2560000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5009, 4006, 2, 2500000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5010, 4007, 1, 1350000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5011, 4009, 1, 1700000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5012, 4017, 2, 420000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5013, 4009, 2, 3400000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5013, 4012, 2, 2700000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5014, 4013, 1, 1350000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5015, 4006, 3, 3750000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5016, 4016, 2, 3560000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5017, 4008, 1, 1500000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5017, 4009, 1, 1700000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5018, 4008, 2, 3000000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5019, 4017, 4, 840000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5020, 4004, 2, 2100000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5020, 4005, 2, 2560000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5021, 4007, 3, 4050000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5022, 4018, 3, 819000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5023, 4012, 1, 1350000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5024, 4009, 3, 5100000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5025, 4015, 2, 3060000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5025, 4014, 2, 3060000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5026, 4008, 7, 10500000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5026, 4010, 7, 10150000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5027, 4020, 4, 1680000);
INSERT INTO CHITIETHD (MaHD, MaXe , SoNgay, SoTien) VALUES (5028, 4005, 1, 1280000);
/
--HDPHAT
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('23-01-2024', 1000000, 'Đã thanh toán', 5002);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('18-02-2024', 3000000, 'Đã thanh toán', 5004);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('03-03-2024', 5000000, 'Đã thanh toán', 5009);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('03-03-2024', 7000000, 'Đã thanh toán', 5008);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('16-03-2024', 2500000, 'Đã thanh toán', 5011);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('17-04-2024', 7000000, 'Đã thanh toán', 5015);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('17-04-2024', 500000, 'Đã thanh toán', 5016);
--CTHDPHAT
SET SERVEROUTPUT ON
BEGIN
    insert_cthdphat_details(9001, 4011, 'Thiệt hại', 2000000, 'xh11.jpg', 'Vết xước lớn');
    insert_cthdphat_details(9002, 4002, 'Thiệt hại', 1000000, 'xh02.jpg', 'Vết xước lớn');
    insert_cthdphat_details(9003, 4004, 'Thiệt hại', 3000000, 'xh04.jpg', 'Bể đèn hậu');
    insert_cthdphat_details(9004, 4007, 'Quá hạn', 500000, NULL, 'Trễ hẹn trả xe');
    insert_cthdphat_details(9005, 4009, 'Thiệt hại', 5000000, 'xh09.jpg', 'Móp xe');
    insert_cthdphat_details(9006, 4016, 'Thiệt hại', 7000000, 'xh15.jpg', 'Bể gương');
    insert_cthdphat_details(9007, 4008, 'Thiệt hại', 7000000, 'xh08.jpg', 'Bể gương');
END;
/
--- DANHGIA
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Giá cả phải chăng và dễ dàng đặt xe', 5001);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Xe được cung cấp đều mới và sạch sẽ, đảm bảo an toàn và thoải mái ', 5002);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Đội ngũ nhân viên thân thiện và chuyên nghiệp, luôn sẵn lòng hỗ trợ và giải đáp mọi thắc mắc của khách hàng.', 5003);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Quy trình thuê xe linh hoạt và tiện lợi, tiết kiệm thời gian và công sức.', 5004);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Giá cả hợp lý và minh bạch, không có phí ẩn hay phụ phí bất ngờ khi thuê xe', 5005);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Xe đạt tiêu chuẩn an toàn cao, được trang bị đầy đủ các tính năng an toàn và kiểm soát hiện đại.', 5006);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Quy trình trả xe đơn giản và thuận tiện,tiết kiệm thời gian và không gặp phải bất kỳ rắc rối nào.', 5007);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Xe được trang bị đầy đủ các tính năng hiện đại và tiện nghi, tạo nên một trải nghiệm lái xe thoải mái và tiện lợi.', 5008);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Quy trình thuê xe được tổ chức rõ ràng và minh bạch, giúp hiểu rõ về các điều khoản và điều kiện thuê xe trước khi đồng ý với đơn hàng', 5009);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã thấy rất hài lòng với chất lượng và tính đa dạng của các loại xe được cung cấp bởi công ty, đáp ứng được mọi nhu cầu và sở thích của khách hàng.', 5010);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Dịch vụ khách hàng của công ty là một trong những điểm mạnh, với nhân viên luôn sẵn lòng lắng nghe và giúp đỡ khách hàng trong mọi tình huống.', 5011);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Dịch vụ đặt xe qua ứng dụng di động của công ty hoạt động mượt mà và tiện lợi, cho phép tôi dễ dàng quản lý đơn đặt hàng và nhận thông tin cập nhật về đơn hàng của mình.', 5012);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Tôi đã thấy rất ấn tượng với sự linh hoạt của công ty trong việc đáp ứng nhu cầu đặc biệt của khách hàng, như yêu cầu đặc biệt về loại xe hoặc điều kiện thuê xe.', 5013);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã được hướng dẫn chi tiết về các tính năng và trang thiết bị của xe khi nhận xe, giúp tôi cảm thấy tự tin và thoải mái khi lái xe', 5014);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã nhận được một dịch vụ thuê xe linh hoạt và tiện lợi, với các lựa chọn đa dạng cho thuê xe ngắn hạn và dài hạn', 5015);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã được hỗ trợ và giải quyết mọi vấn đề kỹ thuật hoặc sự cố với xe một cách nhanh chóng và chuyên nghiệp từ nhân viên kỹ thuật của công ty', 5016);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Tôi đã nhận được sự hài lòng tối đa từ dịch vụ thuê xe của công ty, với sự kết hợp hoàn hảo giữa chất lượng, tiện ích và giá trị, làm cho trải nghiệm thuê xe trở nên thú vị và tiện lợi hơn bao giờ hết', 5017);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Công ty cung cấp các chương trình thưởng và điểm thưởng cho khách hàng thân thiết, tạo động lực cho tôi quay lại sử dụng dịch vụ của họ một cách thường xuyên.', 5018);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã nhận được sự hỗ trợ tận tình và chuyên nghiệp từ nhân viên khi gặp phải vấn đề hoặc câu hỏi liên quan đến việc thuê xe, giúp tôi cảm thấy an tâm và tin tưởng.', 5019);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Tôi đã được nhận một chiếc xe sạch sẽ và đảm bảo an toàn khi nhận xe, tạo sự yên tâm và tin tưởng trong suốt thời gian thuê xe.', 5020);
//====================================

SELECT NVL(MAX(MaHD),0) AS MaHD_lastest FROM HOADON
