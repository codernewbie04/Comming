/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duo_sio.comming.view;

import com.duo_sio.comming.controller.AuthController;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ME1
 */
public class RegisterView extends javax.swing.JFrame {
    private String roleStr = "Pengguna";
    private int role = 1;
    private AuthController authController = new AuthController();
    public RegisterView() {
        initComponents();
        initMoving(this);
        hideTarif();
        hideKategori();
        et_username.setBackground(new java.awt.Color(0,0,0,1));
        et_fullname.setBackground(new java.awt.Color(0,0,0,1));
        et_password.setBackground(new java.awt.Color(0,0,0,1));
        et_tarif.setBackground(new java.awt.Color(0,0,0,1));
        et_kategori.setBackground(new java.awt.Color(0,0,0,1));
    }
    
    private void hideTarif() {
        txt_tarif.setVisible(false);
        _tarif.setVisible(false);
        et_tarif.setVisible(false);
        ic_tarif.setVisible(false);
    }
    
    private void showTarif() {
        txt_tarif.setVisible(true);
        _tarif.setVisible(true);
        et_tarif.setVisible(true);
        ic_tarif.setVisible(true);
    }
    
    private void hideKategori() {
        txt_kategori.setVisible(false);
        _kategori.setVisible(false);
        et_kategori.setVisible(false);
        ic_kategori.setVisible(false);
    }
    
    private void showKategori() {
        txt_kategori.setVisible(true);
        _kategori.setVisible(true);
        et_kategori.setVisible(true);
        ic_kategori.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        et_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        et_password = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        et_fullname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_tarif = new javax.swing.JLabel();
        et_tarif = new javax.swing.JTextField();
        _tarif = new javax.swing.JLabel();
        ic_tarif = new javax.swing.JLabel();
        txt_kategori = new javax.swing.JLabel();
        et_kategori = new javax.swing.JTextField();
        _kategori = new javax.swing.JLabel();
        ic_kategori = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(25, 118, 211));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Created By Duo Siuuu");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 500, -1));

