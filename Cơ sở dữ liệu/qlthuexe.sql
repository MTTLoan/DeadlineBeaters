-- Tạo user qlthuexe

create user qlthuexe identified by qlthuexe;
grant connect to qlthuexe;
grant dba to qlthuexe;

--Nếu báo lỗi ORA-65096: invalid common user or role name chạy câu lệnh
-- alter session set "_ORACLE_SCRIPT"=true;  rồi tiếp tục thực hiện lại


-- Tao directory o user sys
CREATE DIRECTORY hinhxe AS 'D:\hinh xe'; -
--duong link luu file hinh xe

GRANT READ, WRITE ON DIRECTORY hinhxe TO qlthuexe;
--cấp quy�?n sử dụng directory cho  qlthuexe

SELECT * FROM DBA_DIRECTORIES 
--run statement kiem tra co directory hay khong

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
 ------------------ 
 -- sys tao hinh anh
--CREATE DIRECTORY hinhxe AS 'D:\hinh xe';

--GRANT READ, WRITE ON DIRECTORY hinhxe TO qlthuexe;

--SELECT * FROM DBA_DIRECTORIES
-----------------------

--- Tao bang
set feedback off

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
    SoGio NUMBER,
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
ADD CONSTRAINT INST_SoGio_NNULL CHECK ('SoGio' IS NOT NULL)
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
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Văn A', 'Nam','12-10-1998', '731 Trần Hưng �?ạo, Quận 5, TP Hồ Chí Minh','0938776266', 2000000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Ng�?c Hân', 'Nữ','25-01-2000', '23/5 Nguyễn Trãi, Quận 5, TP Hồ Chí Minh','0912300247', 2850000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Minh Long', 'Nam','23-08-1995', '45 Nguyễn cảnh Chân, Quận 1, TP Hồ Chí Minh','0915133607', 1560000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Nhật Minh', 'Nam','30-08-2003', '50/34 Lê �?ại Hành, Quận 10, TP Hồ Chí Minh','0915391312', 6930000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Hoài Thương', 'Nữ','07-10-2004', '34 Trương �?ịnh, Quận 3, TP Hồ Chí Minh','0913602103', 825000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Gia Hân', 'Nữ','06-03-2000', '227 Nguyễn Văn Cừ, Quận 5, TP Hồ Chí Minh','0905372666', 600000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê �?ức Thịnh', 'Nam','23-05-2002', '32/3 Trần Bình Tr�?ng, Quận 5, TP Hồ Chí Minh','0912222798', 2520000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Văn Tâm', 'Nam','12-06-1983', '45/2 An Dương Vương, Quận 5, TP Hồ Chí Minh','0913295947', 240000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Phan Thị Thanh', 'Nữ','31-12-1989', '873 Lê Hồng Phong, Quận 5, TP Hồ Chí Minh','0979749536', 2820000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Lê Hà Vinh', 'Nam','10-01-1990', '34/34B Nguyễn Trãi, Quận 1, TP Hồ Chí Minh','0914418539', 120000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Hà Duy Lập', 'Nam','02-05-1998', '197  Nguyễn Văn Thủ, Phư�?ng �?a Kao, Quận 1, TP Hồ Chí Minh','0944747978', 1680000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Tuấn Mạnh', 'Nam','03-09-2000', '33/9A �?ư�?ng số 08, Khu phố 01, Phư�?ng Linh Xuân, Thành phố Thủ �?ức, TP Hồ Chí Minh','0949234388', 600000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Văn Kiên', 'Nam','15-08-1995', '58 đư�?ng 53, Phư�?ng Tân Phong, Quận 7, TP Hồ Chí Minh','0949522905', 1300000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Huy Hùng', 'Nam','04-04-2001', '18 đư�?ng Trần Ng�?c Diện, Phư�?ng Thảo �?i�?n, Thành phố Thủ �?ức, TP Hồ Chí Minh','0911375199', 1050000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Vũ Thị Anh', 'Nữ','09-03-2004', '12, �?ư�?ng số 2, Phư�?ng Phú Hữu, Thành phố Thủ �?ức, TP Hồ Chí Minh','0919795257', 1550000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Ng�?c Anh', 'Nữ','06-04-1994', '1A Nguyễn Văn �?ậu, Phư�?ng 05, Quận Phú Nhuận, TP Hồ Chí Minh','0977097698', 900000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Ngô Thị Ki�?u Diễm', 'Nữ','02-05-2002', '36/38 Quốc Lộ 1A, Khu Phố 3, phư�?ng An Phú �?ông, Quận 12, TP Hồ Chí Minh','0912980878', 210000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Thị Thuỳ Giang', 'Nữ','12-07-2003', '13 đư�?ng số 22, Phư�?ng Bình Trị �?ông B, Quận Bình Tân, TP Hồ Chí Minh','0854569729', 1200000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Nguyễn Thị Minh Anh', 'Nữ','22-10-1990', '371 Nguyễn Kiệm, Phư�?ng 3, Quận Gò Vấp, TP Hồ Chí Minh','0917822121', 900000);
INSERT INTO KHACHHANG (TenKH, GioiTinh, NgaySinh , DiaChi, SDT, TongDoanhThu) VALUES ('Trần Khang Ninh', 'Nam','23-11-1991', '256/30 Phan Huy ích, Phư�?ng 12, Quận Gò Vấp, TP Hồ Chí Minh','0945951146', 795000);

