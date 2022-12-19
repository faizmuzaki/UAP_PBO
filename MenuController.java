package javafxapplication1;

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnFood;

    @FXML
    private Button btnKategori;

    @FXML
    private Button btnProduct;
    
    @FXML
    private Button btnPenjualan;
    
    @FXML
    void seeBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        BarangController barangController = loader.getController();
        Stage stage = (Stage) btnBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    @FXML
    void seePenjualan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Penjualan.fxml"));
        Parent root = loader.load();
        PenjualanController penjualanController = loader.getController();
        Stage stage = (Stage) btnPenjualan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    @FXML
    void seeFood(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        MakananController makananController = loader.getController();
        Stage stage = (Stage) btnFood.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void seeKategori(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Kategori.fxml"));
        Parent root = loader.load();
        KategoriController kategoriController = loader.getController();
        Stage stage = (Stage) btnKategori.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void seeProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = loader.load();
        ProdukController produkController = loader.getController();
        Stage stage = (Stage) btnProduct.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
       @FXML
    private void initialize() {
//    	id_penjualan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getID()));
//    	jumlah_produk.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getID()));
//    	stok.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getID()));
    }

}
