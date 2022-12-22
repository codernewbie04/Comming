/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duo_sio.comming.view;

import com.duo_sio.comming.utils.IOUserData;
import com.duo_sio.comming.view.content.Content_MyProjects;
import com.duo_sio.comming.view.content.Content_Mentoring;
import com.duo_sio.comming.view.content.Form_3;
import com.duo_sio.comming.view.content.Content_Dashboard;
import com.duo_sio.comming.view.content.Content_Profile;
import com.duo_sio.comming.view.content.Content_TopUp;
import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author Akmal M F
 */
public class MainPengguna extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private Form_3 form3;
    private int role;

    public MainPengguna(int role) {
        this.role = role;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        form3 = new Form_3();
        menu.initMoving(MainPengguna.this);
        menu.addEventMenuSelected((int index) -> {
            if(role == 1){
                switch (index) {
                    case 0 -> setForm(new Content_Dashboard());
                    case 1 -> setForm(new Content_MyProjects());
                    case 2 -> setForm(new Content_Mentoring());
                    case 3 -> setForm(new Content_Profile());
                    case 4 -> setForm(new Content_TopUp());
                    case 5 -> {
                        IOUserData.logout();
                        LoginView login = new LoginView();
                        login.setVisible(true);
                        this.setVisible(false);
                    }
                    default -> {
                    }
                }
            }
            
        });
        //  set when system open start with home form
        setForm(new Content_Dashboard());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.duo_sio.comming.view.swing.PanelBorder();
        menu = new com.duo_sio.comming.view.component.Menu(role);
        header2 = new com.duo_sio.comming.view.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duo_sio.comming.view.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private com.duo_sio.comming.view.component.Menu menu;
    private com.duo_sio.comming.view.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}