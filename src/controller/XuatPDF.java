/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import dao.ChiTietHDDAO;
import dao.HoaDonDAO;
import dao.TaiKhoanDAO;
import dao.XeDAO;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ChiTietHD;
import model.HoaDon;
import model.Xe;

public class XuatPDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public XuatPDF() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(XuatPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Phương thức chọn đường dẫn lưu file
    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy đường đẫn file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Không gọi được document !");
        }
    }

    // Phương thức thiết lập tiêu đề
    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }
    
    //hiển thị cửa sổ chọn thư mục lưu file pdf và trả về URL
    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    // Phương thức ghi hóa đơn
    public void writeHoaDon(String MaHD) {
        String url = "";
        try {
            fd.setTitle("In hóa đon");
            fd.setLocationRelativeTo(null);
            url = getFile(MaHD);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("HÓA ĐƠN");

            HoaDon hd = HoaDonDAO.getInstance().selectById(MaHD);

            Chunk glue = new Chunk(new VerticalPositionMark());
            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add("Mã hóa đon: " + hd.getMaHD());
            para1.add("\nThời gian tạo: " + hd.getTGTao().format(dtf));
            para1.add("\nThời gian nhận: " + hd.getTGNhan().format(dtf));
            para1.add("\nThời gian trả: " + hd.getTGTra().format(dtf));
            para1.add("\nChú thích: " + hd.getChuThich());
            para1.setIndentationLeft(40);
            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);

            //Tạo bảng cho chi tiết hóa đơn
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            PdfPCell cell;

            //Tạo headers
            pdfTable.addCell(new PdfPCell(new Phrase("Mã xe", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên xe", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số ngày", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số tiền", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Viết thông tin
            for (ChiTietHD cthd : ChiTietHDDAO.getInstance().selectByMaHD(MaHD)) {
                Xe x = XeDAO.getInstance().selectById(Integer.toString(cthd.getMaXe()));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(cthd.getMaXe()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(x.getTenXe(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(x.getDonGia()) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(cthd.getSoNgay()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(cthd.getSoTien()) + "đ", fontData)));
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongTienCoc = new Paragraph(new Phrase("Tổng tiền cọc: " + formatter.format(hd.getTongTienCoc()) + "đ", fontData));
            Paragraph paraTongTienThue = new Paragraph(new Phrase("Tổng tiền thuê: " + formatter.format(hd.getTongTienThue()) + "đ", fontData));
            paraTongTienCoc.setIndentationLeft(300);
            paraTongTienThue.setIndentationLeft(300);
            document.add(paraTongTienCoc);
            document.add(paraTongTienThue);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    // Phương thức mở file
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
