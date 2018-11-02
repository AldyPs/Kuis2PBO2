/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jarkom
 */
public class Dokumen {

    private String isi;

    public Dokumen() {
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void simpanKeFile(File file) {
        FileOutputStream fos = null;
        try {
             fos = new FileOutputStream(file);
            fos.write(isi.getBytes());
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void bacaDariFile(File file) {
        FileInputStream fis = null;
        String hasil = " ";
        int data;
        try {
            fis = new FileInputStream(file);
            while ((data = fis.read()) != -1) {
                hasil = hasil + (char) data;
            }
            setIsi(hasil);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dokumen.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    public int hitungJumlahKata() {
        return isi.split(" ").length;
    }
}
