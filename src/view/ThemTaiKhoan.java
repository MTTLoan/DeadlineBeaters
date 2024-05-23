/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
import model.TaiKhoan;
import dao.TaiKhoanDAO;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ThemTaiKhoan extends javax.swing.JFrame {

    /**
     * Creates new form ThemTaiKhoan
     */
    
    public ThemTaiKhoan() {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThoat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        txtMaQL = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtTenTK = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        cbxChucVu = new javax.swing.JComboBox<>();
        jDateChooser_NgaySinh = new com.toedter.calendar.JDateChooser();
        jDateChooser_NgayVaoLam = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(460, 650));
        setPreferredSize(new java.awt.Dimension(470, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tên tài khoản:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 121, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Mật khẩu:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 121, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÊM TÀI KHOẢN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 15, 365, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 57, 378, 10));

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
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 137, 30));

        btnThem.setBackground(new java.awt.Color(27, 121, 30));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.setBorderPainted(false);
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 142, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Họ và tên:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 121, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Giới tính:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 121, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Ngày sinh:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 121, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Chức vụ:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 121, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Lương:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 121, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Ngày vào làm:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Mã quản lý:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 121, -1));

        cbxGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanel1.add(cbxGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 228, -1));

        txtMaQL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtMaQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 228, 29));

        txtLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 228, 29));

        txtTenTK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtTenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 228, 29));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 228, 29));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 228, 29));

        cbxChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản Lý", "Admin" }));
        jPanel1.add(cbxChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 228, -1));

        jDateChooser_NgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(jDateChooser_NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 230, 30));

        jDateChooser_NgayVaoLam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(jDateChooser_NgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        // Kiểm tra tính đầy đủ và hợp lệ của dữ liệu
        if (txtTenTK.getText().isEmpty() || txtMatKhau.getText().isEmpty() || txtHoTen.getText().isEmpty() || ((String) cbxGioiTinh.getSelectedItem()).isEmpty() || 
            ((String) cbxChucVu.getSelectedItem()).isEmpty() || txtLuong.getText().isEmpty() || jDateChooser_NgaySinh.getDate() == null || 
            jDateChooser_NgayVaoLam.getDate() == null || txtMaQL.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Lấy dữ liệu từ các trường nhập liệu
            String tenTK = txtTenTK.getText();
            String matKhau = txtMatKhau.getText();
            String hoTen = txtHoTen.getText();
            String gioiTinh = (String) cbxGioiTinh.getSelectedItem();
            LocalDate ngaySinh = jDateChooser_NgaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String chucVu = (String) cbxChucVu.getSelectedItem();
            int luong;
            try {
                luong = Integer.parseInt(txtLuong.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Lương không hợp lệ! Vui lòng nhập số.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            LocalDate ngayVaoLam = jDateChooser_NgayVaoLam.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int maQL = Integer.parseInt(txtMaQL.getText());

            // Kiểm tra sự tồn tại của tài khoản và thêm vào cơ sở dữ liệu
            if (TaiKhoanDAO.getInstance().selectById(tenTK) == null) {
                TaiKhoan taiKhoan = new TaiKhoan(0, tenTK, matKhau, hoTen, gioiTinh, ngaySinh, chucVu, luong, ngayVaoLam, maQL);
                TaiKhoanDAO.getInstance().insert(taiKhoan);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemMouseClicked

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
            //public void run() {
                //new ThemTaiKhoan().setVisible(true);
            //}
        //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbxChucVu;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private com.toedter.calendar.JDateChooser jDateChooser_NgaySinh;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayVaoLam;
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
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaQL;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenTK;
    // End of variables declaration//GEN-END:variables
}
