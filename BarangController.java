package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BarangController implements Initializable {

    @FXML
    private TableView<Barang> TBBarang;

    @FXML
    private TableColumn<Barang, String> barcode;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnTambah;

    @FXML
    private TableColumn<Barang, Double> diskon;

    @FXML
    private TableColumn<Barang, String> expired;

    @FXML
    private TextField fieldB;

    @FXML
    private TextField fieldBarcode;

    @FXML
    private TextField fieldDiskon;

    @FXML
    private TextField fieldExpired;

    @FXML
    private TextField fieldHarga;

    @FXML
    private TextField fieldJumlah;

    @FXML
    private TextField fieldNama;
    
    @FXML
    private TextField fieldKategori;

    @FXML
    private TableColumn<Barang, Double> harga;

    @FXML
    private TableColumn<Barang, Integer> jumlah;

    @FXML
    private TableColumn<Barang, String> nama_produk;

    @FXML
    private TableColumn<Barang, String> kategori;
    
    @FXML
    void deleteData(ActionEvent event) throws IOException {
        String bcd =fieldB.getText();
        BarangModel bm = new BarangModel();
        bm.deleteBarang(bcd);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        BarangController barangcontroller = loader.getController();
        Stage stage = (Stage) btnDelete.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void openMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void sendData(ActionEvent event) throws IOException {
                Barang brg = new Barang(fieldBarcode.getText(),fieldExpired.getText(),fieldNama.getText(),Double.parseDouble(fieldHarga.getText()),Integer.parseInt(fieldJumlah.getText()),Double.parseDouble(fieldDiskon.getText()),fieldKategori.getText());
        BarangModel bm = new BarangModel();
        bm.addBarang(brg);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Barang.fxml"));
        Parent root = loader.load();
        BarangController BarangController = loader.getController();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
        public ObservableList<Barang> getBarangList(){
        ObservableList<Barang> barangList = FXCollections.observableArrayList();
       Connection CONN = DBHelper.getConnection();
       String query ="SELECT * FROM barang;";
       Statement st;
       ResultSet rs; 
       

       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           System.out.println(rs);
           Barang barang;
           while(rs.next()){
           barang = new Barang(rs.getString("barcode"),rs.getString("expired"),rs.getString("nama_produk"),rs.getDouble ("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getString("kategori")); 
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
    }
    public void showBarang(){
        ObservableList<Barang> list = getBarangList();
        barcode.setCellValueFactory(new PropertyValueFactory<Barang,String>("barcode"));
        expired.setCellValueFactory(new PropertyValueFactory<Barang,String>("expired"));        
        nama_produk.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
        harga.setCellValueFactory(new PropertyValueFactory<Barang,Double>("harga"));
        jumlah.setCellValueFactory(new PropertyValueFactory<Barang,Integer>("jumlah"));
        diskon.setCellValueFactory(new PropertyValueFactory<Barang,Double>("diskon"));
        kategori.setCellValueFactory(new PropertyValueFactory<Barang,String>("ktg"));
        TBBarang.setItems(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        showBarang();
    }

}