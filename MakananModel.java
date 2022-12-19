/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faism
 */
public class MakananModel {
     private final Connection CONN;

    public MakananModel() {
        this.CONN = DBHelper.getConnection();
    }
    public void addMakanan(Makanan mkn){
        String insert ="INSERT INTO makanan(daya_tahan, nama_produk,harga,jumlah,diskon) VALUES("+mkn.getDaya_tahan()+", '"+ mkn.getNama_produk() + "',"+mkn.getHarga()+"," + mkn.getJumlah()+"," + mkn.getDiskon()+")";
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("berhasil memasukkan data"); 
            }else{
                System.out.println("Gagal memasukkan data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan data");
        }
    }
    public void deleteMakanan(int id){
        String insert ="DELETE FROM makanan WHERE id="+id;
        try {
            if(CONN.createStatement().executeUpdate(insert)>0){
                System.out.println("berhasil menghapus data"); 
            }else{
                System.out.println("Gagal menghapus data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MakananModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus data");
        }
    }
    
}