        ImageIcon img = new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/bg-register.png")); Image image = img.getImage(); Image newimg = image.getScaledInstance(412,358,  java.awt.Image.SCALE_SMOOTH);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(newimg));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(2000, 1000));
        jLabel1.setMinimumSize(new java.awt.Dimension(2000, 1000));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 500, 340));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/back.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 39));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 780));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 29));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Register");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 420, 41));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Masukan data form registrasi dengan sesuai");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 420, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 341, -1));

        et_username.setFont(et_username.getFont().deriveFont(et_username.getFont().getSize()+2f));
        et_username.setForeground(new java.awt.Color(255, 255, 255));
        et_username.setBorder(null);
        jPanel2.add(et_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 240, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 290, 39));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 40, 39));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(199, 226, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 341, -1));

        et_password.setFont(et_password.getFont().deriveFont(et_password.getFont().getSize()+2f));
        et_password.setForeground(new java.awt.Color(255, 255, 255));
        et_password.setBorder(null);
        et_password.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(et_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 240, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_________________________________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 290, 40));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 40, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 40, 40));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 211));
        jButton1.setText("DAFTAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 341, 40));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Masuk");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 670, 122, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(199, 226, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Sudah punya akun?");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 213, -1));

        jPanel3.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 40));
        jPanel3.getAccessibleContext().setAccessibleName("panelMoving");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(199, 226, 255));
        jLabel10.setText("Role");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 341, -1));

        et_fullname.setFont(et_fullname.getFont().deriveFont(et_fullname.getFont().getSize()+2f));
        et_fullname.setForeground(new java.awt.Color(255, 255, 255));
        et_fullname.setBorder(null);
        jPanel2.add(et_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 240, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("_________________________________________");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 290, 39));

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengguna", "Freelancer", "Mentor" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 210, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(199, 226, 255));
        jLabel16.setText("Nama Lengkap");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 341, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 40, 39));

        txt_tarif.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_tarif.setForeground(new java.awt.Color(199, 226, 255));
        txt_tarif.setText("Tarif");
        jPanel2.add(txt_tarif, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 341, -1));

        et_tarif.setFont(et_tarif.getFont().deriveFont(et_tarif.getFont().getSize()+2f));
        et_tarif.setForeground(new java.awt.Color(255, 255, 255));
        et_tarif.setBorder(null);
        et_tarif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                et_tarifKeyPressed(evt);
            }
        });
        jPanel2.add(et_tarif, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 240, 30));

        _tarif.setForeground(new java.awt.Color(255, 255, 255));
        _tarif.setText("_________________________________________");
        jPanel2.add(_tarif, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 290, 39));

        ic_tarif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_tarif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/money.png"))); // NOI18N
        jPanel2.add(ic_tarif, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 40, 39));

        txt_kategori.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_kategori.setForeground(new java.awt.Color(199, 226, 255));
        txt_kategori.setText("kategori (Pisahkan dengan koma)");
        jPanel2.add(txt_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 341, -1));

        et_kategori.setFont(et_kategori.getFont().deriveFont(et_kategori.getFont().getSize()+2f));
        et_kategori.setForeground(new java.awt.Color(255, 255, 255));
        et_kategori.setBorder(null);
        et_kategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                et_kategoriKeyPressed(evt);
            }
        });
        jPanel2.add(et_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 240, 30));

        _kategori.setForeground(new java.awt.Color(255, 255, 255));
        _kategori.setText("_________________________________________");
        jPanel2.add(_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 290, 39));

        ic_kategori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_kategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duo_sio/comming/icon/kategori.png"))); // NOI18N
        jPanel2.add(ic_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 40, 39));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 780));

        setSize(new java.awt.Dimension(916, 778));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        et_password.setEchoChar((char)0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        et_password.setEchoChar((char)8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(et_fullname.getText().equals("") || et_username.getText().equals("") || et_password.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Form tidak boleh kosng!", "Invalid Form",JOptionPane.ERROR_MESSAGE);
        } else if(roleStr.equals("Mentor") && (et_tarif.getText().equals("") || et_kategori.getText().equals(""))){
            JOptionPane.showMessageDialog(this, "Form tidak boleh kosng!", "Invalid Form",JOptionPane.ERROR_MESSAGE);
        } else{
            if(authController.isUsernameExist(et_username.getText())){
                JOptionPane.showMessageDialog(this, "Username sudah tersedia!", "Username already exists",JOptionPane.ERROR_MESSAGE);
            } else {
                boolean stat = false;
                if(!roleStr.equals("Mentor")){
                    stat = authController.addPenggunaOrFreelancer(et_fullname.getText(), et_username.getText(), et_password.getText(), role);
                } else {
                     stat = authController.createMentor(et_fullname.getText(), et_username.getText(), et_password.getText(), role, Integer.parseInt(et_tarif.getText()), et_kategori.getText());
                }
                
                if(stat) {
                        JOptionPane.showMessageDialog(this, "Berhasil mendaftar!", "Success!",JOptionPane.INFORMATION_MESSAGE);
                        LoginView l = new LoginView();
                        l.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menyimpan kedalam database", "Unknown error!",JOptionPane.ERROR_MESSAGE);
                    }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        LoginView l = new LoginView();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        roleStr = (String) evt.getItem();
        if(null == roleStr){
            role = 1;
            hideTarif();
            hideKategori();
            roleStr = "Pengguna";
        } else switch (roleStr) {
            case "Pengguna" -> {
                role = 1;
                hideTarif();
                hideKategori();
            }
            case "Freelancer" -> {
                role = 3;
                hideTarif();
                hideKategori();
            }
            case "Mentor" -> {
                role = 2;
                showTarif();
                showKategori();
            }
            default -> {
                role = 1;
                hideTarif();
                hideKategori();
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void et_tarifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_tarifKeyPressed
        String value = et_tarif.getText();
        int l = value.length();
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyChar() == '\b') {
           et_tarif.setEditable(true);
        } else {
            et_tarif.setEditable(false);
        }
    }//GEN-LAST:event_et_tarifKeyPressed

    private void et_kategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_kategoriKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_kategoriKeyPressed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:gologin
        LoginView l = new LoginView();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked
    private int x;
    private int y;
    private void initMoving(JFrame fram) {
        jPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        jPanel3.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen()-((fram.getWidth()/2) +150), me.getYOnScreen());
            }
        });
    }

    private javax.swing.ImageIcon imageIcon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _kategori;
    private javax.swing.JLabel _tarif;
    private javax.swing.JLabel disable;
    private javax.swing.JTextField et_fullname;
    private javax.swing.JTextField et_kategori;
    private javax.swing.JPasswordField et_password;
    private javax.swing.JTextField et_tarif;
    private javax.swing.JTextField et_username;
    private javax.swing.JLabel ic_kategori;
    private javax.swing.JLabel ic_tarif;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel show;
    private javax.swing.JLabel txt_kategori;
    private javax.swing.JLabel txt_tarif;
    // End of variables declaration//GEN-END:variables

    
}
