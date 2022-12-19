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
public class BarangModel {
     private final Connection CONN;

    public BarangModel() {
        this.CONN = DBHelper.getConnection();
    }
    public void addBarang(Barang brg){
        String insert ="INSERT INTO barang(barcode, expired,nama_produk,harga,jumlah,diskon,kategori) VALUES ('"+brg.getBarcode()+"', '"+ brg.getExpired() + "','"+brg.getNama_produk()+"'," + brg.getHarga()+"," + brg.getJumlah()+"," + brg.getDiskon()+"," + brg.getKtg()+")";
        System.out.println(insert);
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
    public void deleteBarang(String bcd){
        String insert ="DELETE FROM barang WHERE barcode='"+bcd+"'";
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
