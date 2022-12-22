package com.duo_sio.comming.controller;

import com.duo_sio.comming.model.UserModel;
import com.duo_sio.comming.utils.IOUserData;
import com.duo_sio.comming.view.LoginView;
import com.duo_sio.comming.view.MainPengguna;

/**
 *
 * @author DUO SIO
 */
public class Driver {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Driver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        UserModel u = new IOUserData().getUser();
        if(u != null){
            MainPengguna main = new MainPengguna(u.getRole());
            main.setVisible(true);
        } else {
            new LoginView().setVisible(true);
        }
        
    }
}
