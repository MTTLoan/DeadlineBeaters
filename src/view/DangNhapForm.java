package view;

import com.formdev.flatlaf.FlatLightLaf;
import dao.TaiKhoanDAO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.TaiKhoan;

public class DangNhapForm extends javax.swing.JFrame {

    public DangNhapForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtTenTK = new javax.swing.JTextField();
        jtMatKhau = new javax.swing.JPasswordField();
        jbDangNhap = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GoGo Wheels");
        setBackground(new java.awt.Color(152, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255,230));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_car.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 120, 75));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 0, 0));
        jLabel2.setText("ĐĂNG NHẬP");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, 160, -1));

        jtTenTK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtTenTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtTenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTenTKActionPerformed(evt);
            }
        });
        jPanel2.add(jtTenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 150, 30));

        jtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMatKhauActionPerformed(evt);
            }
        });
        jPanel2.add(jtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 30));

        jbDangNhap.setBackground(new java.awt.Color(152, 0, 0));
        jbDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jbDangNhap.setText("ĐĂNG NHẬP");
        jbDangNhap.setToolTipText("");
        jbDangNhap.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jbDangNhap.setBorderPainted(false);
        jbDangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDangNhapActionPerformed(evt);
            }
        });
        jPanel2.add(jbDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 190, 40));
        jbDangNhap.getAccessibleContext().setAccessibleName("LoginButton");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_account.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 30, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_lock.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 30, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 160, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(540, 350));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background_login.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 350));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDangNhapActionPerformed
        // TODO add your handling code here:
        String tenTaiKhoan = jtTenTK.getText();
        String matKhau = new String(jtMatKhau.getPassword());

        // Kiểm tra đăng nhập
        TaiKhoanDAO taiKhoanDAO = TaiKhoanDAO.getInstance();
        TaiKhoan taiKhoan = taiKhoanDAO.kiemTraDangNhap(tenTaiKhoan, matKhau);

        if (taiKhoan != null) {
            // Đăng nhập thành công
            switch (taiKhoan.getChucVu()) {
                case "Admin" -> {
                    // Hiển thị giao diện cho admin
                    Admin adminFrame = new Admin(taiKhoan);
                    adminFrame.setVisible(true);
                }
                case "Quản lý" -> {
                    // Hiển thị giao diện cho quản lý
                    QuanLy quanLyFrame = new QuanLy(taiKhoan);
                    quanLyFrame.setVisible(true);
                }
                case "Nhân viên" -> {
                    // Hiển thị giao diện cho nhân viên
                    NhanVien nhanVienFrame = new NhanVien(taiKhoan);
                    nhanVienFrame.setVisible(true);
                }
                default -> {
                }
            }
            // Đóng cửa sổ đăng nhập
            this.dispose();
        } else {
            // Đăng nhập không thành công, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Tên tài khoản hoặc mật khẩu không chính xác!", "Đăng nhập không thành công", JOptionPane.ERROR_MESSAGE);
        }                                         
    }//GEN-LAST:event_jbDangNhapActionPerformed

    private void jtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMatKhauActionPerformed

    private void jtTenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTenTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTenTKActionPerformed

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
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbDangNhap;
    private javax.swing.JPasswordField jtMatKhau;
    private javax.swing.JTextField jtTenTK;
    // End of variables declaration//GEN-END:variables
}
