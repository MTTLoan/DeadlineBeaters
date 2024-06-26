/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */
import dao.HoaDonDAO;
import dao.XeDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongKeForm extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeForm
     */
    public ThongKeForm() {
        initComponents();
        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();
        jComboBox_Thang.setSelectedItem(Integer.toString(month));
        jComboBox_Nam.setSelectedItem(Integer.toString(year));
        updateStatistics(month, year);
    }
    private void updateStatistics(int month, int year) {
        
        // Fetch top rented cars
        ArrayList<Object[]> topRentedCars = XeDAO.getInstance().getTopRentedCars(month, year);
        DefaultTableModel model = (DefaultTableModel) tblTop.getModel();
        model.setRowCount(0);
        for (Object[] row : topRentedCars) {
            model.addRow(row);
        }

        // Fetch revenue data
        long bikeRevenue = HoaDonDAO.getInstance().getRevenueByVehicleisBike(month, year);
        long car4Revenue = HoaDonDAO.getInstance().getRevenueByVehicleisCar4(month, year);
        long car7Revenue = HoaDonDAO.getInstance().getRevenueByVehicleisCar7(month, year);
        long totalRevenue = bikeRevenue + car4Revenue + car7Revenue;
        

        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        barChartData.setValue(bikeRevenue,"Doanh thu","Xe máy");
        barChartData.setValue(car4Revenue, "Doanh thu", "Xe 4 chỗ");
        barChartData.setValue(car7Revenue, "Doanh thu", "Xe 7 chỗ");
        
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ doanh thu","Tháng "+ month + ", năm "+ year,"Doanh thu",barChartData,PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.RED);
        
        ChartPanel barPanel = new ChartPanel(barChart);
        jPanelChar.removeAll();
        jPanelChar.add(barPanel,BorderLayout.CENTER);
        jPanelChar.validate();

        // Update labels
        SoHoaDon.setText("Số hóa đơn: " + HoaDonDAO.getInstance().getTongHoaDon(month, year));
        DoanhThu.setText("Tổng doanh thu: " + totalRevenue);
        DT_XeMay.setText("Xe máy: " + bikeRevenue);
        DT_Xe4.setText("Xe 4 chỗ: " + car4Revenue);
        DT_Xe7.setText("Xe 7 chỗ: " + car7Revenue);
    }
    // Method to display overall information
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jComboBox_Thang = new javax.swing.JComboBox<>();
        jComboBox_Nam = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTop = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        SoHoaDon = new javax.swing.JLabel();
        DT_XeMay = new javax.swing.JLabel();
        DT_Xe4 = new javax.swing.JLabel();
        DT_Xe7 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        DoanhThu = new javax.swing.JLabel();
        jPanelChar = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(1180, 710));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Thang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox_Thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel5.add(jComboBox_Thang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 50, 40));

        jComboBox_Nam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox_Nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2023", "2022", "2021" }));
        jComboBox_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NamActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox_Nam, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 40));

        tblTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tblTop.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblTop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null},
                {"2", null, null},
                {"3", null, null},
                {"4", null, null},
                {"5", null, null},
                {"6", null, null},
                {"7", null, null},
                {"8", null, null},
                {"9", null, null},
                {"10", null, null}
            },
            new String [] {
                "Top", "Mã xe", "Số lần"
            }
        ));
        tblTop.setGridColor(new java.awt.Color(102, 102, 102));
        tblTop.setRowHeight(45);
        tblTop.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tblTop.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tblTop.setShowGrid(true);
        jScrollPane2.setViewportView(tblTop);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 370, 480));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("nhiều nhất trong tháng");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 270, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Tháng:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Năm:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setText(" Top 10 xe được thuê ");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, 30));

        SoHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SoHoaDon.setText("Số hóa đơn:");
        jPanel5.add(SoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, 250, 30));

        DT_XeMay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DT_XeMay.setText("Xe máy:");
        jPanel5.add(DT_XeMay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 600, 30));

        DT_Xe4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DT_Xe4.setText("Xe 4 chỗ:");
        jPanel5.add(DT_Xe4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 610, 30));

        DT_Xe7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DT_Xe7.setText("Xe 7 chỗ:");
        jPanel5.add(DT_Xe7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 600, 30));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel5.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 41, 40, 40));

        DoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DoanhThu.setText("Tổng doanh thu:");
        jPanel5.add(DoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 610, 30));

        jPanelChar.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jPanelChar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 670, 420));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_NamActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int month = Integer.parseInt(jComboBox_Thang.getSelectedItem().toString());
        int year = Integer.parseInt(jComboBox_Nam.getSelectedItem().toString());
        updateStatistics(month, year);
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DT_Xe4;
    private javax.swing.JLabel DT_Xe7;
    private javax.swing.JLabel DT_XeMay;
    private javax.swing.JLabel DoanhThu;
    private javax.swing.JLabel SoHoaDon;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> jComboBox_Nam;
    private javax.swing.JComboBox<String> jComboBox_Thang;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelChar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTop;
    // End of variables declaration//GEN-END:variables
}
