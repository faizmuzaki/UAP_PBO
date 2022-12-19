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
public class PenjualanMakananModel {

     private final Connection CONN;

    public PenjualanMakananModel() {
        this.CONN = DBHelper.getConnection();
    }
    public void addPenjualan(Penjualan pjl){
        String insert ="INSERT INTO penjualan(nama_produk, jumlah,total) VALUES('"+pjl.getNama_produk() +"', '"+ pjl.getJumlahProduk() + "',"+pjl.getTotal()+")";
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
    
    public void deletePenjualan(int id){
        String insert ="DELETE FROM penjualan WHERE id_penjualan="+id;
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

