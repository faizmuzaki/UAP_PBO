package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class PenjualanBarangController implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnTambah;
    
     @FXML
    private Button btnDelete;

    @FXML
    private TextField fieldIdProduk;

    @FXML
    private TextField fieldJumlah;
    @FXML
    private TextField fieldId;
    @FXML
    private TableColumn<Barang, String> idProduk;

    @FXML
    private TableColumn<Barang, String> namaProduk;

    @FXML
    private TableColumn<Penjualan, Integer> idp;
    
    @FXML
    private TableColumn<Penjualan, Integer> jumlahP;
    
    @FXML
    private TableView<Penjualan> tablep;

    @FXML
    private TableColumn<Penjualan, Double> totalp;
    
    @FXML
    private TableColumn<Penjualan, String> namap;

    @FXML
    private TableView<Barang> tableBarang;


    @FXML
    void openMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    @FXML
    void deleteData(ActionEvent event) throws IOException {
        int id=Integer.parseInt(fieldId.getText());
        PenjualanBarangModel pm = new PenjualanBarangModel();
        pm.deletePenjualan(id);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanBarang.fxml"));
        Parent root = loader.load();
        PenjualanBarangController penjualanbarangController = loader.getController();
        Stage stage = (Stage) btnDelete.getScene().getWindow();
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
           barang = new Barang(rs.getString("barcode"),rs.getString("expired"),rs.getString("nama_produk"),rs.getDouble ("harga"),rs.getInt("jumlah"),rs.getDouble("diskon"),rs.getString("ktg"));
               barangList.add(barang);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return barangList;
    }
    public void showMakanan(){
        ObservableList<Barang> list = getBarangList();
        idProduk.setCellValueFactory(new PropertyValueFactory<Barang,String>("barcode"));
        namaProduk.setCellValueFactory(new PropertyValueFactory<Barang,String>("nama_produk"));
        tableBarang.setItems(list);
    }
    
    
    
    @FXML
    void sendData(ActionEvent event) throws SQLException, IOException {
        String name = searchName(fieldIdProduk.getText());
        Double h = getHarga(fieldIdProduk.getText()) * Integer.parseInt(fieldJumlah.getText());
        Penjualan pjl = new Penjualan(name,Integer.parseInt(fieldJumlah.getText()),h);
        PenjualanBarangModel bm = new PenjualanBarangModel();
        bm.addPenjualan(pjl);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanBarang.fxml"));
        Parent root = loader.load();
        PenjualanBarangController penjualanbarangController = loader.getController();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
        public String searchName(String barcode) throws SQLException{
        Connection CONN = DBHelper.getConnection();
        String query ="SELECT * FROM barang WHERE barcode='"+barcode+"'";
        System.out.println(query);
        Statement st;
        ResultSet rs;
        String name = null;
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           System.out.println(rs);
           while(rs.next()){
               name=rs.getString("nama_produk");
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       return name;
     }
    public Double getHarga(String barcode) throws SQLException{
        Connection CONN = DBHelper.getConnection();
        String query ="SELECT * FROM barang WHERE barcode='"+barcode+"'";
        System.out.println(query);
        Statement st;
        ResultSet rs;
        Double harga = null;
        Double diskon = null;
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           System.out.println(rs);
           while(rs.next()){
               harga=rs.getDouble("harga");
               diskon=rs.getDouble("diskon");
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       return harga-diskon;
     }
    
        
         public ObservableList<Penjualan> getPenjualanList(){
        ObservableList<Penjualan> penjualanList = FXCollections.observableArrayList();
       Connection CONN = DBHelper.getConnection();
       String query ="SELECT * FROM penjualan;";
       Statement st;
       ResultSet rs; 
       
       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           System.out.println(rs);
           Penjualan penjualan;
           while(rs.next()){
           penjualan = new Penjualan(rs.getInt("id_penjualan"),rs.getString("nama_produk"),rs.getInt("jumlah"),rs.getDouble("total")); 
               penjualanList.add(penjualan);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return penjualanList;
    }
     
    public void showPenjualan(){
        ObservableList<Penjualan> list = getPenjualanList();
        idp.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("id_penjualan"));
        namap.setCellValueFactory(new PropertyValueFactory<Penjualan,String>("nama_produk"));
        jumlahP.setCellValueFactory(new PropertyValueFactory<Penjualan,Integer>("jumlahProduk"));
        totalp.setCellValueFactory(new PropertyValueFactory<Penjualan,Double>("total"));
        tablep.setItems(list);
    }
        @Override
    public void initialize(URL url, ResourceBundle rb){
        showPenjualan();
        showMakanan();
    }

}
