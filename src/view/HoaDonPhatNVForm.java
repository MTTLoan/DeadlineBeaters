/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.TimKiemCTHDP;
import dao.HDPhatDAO;
import dao.HoaDonDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HDPhat;
import model.HoaDon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class HoaDonPhatNVForm extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonPhatForm
     */
    private DefaultTableModel tblModel; //sử dụng để quản lý dữ liệu cho JTable
    private static ArrayList<HDPhat> ds;
    
    public HoaDonPhatNVForm() {
        initComponents();
        jTable_CTHDPhat.setDefaultEditor(Object.class, null);
        initTable();
        ds = HDPhatDAO.getInstance().selectAll();
        loadDataToTable(ds);
    }
    
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã hóa đơn phạt", "Thời gian tạo", "Tổng tiền phạt", "Tình trạng", "Mã hóa đơn"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTable_CTHDPhat.setModel(tblModel);
    }

    public void loadDataToTable(ArrayList<HDPhat> hd) {
        try {
            tblModel.setRowCount(0);
            for (HDPhat i : hd) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                tblModel.addRow(new Object[]{
                    i.getMaHDP(), i.getTGTao().format(dtf), i.getTongTienPhat(), i.getTinhTrang(), i.getMaHD()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HoaDon getHDPhatSelect() {
        int i_row = jTable_CTHDPhat.getSelectedRow();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_Excel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxLuachon = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jButton_TimKiem = new javax.swing.JButton();
        jButton_LamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_CTHDPhat = new javax.swing.JTable();
        jButton_CTHDP = new javax.swing.JButton();
        jButton_ThemHDP = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(152, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN PHẠT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1010, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1010, 14));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 1010, 17));

        jButton_Excel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_xls.png"))); // NOI18N
        jButton_Excel.setText(" Xuất Excel");
        jButton_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 170, 41));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxLuachon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxLuachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã hóa đơn phạt", "Mã xe", "Loại phạt", "Chú thích" }));
        jPanel3.add(cbxLuachon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchPropertyChange(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 240, 40));

        jButton_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_search.png"))); // NOI18N
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 40, 40));

        jButton_LamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh.png"))); // NOI18N
        jButton_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LamMoiActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 40, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 570, 90));

        jTable_CTHDPhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn phạt", "Mã xe", "Loại phạt", "Số tiền", "Chú thích", "Hình ảnh"
            }
        ));
        jScrollPane1.setViewportView(jTable_CTHDPhat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 1010, 520));

        jButton_CTHDP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_CTHDP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_detail.png"))); // NOI18N
        jButton_CTHDP.setText(" Xem chi tiết");
        jButton_CTHDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CTHDPActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_CTHDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 170, 41));

        jButton_ThemHDP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_ThemHDP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_add.png"))); // NOI18N
        jButton_ThemHDP.setText(" Thêm");
        jButton_ThemHDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ThemHDPMouseClicked(evt);
            }
        });
        jPanel1.add(jButton_ThemHDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 160, 41));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1112, 820));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcelActionPerformed
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
                for (int i = 0; i < jTable_CTHDPhat.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(jTable_CTHDPhat.getColumnName(i));
                }

                for (int j = 0; j < jTable_CTHDPhat.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < jTable_CTHDPhat.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (jTable_CTHDPhat.getValueAt(j, k) != null) {
                            cell.setCellValue(jTable_CTHDPhat.getValueAt(j, k).toString());
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
    }//GEN-LAST:event_jButton_ExcelActionPerformed
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPropertyChange

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_CTHDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CTHDPActionPerformed
        // TODO add your handling code here:
        if (jTable_CTHDPhat.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xem chi tiết");
        } else {
            ChiTietHoaDon cthd = new ChiTietHoaDon(getHDPhatSelect());
            cthd.setVisible(true);
        }
    }//GEN-LAST:event_jButton_CTHDPActionPerformed

    private void jButton_ThemHDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ThemHDPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ThemHDPMouseClicked

    private void jButton_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LamMoiActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        cbxLuachon.setSelectedIndex(0);
        loadDataToTable(HDPhatDAO.getInstance().selectAll());
    }//GEN-LAST:event_jButton_LamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxLuachon;
    private javax.swing.JButton jButton_CTHDP;
    private javax.swing.JButton jButton_Excel;
    private javax.swing.JButton jButton_LamMoi;
    private javax.swing.JButton jButton_ThemHDP;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_CTHDPhat;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
