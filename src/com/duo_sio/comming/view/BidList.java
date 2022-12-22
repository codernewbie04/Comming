/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.duo_sio.comming.view;

import com.duo_sio.comming.controller.ProfileController;
import com.duo_sio.comming.controller.ProjectsController;
import com.duo_sio.comming.model.BidListModel;
import com.duo_sio.comming.model.CashType;
import com.duo_sio.comming.model.ProjectModel;
import com.duo_sio.comming.utils.CommonUtils;
import com.duo_sio.comming.view.swing.ScrollBar;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author DUO SIO
 */
public class BidList extends javax.swing.JFrame {
    private List<BidListModel> bl = new ArrayList();
    private ProjectModel project;
    private ProjectsController projectsController = new ProjectsController();
    public BidList(ProjectModel project) {
        initComponents();
        this.project = project;
        this.setTitle("List Penawaran dari Freelancer");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txt_title.setText("BID List Project "+project.getNama());
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        setTableValue(project.getBidList());
    }
    
    private void setTableValue(List<BidListModel> bidList) {
        bidList.forEach(o ->{
            bl.add(o);
            String action = "Select To Confirm";
            if(project.getTaken_by() != null)
                action = "No Action";
            table.addRow(new Object[]{o.getUser().getFullname(), CommonUtils.getFormattedPrice(o.getOffer()), action});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.duo_sio.comming.view.swing.PanelBorder();
        txt_title = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.duo_sio.comming.view.swing.Table();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        txt_title.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txt_title.setForeground(new java.awt.Color(127, 127, 127));
        txt_title.setText("BID List Project Lorem Ipsum");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Freelancer", "Penarawan", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        spTable.setViewportView(table);

        jButton2.setBackground(new java.awt.Color(25, 118, 211));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/confirm.png"))); // NOI18N
        jButton2.setText("Konfirmasi Frelancer");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDefaultCapable(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(txt_title)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_title)
                .addGap(28, 28, 28)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        
    }//GEN-LAST:event_tableMousePressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Tidak ada freelancer yang dipilih!", "Failed!",JOptionPane.ERROR_MESSAGE);
        } else if(project.getTaken_by() != null){
            JOptionPane.showMessageDialog(this, "Project yang sudah dikonfirmasi tidak dapat dirubah!!", "Failed!",JOptionPane.ERROR_MESSAGE);
        } else {
            if(projectsController.setTakenBy(project.getId(),bl.get(table.getSelectedRow()).getId())) {
                new ProfileController().tambahSaldo(project.getBidList().get(table.getSelectedRow()).getUser().getId(), project.getBidList().get(table.getSelectedRow()).getOffer());
                JOptionPane.showMessageDialog(this, "Berhasil mengkonfirmasi freelancer", "Success",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan kedatabase", "Failed!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private com.duo_sio.comming.view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private com.duo_sio.comming.view.swing.Table table;
    private javax.swing.JLabel txt_title;
    // End of variables declaration//GEN-END:variables
}
