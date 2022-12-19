/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;

import java.util.ArrayList;

/**
 *
 * @author faism
 */
public class Barang extends Produk {
    private String barcode;
    private String expired;
    private ArrayList<Kategori> kategori;
    private String ktg;

    public Barang(String barcode, String expired, String nama_produk, double harga, int jumlah, double diskon, String kategori) {
        super(nama_produk, harga, jumlah, diskon);
        this.barcode = barcode;
        this.expired = expired;
        this.ktg = kategori;
    }

    public String getKtg() {
        return ktg;
    }

    public void setKtg(String ktg) {
        this.ktg = ktg;
    }
    
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }
    
    public void isExpired(){
        
    }
    public void addKategori(){
        
    }
}