--TAIKHOAN
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('admin', '123456', 'Phạm Ng�?c Tài', 'Nam','24-06-2000', 'Admin', 8000000, '13-12-2023', NULL);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('quanly', '123456', 'Bùi Xuân Thư�?ng', 'Nữ','13-07-1990', 'Quản lý', 15200000, '21-11-2023', NULL);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('nhanvien', '123456', 'Trần Thị Như  �?', 'Nữ','04-05-2002', 'Nhân viên', 6100000, '21-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('linhnvl', 'linhnvl1234', 'Nguyễn Văn Linh', 'Nam','14-01-2002', 'Nhân viên', 6100000, '21-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('phuongntp', 'phuongntp1234', 'Nguyễn Thị Phương', 'Nữ','03-09-1998', 'Nhân viên', 8000000, '21-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('binhptb', 'binhptb1234', 'Phạm Thanh Bình', 'Nam','24-01-1989', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('phongntp', 'phongntp1234', 'Nguyễn Thanh Phong', 'Nam','25-02-2000', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('tuyetctt', 'tuyetctt1234', 'Cao Thị Tuyết', 'Nữ','02-05-2001', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('hienndh', 'hienndh1234', 'Nguyễn �?ức Hi�?n', 'Nam','12-06-1998', 'Nhân viên', 8000000, '27-12-2023', 2002);
INSERT INTO TAIKHOAN (TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL  ) VALUES ('tuanhat', 'tuanhat1234', 'Hoàng  Anh Tuấn', 'Nam','16-01-2001', 'Nhân viên', 8000000, '15-02-2024', 2002);
--LOAIXE
INSERT INTO LOAIXE (TenLX, SoLuong, SoCho) VALUES ('Xe bốn chỗ ', 10, 4);
INSERT INTO LOAIXE (TenLX, SoLuong, SoCho) VALUES ('Xe bảy chỗ ', 6, 7);
INSERT INTO LOAIXE (TenLX, SoLuong, SoCho) VALUES ('Xe máy', 4, 2);
-- XE
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HUYNDAI I10 SEDAN 2020', '51B - 22654', 'Không hư', 5, 500000, 'HUYNDAI', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('TOYOTA VIOS 2018', '51B - 22655', 'Không hư', 3, 550000, 'TOYOTA', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MITSUBISHI ATTRAGE 2023', '51B - 22656', 'Không hư', 4, 600000, 'MITSUBISHI', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('KIA SOLUTO 2020', '51B - 22657', 'Không hư', 5, 450000, 'KIA MORNING', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA CITY 2017', '51B - 22658', 'Không hư', 3, 550000, 'HONDA', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HUYNDAI ACCENT 2021', '51B - 22659', 'Hư', 2, 500000, 'HUYNDAI', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('KIA K3 LUXURY 2022', '51B - 22660', 'Không hư', 5, 600000, 'KIA MORNING', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MERCERDES C200 2016', '51B - 22661', 'Không hư', 6, 750000, 'MERCEDES', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MERCERDES C300 AMG 2017', '51B - 22662', 'Không hư', 7, 800000, 'MERCEDES', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('LEXUS IS 300 2021', '51B - 22663', 'Không hư', 3, 700000, 'LEXUS', 10000000, 3001);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('TOYOTA FORTURN 2016', '51B - 22664', 'Không hư', 3, 700000, 'MITSUBISHI', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MITSUBISHI XPANDER 2023', '51B - 22665', 'Không hư', 3, 600000, 'TOYOTA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('TOYOTA AVANZA 2023', '51B - 22666', 'Không hư', 4, 600000, 'TOYOTA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MAZDA CX8 2021', '51B - 22667', 'Không hư', 5, 750000, 'MAZDA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA CRV 2022', '51B - 22668', 'Không hư', 6, 750000, 'HONDA', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('MERCEDES GLB 200 AMG 2020', '51B - 22669', 'Không hư', 4, 800000, 'MERCEDES', 10000000, 3002);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('YAMAHA SIRIUS 110cc', '51B - 22670', 'Không hư', 4, 100000, 'YAMAHA', 0, 3003);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA VISION 110cc', '51B - 22671', 'Không hư', 3, 130000, 'HONDA', 0, 3003);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA AIR BLADE 125cc', '51B - 22672', 'Không hư', 4, 170000, 'HONDA', 0, 3003);
INSERT INTO XE (TenXe, BienSo, TrangThai, TGBaoDuong, DonGia, ThuongHieu, TienCoc, MaLX) VALUES ('HONDA WINNERX 150cc', '51B - 22673', 'Không hư', 3, 200000, 'HONDA', 0, 3003);
/
--
ALTER SESSION SET nls_date_format = 'DD/MM/YYYY HH24:MI';
--HOADON
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('01-01-2024 9:35', 1200000, '01-01-2024  9:00', '01-01-2024 13:00', 20000000, '01-01-2024 13:00',  '�?ã trả xe', NULL, 0001, 2001);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('18-01-2024 13:45', 1050000, '20-01-2024 8:00', '21-01-2024 8:00', 10000000, '21-01-2024 8:00',  '�?ã trả xe', NULL, 0002, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('10-02-2024 10:23', 660000, '10-02-2024  10:30', '10-02-2024  18:30', 10000000, '10-02-2024  18:30',  '�?ã trả xe', NULL, 0003, 2004);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('14-02-2024 15:12', 840000, '15-02-2024 10:00', '16-02-2024 10:00', 0, '16-02-2024 10:00',  '�?ã trả xe', NULL, 0004, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 16:00', 825000, '17-02-2024 16:20', '18-02-2024 4:20', 10000000, '18-02-2024 4:20',  '�?ã trả xe', NULL, 0005, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('19-02-2024 20:00', 600000, '20-02-2024 18:20', '20-02-2024 22:20', 10000000, '20-02-2024 22:20',  '�?ã trả xe', NULL, 0006, 2006);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('20-02-2024 19:02', 2520000, '20-02-2024 23:45', '22-02-2024 23:45', 10000000, '22-02-2024 23:45',  '�?ã trả xe', NULL, 0007, 2002);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('01-03-2024  7:28', 240000, '02-03-2024 8:00', '02-03-2024 16:00 ', 0, '02-03-2024 16:00 ',  '�?ã trả xe', NULL, 0008, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('01-03-2024  7:30', 1800000, '02-03-2024 6:00', '02-03-2024 14:00', 30000000, '02-03-2024 14:00',  '�?ã trả xe', NULL, 0009, 2007);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('10-03-2024 8:12', 600000, '10-03-2024 8:20', '10-03-2024 12:12', 10000000, '10-03-2024 12:12',  '�?ã trả xe', NULL, 0009, 2008);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('15-03-2024 17:45', 800000, '15-03-2024 18:00', '15-03-2024 22:00', 10000000, '15-03-2024 22:45',  '�?ã trả xe', NULL, 0001, 2009);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('23-03-2024 7:00', 120000, '23-03-2024 7:15', '23-03-2024 15:15', 0, '23-03-2024 15:15',  '�?ã trả xe', NULL, 0010, 2010);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('03-04-2024 5:00', 1680000, '03-04-2024 5:15', '03-04-2024 13:15', 20000000, '03-04-2024 13:15',  '�?ã trả xe', NULL, 0011, 2008);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('07-04-2024 15:34', 600000, '08-04-2024 17:30', '08-04-2024 21:30', 10000000, '08-04-2024 21:30',  '�?ã trả xe', NULL, 0012, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('13-04-2024 10:25', 750000, '15-04-2024 5:30', '15-04-2024 17:30', 10000000, '15-04-2024 17:30',  '�?ã trả xe', NULL, 0013, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('14-04-2024 9:23', 1050000, '15-04-2024 7:30', '16-04-2024 7:30', 10000000, '16-04-2024 9:35',  '�?ã trả xe', NULL, 0014, 2002);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('16-04-2024 9:20', 1550000, '16-04-2024 9:25', '16-04-2024 13:25', 20000000, '16-04-2024 13:25',  '�?ã trả xe', NULL, 0015, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('16-04-2024 10:12', 900000, '16-04-2024 14:45', '16-04-2024 22:45', 10000000, '16-04-2024 22:45',  '�?ã trả xe', NULL, 0016, 2010);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024 6:30', 210000, '17-04-2024 6:45', '18-04-2024 6:45', 0, '18-04-2024 6:45',  '�?ã nhận xe', NULL, 0017, 2004);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024 11:10', 1200000, '18-04-2024 5:00', '18-04-2024 13:00', 20000000, '18-04-2024 13:00',  '�?ã đặt xe', NULL, 0018, 2006);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024 11:30', 900000, '17-04-2024 11:40', '17-04-2024 23:40', 10000000, '17-04-2024 23:40',  '�?ã nhận xe', NULL, 0019, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-04-2024 13:15', 195000, '18-04-2024 7:45', '18-04-2024 19:45', 0, '18-04-2024 19:45',  '�?ã đặt xe', NULL, 0020, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 13:20', 600000, '19-04-2024 5:15', '19-04-2024 9:15', 10000000, '19-04-2024 9:15',  '�?ã đặt xe', NULL, 0020, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 14:12', 900000, '18-04-2024 13:00', '18-04-2024  1:00', 10000000, '18-04-2024  1:00',  '�?ã đặt xe', NULL, 0003, 2004);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 14:13', 1800000, '18-04-2024 5:00', '18-04-2024 13:00', 20000000, '18-04-2024 13:00',  '�?ã đặt xe', NULL, 0002, 2005);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 15:00', 6090000, '17-04-2024 15:15', '19-04-2024 15:15', 20000000, '19-04-2024 15:15',  '�?ã nhận xe', NULL, 0004, 2006);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 15:27', 420000, '18-04-2024 8:00', '19-04-2024 8:00', 0, '19-04-2024 8:00',  '�?ã đặt xe', NULL, 0009, 2003);
INSERT INTO HOADON (TGTao, TongTienThue, TGNhan, TGTra, TongTienCoc, TGCapNhat, TinhTrang, ChuThich, MaKH, MaNV) VALUES ('17-02-2024 15:34', 550000, '17-04-2024 15:45', '17-04-2024 19:45', 10000000, '17-04-2024 19:45',  '�?ã nhận xe', NULL, 0013, 2007);
--CTHD
INSERT INTO CHITIETHD VALUES (5001, 4001, 4, 500000, 7001);
INSERT INTO CHITIETHD VALUES (5001, 4011, 4, 700000, 7002);
INSERT INTO CHITIETHD VALUES (5002, 4016, 24, 1050000, 7003);
INSERT INTO CHITIETHD VALUES (5003, 4002, 8, 660000, 7004);
INSERT INTO CHITIETHD VALUES (5004, 4017, 24, 210000, 7005);
INSERT INTO CHITIETHD VALUES (5004, 4018, 24, 273000, 7006);
INSERT INTO CHITIETHD VALUES (5004, 4019, 24, 357000, 7007);
INSERT INTO CHITIETHD VALUES (5005, 4002, 12, 825000, 7008);
INSERT INTO CHITIETHD VALUES (5006, 4003, 4, 600000, 7009);
INSERT INTO CHITIETHD VALUES (5007, 4003, 48, 2520000, 7010);
INSERT INTO CHITIETHD VALUES (5008, 4020, 8, 240000, 7011);
INSERT INTO CHITIETHD VALUES (5009, 4004, 8, 540000, 7012);
INSERT INTO CHITIETHD VALUES (5009, 4005, 8, 660000, 7013);
INSERT INTO CHITIETHD VALUES (5009, 4006, 8, 600000, 7014);
INSERT INTO CHITIETHD VALUES (5010, 4007, 4, 600000, 7015);
INSERT INTO CHITIETHD VALUES (5011, 4009, 4, 800000, 7016);
INSERT INTO CHITIETHD VALUES (5012, 4017, 8, 120000, 7017);
INSERT INTO CHITIETHD VALUES (5013, 4009, 8, 960000, 7018);
INSERT INTO CHITIETHD VALUES (5013, 4012, 8, 720000, 7019);
INSERT INTO CHITIETHD VALUES (5014, 4013, 4, 600000, 7020);
INSERT INTO CHITIETHD VALUES (5015, 4006, 12, 750000, 7021);
INSERT INTO CHITIETHD VALUES (5016, 4016, 24, 1050000, 7022);
INSERT INTO CHITIETHD VALUES (5017, 4008, 4, 750000, 7023);
INSERT INTO CHITIETHD VALUES (5017, 4009, 4, 800000, 7024);
INSERT INTO CHITIETHD VALUES (5018, 4008, 8, 900000, 7025);
INSERT INTO CHITIETHD VALUES (5019, 4017, 24, 210000, 7026);
INSERT INTO CHITIETHD VALUES (5020, 4004, 8, 540000, 7027);
INSERT INTO CHITIETHD VALUES (5020, 4005, 8, 660000, 7028);
INSERT INTO CHITIETHD VALUES (5021, 4007, 12, 900000, 7029);
INSERT INTO CHITIETHD VALUES (5022, 4018, 12, 195000, 7030);
INSERT INTO CHITIETHD VALUES (5023, 4012, 4, 600000, 7031);
INSERT INTO CHITIETHD VALUES (5024, 4012, 12, 900000, 7032);
INSERT INTO CHITIETHD VALUES (5025, 4015, 8, 900000, 7033);
INSERT INTO CHITIETHD VALUES (5025, 4014, 8, 900000, 7034);
INSERT INTO CHITIETHD VALUES (5026, 4008, 48, 3150000, 7035);
INSERT INTO CHITIETHD VALUES (5026, 4010, 48, 2940000, 7036);
INSERT INTO CHITIETHD VALUES (5027, 4020, 24, 420000, 7037);
INSERT INTO CHITIETHD VALUES (5028, 4005, 4, 550000, 7038);
--HDPHAT
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('01-01-2024 13:50', 2000000, '�?ã thanh toán', 5001);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('18-02-2024 4:50', 1000000, '�?ã thanh toán', 5005);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('02-03-2024 14:00', 3000000, '�?ã thanh toán', 5009);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('10-03-2024 12:30', 500000, '�?ã thanh toán', 5010);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('03-04-2024 13:50', 5000000, '�?ã thanh toán', 5013);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('16-04-2024 08:04', 7000000, '�?ã thanh toán', 5016);
INSERT INTO HDPHAT (TGTao, TongTienPhat, TinhTrang, MaHD) VALUES ('16-04-2024 14:15', 7000000, '�?ã thanh toán', 5017);
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
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Xe được cung cấp đ�?u mới và sạch sẽ, đảm bảo an toàn và thoải mái ', 5002);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, '�?ội ngũ nhân viên thân thiện và chuyên nghiệp, luôn sẵn lòng hỗ trợ và giải đáp m�?i thắc mắc của khách hàng.', 5003);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Quy trình thuê xe linh hoạt và tiện lợi, tiết kiệm th�?i gian và công sức.', 5004);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Giá cả hợp lý và minh bạch, không có phí ẩn hay phụ phí bất ng�? khi thuê xe', 5005);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Xe đạt tiêu chuẩn an toàn cao, được trang bị đầy đủ các tính năng an toàn và kiểm soát hiện đại.', 5006);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Quy trình trả xe đơn giản và thuận tiện,tiết kiệm th�?i gian và không gặp phải bất kỳ rắc rối nào.', 5007);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Xe được trang bị đầy đủ các tính năng hiện đại và tiện nghi, tạo nên một trải nghiệm lái xe thoải mái và tiện lợi.', 5008);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Quy trình thuê xe được tổ chức rõ ràng và minh bạch, giúp hiểu rõ v�? các đi�?u khoản và đi�?u kiện thuê xe trước khi đồng ý với đơn hàng', 5009);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã thấy rất hài lòng với chất lượng và tính đa dạng của các loại xe được cung cấp bởi công ty, đáp ứng được m�?i nhu cầu và sở thích của khách hàng.', 5010);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Dịch vụ khách hàng của công ty là một trong những điểm mạnh, với nhân viên luôn sẵn lòng lắng nghe và giúp đỡ khách hàng trong m�?i tình huống.', 5011);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Dịch vụ đặt xe qua ứng dụng di động của công ty hoạt động mượt mà và tiện lợi, cho phép tôi dễ dàng quản lý đơn đặt hàng và nhận thông tin cập nhật v�? đơn hàng của mình.', 5012);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Tôi đã thấy rất ấn tượng với sự linh hoạt của công ty trong việc đáp ứng nhu cầu đặc biệt của khách hàng, như yêu cầu đặc biệt v�? loại xe hoặc đi�?u kiện thuê xe.', 5013);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã được hướng dẫn chi tiết v�? các tính năng và trang thiết bị của xe khi nhận xe, giúp tôi cảm thấy tự tin và thoải mái khi lái xe', 5014);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã nhận được một dịch vụ thuê xe linh hoạt và tiện lợi, với các lựa ch�?n đa dạng cho thuê xe ngắn hạn và dài hạn', 5015);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã được hỗ trợ và giải quyết m�?i vấn đ�? kỹ thuật hoặc sự cố với xe một cách nhanh chóng và chuyên nghiệp từ nhân viên kỹ thuật của công ty', 5016);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Tôi đã nhận được sự hài lòng tối đa từ dịch vụ thuê xe của công ty, với sự kết hợp hoàn hảo giữa chất lượng, tiện ích và giá trị, làm cho trải nghiệm thuê xe trở nên thú vị và tiện lợi hơn bao gi�? hết', 5017);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Công ty cung cấp các chương trình thưởng và điểm thưởng cho khách hàng thân thiết, tạo động lực cho tôi quay lại sử dụng dịch vụ của h�? một cách thư�?ng xuyên.', 5018);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (9, 'Tôi đã nhận được sự hỗ trợ tận tình và chuyên nghiệp từ nhân viên khi gặp phải vấn đ�? hoặc câu h�?i liên quan đến việc thuê xe, giúp tôi cảm thấy an tâm và tin tưởng.', 5019);
INSERT INTO DANHGIA (SoDiem, NoiDung, MaHD)  VALUES (10, 'Tôi đã được nhận một chiếc xe sạch sẽ và đảm bảo an toàn khi nhận xe, tạo sự yên tâm và tin tưởng trong suốt th�?i gian thuê xe.', 5020);

