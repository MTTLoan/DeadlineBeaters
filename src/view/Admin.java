/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.TaiKhoan;
/**
 *
 * @author ASUS
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    Color DefaultColor, ClickedColor;
    private TaiKhoan currentAcc;
    
    public Admin() {
        //tạo đường kẻ cho JTable
        UIManager.put("Table.showVerticalLines", true);
        UIManager.put("Table.showHorizontalLines", true);
        initComponents();
        setLocationRelativeTo(null);
        DefaultColor = new Color(152, 0, 0);
        ClickedColor = new Color(27,121, 30);
    }
    
    public Admin(TaiKhoan t) {
        //tạo đường kẻ cho JTable
        UIManager.put("Table.showVerticalLines", true);
        UIManager.put("Table.showHorizontalLines", true);
        initComponents();
        setLocationRelativeTo(null);
        this.currentAcc = t;
        DefaultColor = new Color(152, 0, 0);
        ClickedColor = new Color(27,121, 30);
        MainContent.validate();
        MainContent.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavbarMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DatXe = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        DangXuat = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        ThongTin = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        HoaDon = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        DanhGia = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        ThongKe = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        HoaDonPhat = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        TaiKhoan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gogo Wheels");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1380, 850));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavbarMenu.setBackground(new java.awt.Color(152, 0, 0));
        NavbarMenu.setName(""); // NOI18N
        NavbarMenu.setPreferredSize(new java.awt.Dimension(281, 820));
        NavbarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(152, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GOGO WHEELS ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Công ty dịch vụ cho thuê xe");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        NavbarMenu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 282, -1));

        DatXe.setBackground(new java.awt.Color(152, 0, 0));
        DatXe.setPreferredSize(new java.awt.Dimension(0, 54));
        DatXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatXeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DatXeMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checkout.png"))); // NOI18N
        jLabel5.setText(" ĐẶT XE");

        javax.swing.GroupLayout DatXeLayout = new javax.swing.GroupLayout(DatXe);
        DatXe.setLayout(DatXeLayout);
        DatXeLayout.setHorizontalGroup(
            DatXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatXeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        DatXeLayout.setVerticalGroup(
            DatXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatXeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        NavbarMenu.add(DatXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 250, 60));

        DangXuat.setBackground(new java.awt.Color(152, 0, 0));
        DangXuat.setPreferredSize(new java.awt.Dimension(88, 62));
        DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangXuatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DangXuatMousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_logout.png"))); // NOI18N
        jLabel12.setText("ĐĂNG XUẤT");

        javax.swing.GroupLayout DangXuatLayout = new javax.swing.GroupLayout(DangXuat);
        DangXuat.setLayout(DangXuatLayout);
        DangXuatLayout.setHorizontalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangXuatLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        DangXuatLayout.setVerticalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DangXuatLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        NavbarMenu.add(DangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 720, 250, 60));

        ThongTin.setBackground(new java.awt.Color(152, 0, 0));
        ThongTin.setPreferredSize(new java.awt.Dimension(88, 62));
        ThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongTinMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ThongTinMousePressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(152, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_account_1.png"))); // NOI18N
        jLabel11.setText(" THÔNG TIN");

        javax.swing.GroupLayout ThongTinLayout = new javax.swing.GroupLayout(ThongTin);
        ThongTin.setLayout(ThongTinLayout);
        ThongTinLayout.setHorizontalGroup(
            ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        ThongTinLayout.setVerticalGroup(
            ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        NavbarMenu.add(ThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 250, 60));

        HoaDon.setBackground(new java.awt.Color(152, 0, 0));
        HoaDon.setPreferredSize(new java.awt.Dimension(0, 54));
        HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HoaDonMousePressed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(152, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_invoice.png"))); // NOI18N
        jLabel13.setText(" HÓA ĐƠN");

        javax.swing.GroupLayout HoaDonLayout = new javax.swing.GroupLayout(HoaDon);
        HoaDon.setLayout(HoaDonLayout);
        HoaDonLayout.setHorizontalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        HoaDonLayout.setVerticalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(15, 15, 15))
        );

        NavbarMenu.add(HoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, 60));

        DanhGia.setBackground(new java.awt.Color(152, 0, 0));
        DanhGia.setPreferredSize(new java.awt.Dimension(0, 54));
        DanhGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DanhGiaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DanhGiaMousePressed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(153, 153, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_feedback.png"))); // NOI18N
        jLabel15.setText(" ĐÁNH GIÁ");

        javax.swing.GroupLayout DanhGiaLayout = new javax.swing.GroupLayout(DanhGia);
        DanhGia.setLayout(DanhGiaLayout);
        DanhGiaLayout.setHorizontalGroup(
            DanhGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhGiaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        DanhGiaLayout.setVerticalGroup(
            DanhGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DanhGiaLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(15, 15, 15))
        );

        NavbarMenu.add(DanhGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        ThongKe.setBackground(new java.awt.Color(152, 0, 0));
        ThongKe.setPreferredSize(new java.awt.Dimension(0, 54));
        ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ThongKeMousePressed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(153, 153, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_statistics.png"))); // NOI18N
        jLabel16.setText(" THỐNG KÊ");

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongKeLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(15, 15, 15))
        );

        NavbarMenu.add(ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 250, 60));

        HoaDonPhat.setBackground(new java.awt.Color(152, 0, 0));
        HoaDonPhat.setPreferredSize(new java.awt.Dimension(0, 54));
        HoaDonPhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoaDonPhatMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HoaDonPhatMousePressed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(153, 153, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_fine.png"))); // NOI18N
        jLabel17.setText(" HÓA ĐƠN PHẠT");

        javax.swing.GroupLayout HoaDonPhatLayout = new javax.swing.GroupLayout(HoaDonPhat);
        HoaDonPhat.setLayout(HoaDonPhatLayout);
        HoaDonPhatLayout.setHorizontalGroup(
            HoaDonPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonPhatLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel17)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        HoaDonPhatLayout.setVerticalGroup(
            HoaDonPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonPhatLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(15, 15, 15))
        );

        NavbarMenu.add(HoaDonPhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 250, 60));

        TaiKhoan.setBackground(new java.awt.Color(152, 0, 0));
        TaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaiKhoanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TaiKhoanMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_add_account.png"))); // NOI18N
        jLabel4.setText(" TÀI KHOẢN");

        javax.swing.GroupLayout TaiKhoanLayout = new javax.swing.GroupLayout(TaiKhoan);
        TaiKhoan.setLayout(TaiKhoanLayout);
        TaiKhoanLayout.setHorizontalGroup(
            TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        TaiKhoanLayout.setVerticalGroup(
            TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TaiKhoanLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
        );

        NavbarMenu.add(TaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 250, 60));

        getContentPane().add(NavbarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MainContent.setBackground(new java.awt.Color(255, 255, 255));
        MainContent.setPreferredSize(new java.awt.Dimension(1100, 820));

        javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(MainContent);
        MainContent.setLayout(MainContentLayout);
        MainContentLayout.setHorizontalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        MainContentLayout.setVerticalGroup(
            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );

        getContentPane().add(MainContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1100, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatXeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatXeMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(ClickedColor);
        HoaDon.setBackground(DefaultColor);
        HoaDonPhat.setBackground(DefaultColor);
        DanhGia.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongTin.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_DatXeMousePressed

    private void HoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoaDonMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(DefaultColor);
        HoaDon.setBackground(ClickedColor);
        HoaDonPhat.setBackground(DefaultColor);
        DanhGia.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongTin.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_HoaDonMousePressed

    private void DanhGiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DanhGiaMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(DefaultColor);
        HoaDon.setBackground(DefaultColor);
        HoaDonPhat.setBackground(DefaultColor);
        DanhGia.setBackground(ClickedColor);
        ThongKe.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongTin.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_DanhGiaMousePressed

    private void ThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(DefaultColor);
        HoaDon.setBackground(DefaultColor);
        HoaDonPhat.setBackground(DefaultColor);
        DanhGia.setBackground(DefaultColor);
        ThongKe.setBackground(ClickedColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongTin.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_ThongKeMousePressed

    private void ThongTinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongTinMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(DefaultColor);
        HoaDon.setBackground(DefaultColor);
        HoaDonPhat.setBackground(DefaultColor);
        DanhGia.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongTin.setBackground(ClickedColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_ThongTinMousePressed

    private void DangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DangXuatMousePressed

    private void DatXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatXeMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        DatXeForm dx = new DatXeForm();
        MainContent.setLayout(new BorderLayout());
        MainContent.add(dx).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_DatXeMouseClicked

    private void HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoaDonMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        HoaDonForm hd = new HoaDonForm();
        MainContent.add(hd).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_HoaDonMouseClicked

    private void DanhGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DanhGiaMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        DanhGiaForm dg = new DanhGiaForm();
        MainContent.add(dg).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_DanhGiaMouseClicked

    private void ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        ThongKeForm tk = new ThongKeForm();
        MainContent.add(tk).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_ThongKeMouseClicked

    private void ThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongTinMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        ThongTinTKForm tt = new ThongTinTKForm(currentAcc);
        MainContent.add(tt).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_ThongTinMouseClicked

    private void DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMouseClicked
        // TODO add your handling code here:
        int relly = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn đăng xuất?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (relly == JOptionPane.YES_OPTION) {
            this.dispose();
            DangNhapForm a = new DangNhapForm();
            a.setVisible(true);
        } else {
            DangXuat.setBackground(DefaultColor);
        }
    }//GEN-LAST:event_DangXuatMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát ?", "Exit?", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void HoaDonPhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoaDonPhatMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        HoaDonPhatForm hdp  = new HoaDonPhatForm();
        MainContent.add(hdp).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_HoaDonPhatMouseClicked

    private void HoaDonPhatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoaDonPhatMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(DefaultColor);
        HoaDon.setBackground(DefaultColor);
        HoaDonPhat.setBackground(ClickedColor);
        DanhGia.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongTin.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_HoaDonPhatMousePressed

    private void TaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanMouseClicked
        // TODO add your handling code here:
        MainContent.removeAll();
        TaiKhoanForm tk = new TaiKhoanForm();
        MainContent.add(tk).setVisible(true);
        MainContent.validate();
        MainContent.repaint();
    }//GEN-LAST:event_TaiKhoanMouseClicked

    private void TaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanMousePressed
        // TODO add your handling code here:
        DatXe.setBackground(DefaultColor);
        HoaDon.setBackground(DefaultColor);
        HoaDonPhat.setBackground(DefaultColor);
        DanhGia.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        TaiKhoan.setBackground(ClickedColor);
        ThongTin.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
    }//GEN-LAST:event_TaiKhoanMousePressed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DangXuat;
    private javax.swing.JPanel DanhGia;
    private javax.swing.JPanel DatXe;
    private javax.swing.JPanel HoaDon;
    private javax.swing.JPanel HoaDonPhat;
    private javax.swing.JPanel MainContent;
    private javax.swing.JPanel NavbarMenu;
    private javax.swing.JPanel TaiKhoan;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JPanel ThongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
