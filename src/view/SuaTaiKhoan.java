/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.TaiKhoanDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.TaiKhoan;

/**
 *
 * @author ASUS
 */
public class SuaTaiKhoan extends javax.swing.JFrame {

    /**
     * Creates new form ThemTaiKhoan
     */
    private TaiKhoan tk = null;
    
    public SuaTaiKhoan() {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public SuaTaiKhoan(TaiKhoan tk) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.tk = tk;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        jTextField_MaNV.setText(Integer.toString(tk.getMaNV()));
        jTextField_TenTK.setText(tk.getTenTK());
        jTextField_MatKhau.setText(tk.getMatKhau());
        jTextField_HoTen.setText(tk.getHoTen());
        jTextField_GioiTinh.setText(tk.getGioiTinh());
        jTextField_NgaySinh.setText(tk.getNgaySinh().format(dtf));
        jTextField_Luong.setText(Integer.toString(tk.getLuong()));
        jTextField_NgayVaoLam.setText(tk.getNgayVaoLam().format(dtf));
        jTextField_MaQL.setText(Integer.toString(tk.getMaQL()));
        jTextField_ChucVu.setText(tk.getChucVu());
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThoat = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField_MaNV = new javax.swing.JTextField();
        jTextField_MaQL = new javax.swing.JTextField();
        jTextField_Luong = new javax.swing.JTextField();
        jTextField_TenTK = new javax.swing.JTextField();
        jTextField_MatKhau = new javax.swing.JTextField();
        jTextField_HoTen = new javax.swing.JTextField();
        jTextField_GioiTinh = new javax.swing.JTextField();
        jTextField_NgaySinh = new javax.swing.JTextField();
        jTextField_NgayVaoLam = new javax.swing.JTextField();
        jTextField_ChucVu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Mã số nhân viên:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Tên tài khoản:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 230, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Mật khẩu:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 230, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SỬA TÀI KHOẢN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 27, 600, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 69, 600, 10));

        btnThoat.setBackground(new java.awt.Color(153, 0, 0));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThoat.setBorderPainted(false);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 137, 40));

        btnSua.setBackground(new java.awt.Color(27, 121, 30));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSua.setBorderPainted(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 142, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Họ và tên:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 230, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Giới tính:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 230, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Ngày sinh:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 230, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setText("Chức vụ:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 230, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setText("Lương:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 230, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Ngày vào làm:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 230, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("Mã quản lý:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 230, 30));

        jTextField_MaNV.setEditable(false);
        jTextField_MaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_MaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 230, -1));

        jTextField_MaQL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField_MaQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MaQLActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_MaQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 230, 29));

        jTextField_Luong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_Luong, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 228, 29));

        jTextField_TenTK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField_TenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TenTKActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_TenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 230, 30));

        jTextField_MatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_MatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 230, 29));

        jTextField_HoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_HoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 230, 30));

        jTextField_GioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField_GioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_GioiTinhActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_GioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 230, 29));

        jTextField_NgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 230, -1));

        jTextField_NgayVaoLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_NgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 228, 29));

        jTextField_ChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jTextField_ChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 228, 29));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int MaNV = Integer.parseInt(jTextField_MaNV.getText());
        String TenTK = jTextField_TenTK.getText();
        String MatKhau = jTextField_MatKhau.getText();
        String HoTen = jTextField_HoTen.getText();
        String GioiTinh = jTextField_GioiTinh.getText();
        LocalDate NgaySinh = LocalDate.parse(jTextField_NgaySinh.getText());
        String ChucVu = jTextField_ChucVu.getText();
        int Luong = Integer.parseInt(jTextField_Luong.getText());
        LocalDate NgayVaoLam = LocalDate.parse(jTextField_NgayVaoLam.getText());
        int MaQL = Integer.parseInt(jTextField_MaQL.getText());
        // Tạo một đối tượng TaiKhoan với các giá trị đã nhập
        TaiKhoan tk = new TaiKhoan(MaNV, TenTK, MatKhau, HoTen, GioiTinh, NgaySinh, ChucVu, Luong, NgayVaoLam, MaQL);

        try {
            // Thực hiện cập nhật thông tin tài khoản
            TaiKhoanDAO.getInstance().update(tk);
            this.dispose();
            JOptionPane.showMessageDialog(this,"Cập nhật thành công !");
        } catch (Exception e) {
            // Xử lý nếu có bất kỳ ngoại lệ nào xảy ra
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");
            e.printStackTrace();
    }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jTextField_TenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TenTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TenTKActionPerformed

    private void jTextField_GioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_GioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_GioiTinhActionPerformed

    private void jTextField_MaQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MaQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_MaQLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_ChucVu;
    private javax.swing.JTextField jTextField_GioiTinh;
    private javax.swing.JTextField jTextField_HoTen;
    private javax.swing.JTextField jTextField_Luong;
    private javax.swing.JTextField jTextField_MaNV;
    private javax.swing.JTextField jTextField_MaQL;
    private javax.swing.JTextField jTextField_MatKhau;
    private javax.swing.JTextField jTextField_NgaySinh;
    private javax.swing.JTextField jTextField_NgayVaoLam;
    private javax.swing.JTextField jTextField_TenTK;
    // End of variables declaration//GEN-END:variables

}