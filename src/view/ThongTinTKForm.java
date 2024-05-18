package view;

import javax.swing.JOptionPane;
import controller.PhienDangNhap;
import model.TaiKhoan;
    
public class ThongTinTKForm extends javax.swing.JPanel {
    private TaiKhoan currentAcc;
    private PhienDangNhap phienDangNhap;

    public ThongTinTKForm() {
        initComponents();
        phienDangNhap = new PhienDangNhap();
        hienThiThongTinTaiKhoan();
    }

    private void hienThiThongTinTaiKhoan() {
        currentAcc = phienDangNhap.getCurrentAcc();  // Sử dụng biến thành viên currentAcc
        if (currentAcc != null) {
            // Hiển thị thông tin tài khoản
            jtHoTen.setText(currentAcc.getHoTen());
            jtGioiTinh.setText(currentAcc.getGioiTinh());
            jtNgaySinh.setText(currentAcc.getNgaySinh().toString());
            jtChucVu.setText(currentAcc.getChucVu());
            jtLuong.setText(String.valueOf(currentAcc.getLuong()));
            jtNgayVaoLam.setText(currentAcc.getNgayVaoLam().toString());
            jtMaNV.setText(currentAcc.getMaNV());
            jtMaQL.setText(currentAcc.getMaQL());
            jtTenTK.setText(currentAcc.getTenTK());
        } else {
            JOptionPane.showMessageDialog(this, "Không có thông tin", "Hiển thị không thành công", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jtTenTK = new javax.swing.JTextField();
        jtHoTen = new javax.swing.JTextField();
        jtGioiTinh = new javax.swing.JTextField();
        jtNgaySinh = new javax.swing.JTextField();
        jtChucVu = new javax.swing.JTextField();
        jtLuong = new javax.swing.JTextField();
        jtNgayVaoLam = new javax.swing.JTextField();
        jtMaNV = new javax.swing.JTextField();
        jtMaQL = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1100, 820));
        setPreferredSize(new java.awt.Dimension(1100, 820));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 820));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(152, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN TÀI KHOẢN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 24, 1010, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setText("Họ và tên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 34));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setText("Giới tính:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 200, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel4.setText("Ngày sinh:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 200, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel5.setText("Chức vụ:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 200, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel6.setText("Lương:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setText("Ngày vào làm:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 200, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel8.setText("Mã số nhân viên:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 200, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel9.setText("Mã số quản lý:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 200, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel10.setText("Tên tài khoản:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 200, -1));

        jButton5.setBackground(new java.awt.Color(27, 121, 30));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Đổi mật khẩu");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 710, 273, 55));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1010, 14));

        jtTenTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtTenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 620, 620, 40));

        jtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 620, 40));

        jtGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 620, 40));

        jtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 620, 40));

        jtChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 620, 40));

        jtLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 620, 40));

        jtNgayVaoLam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtNgayVaoLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 620, 40));

        jtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 620, 40));

        jtMaQL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jtMaQL, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 620, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1192, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DoiMatKhau doiMK = new DoiMatKhau();
        doiMK.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jtChucVu;
    private javax.swing.JTextField jtGioiTinh;
    private javax.swing.JTextField jtHoTen;
    private javax.swing.JTextField jtLuong;
    private javax.swing.JTextField jtMaNV;
    private javax.swing.JTextField jtMaQL;
    private javax.swing.JTextField jtNgaySinh;
    private javax.swing.JTextField jtNgayVaoLam;
    private javax.swing.JTextField jtTenTK;
    // End of variables declaration//GEN-END:variables
}
