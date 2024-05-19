/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.HoaDonDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import controller.TimKiemHoaDon;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public final class HoaDonForm extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonForm
     */
    private DefaultTableModel tblModel; //sử dụng để quản lý dữ liệu cho JTable
    private static ArrayList<HoaDon> ds;
    
    public HoaDonForm() {
        initComponents();
        jTable_HoaDon.setDefaultEditor(Object.class, null);
        initTable();
        ds = HoaDonDAO.getInstance().selectAll();
        loadDataToTable(ds);
    }
    
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã hóa đơn", "Thời gian tạo", "Tổng tiền thuê", "Thời gian nhận", "Thời gian trả", "Tổng tiền cọc", "Tình trạng", "Mã khách hàng", "Mã nhân viên"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTable_HoaDon.setModel(tblModel);
    }
    
    public void loadDataToTable(ArrayList<HoaDon> hd) {
        try {
            tblModel.setRowCount(0);
            for (HoaDon i : hd) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                tblModel.addRow(new Object[]{
                    i.getMaHD(), i.getTGTao().format(dtf), i.getTongTienThue(), i.getTGNhan().format(dtf), i.getTGTra().format(dtf), i.getTongTienCoc(), i.getTinhTrang(), i.getMaKH(), i.getMaNV()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonSelect() {
        int i_row = jTable_HoaDon.getSelectedRow();
        HoaDon hd = HoaDonDAO.getInstance().selectAll().get(i_row);
        return hd;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_HoaDon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton_CTHD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cbxLuachon = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jButton_LamMoi = new javax.swing.JButton();
        jButton_TimKiemHD = new javax.swing.JButton();
        jButton_ExcelHD = new javax.swing.JButton();
        jButton_SuaHD = new javax.swing.JButton();
        jButton_XoaHD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_HoaDon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1100, 820));
        setPreferredSize(new java.awt.Dimension(1100, 820));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_HoaDon.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_HoaDon.setPreferredSize(new java.awt.Dimension(1100, 820));
        jPanel_HoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HÓA ĐƠN");
        jPanel_HoaDon.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1010, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_HoaDon.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1010, 14));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_HoaDon.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 1010, 17));

        jButton_CTHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_CTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_detail.png"))); // NOI18N
        jButton_CTHD.setText(" Xem chi tiết");
        jButton_CTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_CTHDMouseClicked(evt);
            }
        });
        jButton_CTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CTHDActionPerformed(evt);
            }
        });
        jPanel_HoaDon.add(jButton_CTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 170, 41));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxLuachon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxLuachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã hóa đơn", "Ngày tạo", "Tổng tiền thuê", "Thời gian nhận", "Thời gian trả", "Tổng tiền cọc", "Tình trạng", "Mã khách hàng", "Mã nhân viên" }));
        jPanel4.add(cbxLuachon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel4.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 280, 40));

        jButton_LamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh.png"))); // NOI18N
        jButton_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LamMoiActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 40, 40));

        jButton_TimKiemHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_search.png"))); // NOI18N
        jButton_TimKiemHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_TimKiemHDMouseClicked(evt);
            }
        });
        jPanel4.add(jButton_TimKiemHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 40, 40));

        jPanel_HoaDon.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 590, 90));

        jButton_ExcelHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_ExcelHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_xls.png"))); // NOI18N
        jButton_ExcelHD.setText(" Xuất Excel");
        jButton_ExcelHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcelHDActionPerformed(evt);
            }
        });
        jPanel_HoaDon.add(jButton_ExcelHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 170, 41));

        jButton_SuaHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_SuaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_update.png"))); // NOI18N
        jButton_SuaHD.setText(" Sửa");
        jButton_SuaHD.setToolTipText("");
        jButton_SuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SuaHDActionPerformed(evt);
            }
        });
        jPanel_HoaDon.add(jButton_SuaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 170, 41));

        jButton_XoaHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_XoaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_delete.png"))); // NOI18N
        jButton_XoaHD.setText(" Xóa");
        jButton_XoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaHDActionPerformed(evt);
            }
        });
        jPanel_HoaDon.add(jButton_XoaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 170, 41));

        jTable_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Thời gian tạo", "Tổng tiền thuê", "Thời gian nhận", "Thời gian trả", "Tổng tiền cọc", "Tình trạng", "Mã khách hàng", "Mã nhân viên"
            }
        ));
        jScrollPane2.setViewportView(jTable_HoaDon);

        jPanel_HoaDon.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 1010, 520));

        add(jPanel_HoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 820));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CTHDMouseClicked
        // TODO add your handling code here:
        if (jTable_HoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xem chi tiết");
        } else {
            ChiTietHoaDon cthd = new ChiTietHoaDon(getHoaDonSelect());
            cthd.setVisible(true);
        }
    }//GEN-LAST:event_jButton_CTHDMouseClicked

    private void jButton_XoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaHDActionPerformed
        // TODO add your handling code here:
        if (jTable_HoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá hóa đơn", "Xác nhận xoá hóa đơn", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                HoaDonDAO.getInstance().delete(getHoaDonSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công hóa đơn "+getHoaDonSelect().getMaHD()+"!");
                loadDataToTable(HoaDonDAO.getInstance().selectAll());
            }
        }
    }//GEN-LAST:event_jButton_XoaHDActionPerformed

    private void jButton_SuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SuaHDActionPerformed
        // TODO add your handling code here:
        if (jTable_HoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn sửa");
        } else {
            SuaHoaDon a = new SuaHoaDon(getHoaDonSelect());
            a.setVisible(true);
        }
    }//GEN-LAST:event_jButton_SuaHDActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String luachon = (String) cbxLuachon.getSelectedItem();
        String text = txtSearch.getText();
        ArrayList<HoaDon> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả" -> result = TimKiemHoaDon.getInstance().tkTatCa(text);
            case "Mã hóa đơn" -> result = TimKiemHoaDon.getInstance().tkMaHD(text);
            case "Thời gian tạo" -> result = TimKiemHoaDon.getInstance().tkTGTao(text);
            case "Tổng tiền thuê" -> result = TimKiemHoaDon.getInstance().tkTongTienThue(text);
            case "Thời gian nhận" -> result = TimKiemHoaDon.getInstance().tkTGNhan(text);
            case "Thời gian trả" -> result = TimKiemHoaDon.getInstance().tkTGTra(text);
            case "Tổng tiền cọc" -> result = TimKiemHoaDon.getInstance().tkTongTienCoc(text);
            case "Tình trạng" -> result = TimKiemHoaDon.getInstance().tkTinhTrang(text);
            case "Mã khách hàng" -> result = TimKiemHoaDon.getInstance().tkMaKH(text);
            case "Mã nhân viên" -> result = TimKiemHoaDon.getInstance().tkMaHD(text);
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton_TimKiemHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TimKiemHDMouseClicked
        // TODO add your handling code here:
        String luachon = (String) cbxLuachon.getSelectedItem();
        String text = txtSearch.getText();
        ArrayList<HoaDon> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả" -> result = TimKiemHoaDon.getInstance().tkTatCa(text);
            case "Mã hóa đơn" -> result = TimKiemHoaDon.getInstance().tkMaHD(text);
            case "Thời gian tạo" -> result = TimKiemHoaDon.getInstance().tkTGTao(text);
            case "Tổng tiền thuê" -> result = TimKiemHoaDon.getInstance().tkTongTienThue(text);
            case "Thời gian nhận" -> result = TimKiemHoaDon.getInstance().tkTGNhan(text);
            case "Thời gian trả" -> result = TimKiemHoaDon.getInstance().tkTGTra(text);
            case "Tổng tiền cọc" -> result = TimKiemHoaDon.getInstance().tkTongTienCoc(text);
            case "Tình trạng" -> result = TimKiemHoaDon.getInstance().tkTinhTrang(text);
            case "Mã khách hàng" -> result = TimKiemHoaDon.getInstance().tkMaKH(text);
            case "Mã nhân viên" -> result = TimKiemHoaDon.getInstance().tkMaHD(text);
        }
        loadDataToTable(result);
    }//GEN-LAST:event_jButton_TimKiemHDMouseClicked

    private void jButton_ExcelHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcelHDActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("HoaDon");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < jTable_HoaDon.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(jTable_HoaDon.getColumnName(i));
                }

                for (int j = 0; j < jTable_HoaDon.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < jTable_HoaDon.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (jTable_HoaDon.getValueAt(j, k) != null) {
                            cell.setCellValue(jTable_HoaDon.getValueAt(j, k).toString());
                        }

                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_ExcelHDActionPerformed
    
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void jButton_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LamMoiActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        cbxLuachon.setSelectedIndex(0);
        loadDataToTable(HoaDonDAO.getInstance().selectAll());
    }//GEN-LAST:event_jButton_LamMoiActionPerformed

    private void jButton_CTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CTHDActionPerformed
        // TODO add your handling code here:
        if (jTable_HoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xem chi tiết");
        } else {
            ChiTietHoaDon cthd = new ChiTietHoaDon(getHoaDonSelect());
            cthd.setVisible(true);
        }
    }//GEN-LAST:event_jButton_CTHDActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxLuachon;
    private javax.swing.JButton jButton_CTHD;
    private javax.swing.JButton jButton_ExcelHD;
    private javax.swing.JButton jButton_LamMoi;
    private javax.swing.JButton jButton_SuaHD;
    private javax.swing.JButton jButton_TimKiemHD;
    private javax.swing.JButton jButton_XoaHD;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_HoaDon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable_HoaDon;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}