package com.duo_sio.comming.view.component;

import com.duo_sio.comming.controller.EventMenuSelected;
import com.duo_sio.comming.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu(int role) {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init(role);
    }

    private void init(int role) {
        switch(role){
            case 1 -> {
                listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("project", "My Projects", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("mentor", "Mentoring", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("8", "Profile", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("money", "Topup Saldo", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("logout", "Logout", Model_Menu.MenuType.MENU));
            }
            case 2->{
                listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("mentor", "Mentoring", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("8", "Profile", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("money", "Withdraw", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("logout", "Logout", Model_Menu.MenuType.MENU));
            }
            case 3->{
                listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("project", "List Project", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("project", "My BID", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("8", "Profile", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("money", "Withdraw", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("logout", "Logout", Model_Menu.MenuType.MENU));
            }
            case 4->{
                listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("users", "List Users", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("promo", "Promo", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("8", "Profile", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("logout", "Logout", Model_Menu.MenuType.MENU));
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.duo_sio.comming.view.swing.ListMenu<>();

        panelMoving.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        ImageIcon img = new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/logo.png")); Image image = img.getImage(); Image newimg = image.getScaledInstance(175,175,  java.awt.Image.SCALE_SMOOTH);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(newimg));

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        listMenu1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1976D3"), 0, getHeight(), Color.decode("#8AFCFF"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.duo_sio.comming.view.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
