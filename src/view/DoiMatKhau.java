package view;

import dao.TaiKhoanDAO;
import javax.swing.JOptionPane;
import model.TaiKhoan;

public class DoiMatKhau extends javax.swing.JFrame {

    private TaiKhoan currentAcc;
    
    public DoiMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public DoiMatKhau(TaiKhoan t) {
        initComponents();
        setLocationRelativeTo(null);
        this.currentAcc = t;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtMKCu = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbDoiMK = new javax.swing.JButton();
        jtMKMoi = new javax.swing.JPasswordField();
        jtXacNhanMK = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GoGo Wheels");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Mật khẩu cũ:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Mật khẩu mới:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Nhập lại mật khẩu:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, 20));

        jtMKCu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(jtMKCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 344, 41));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ĐỔI MẬT KHẨU");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 344, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 344, 10));

        jbDoiMK.setBackground(new java.awt.Color(27, 121, 30));
        jbDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbDoiMK.setForeground(new java.awt.Color(255, 255, 255));
        jbDoiMK.setText("Lưu");
        jbDoiMK.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbDoiMK.setBorderPainted(false);
        jbDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDoiMKActionPerformed(evt);
            }
        });
        jPanel1.add(jbDoiMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 150, 40));

        jtMKMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtMKMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMKMoiActionPerformed(evt);
            }
        });
        jPanel1.add(jtMKMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 344, 41));

        jtXacNhanMK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtXacNhanMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtXacNhanMKActionPerformed(evt);
            }
        });
        jPanel1.add(jtXacNhanMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 344, 41));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtMKMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMKMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMKMoiActionPerformed

    private void jtXacNhanMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtXacNhanMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtXacNhanMKActionPerformed

    private void jbDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDoiMKActionPerformed
        // TODO add your handling code here:
        String matKhauCu = new String(jtMKCu.getPassword());
        String matKhauMoi = new String(jtMKMoi.getPassword());
        String xacNhanMatKhau = new String(jtXacNhanMK.getPassword());
        
        if (matKhauCu.isEmpty() || matKhauMoi.isEmpty() || xacNhanMatKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!matKhauMoi.equals(xacNhanMatKhau)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới không trùng khớp", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
        boolean result = taiKhoanDAO.doiMatKhau(currentAcc.getTenTK(), matKhauCu, matKhauMoi);

        if (result) {
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
           
        //Xóa dữ liệu sau khi cập nhật thành công    
            jtMKCu.setText("");
            jtMKMoi.setText("");
            jtXacNhanMK.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại. Vui lòng kiểm tra lại thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbDoiMKActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbDoiMK;
    private javax.swing.JPasswordField jtMKCu;
    private javax.swing.JPasswordField jtMKMoi;
    private javax.swing.JPasswordField jtXacNhanMK;
    // End of variables declaration//GEN-END:variables
}
