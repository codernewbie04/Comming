package com.duo_sio.comming.utils;

import com.duo_sio.comming.model.UserModel;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUO SIO
 */
public class IOUserData {
    UserModel user;
    public IOUserData(){
        try{
            FileInputStream fis = new FileInputStream("user.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            this.user = (UserModel) ois.readObject();
            fis.close();
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    public IOUserData(UserModel user){
        this.user = user;
        try (FileOutputStream fos = new FileOutputStream("user.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // write object to file
            oos.writeObject(this.user);

        } catch (IOException ex) { 
            System.out.println("Failed I/O");
        }
    }
    
    public UserModel getUser(){
        return this.user;
    }
    
    public static void logout() {
        try { 
            Path path = FileSystems.getDefault().getPath("./user.dat");
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(IOUserData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
