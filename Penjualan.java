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
public class Penjualan implements ProductCounter{
    private ArrayList<Produk> listProduk;
    private int id_penjualan;
    private String nama_produk;
    private int jumlahProduk;
    private Double total;
    private int stok;

    public Penjualan(String nama_produk, int jumlahProduk, Double total) {
        this.nama_produk = nama_produk;
        this.jumlahProduk = jumlahProduk;
        this.total = total;
    }

    public Penjualan(int id,String nama_produk, int jumlahProduk, Double total) {
        this.id_penjualan = id;
        this.nama_produk = nama_produk;
        this.jumlahProduk = jumlahProduk;
        this.total = total;
    }
    
    
    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

   
    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public void getProduk(){
        
    }

    @Override
    public void hitungJumlahProduk() {

    }

    @Override
    public void hitungHargaProduk() {

    }
}
