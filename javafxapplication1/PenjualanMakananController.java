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

public class PenjualanMakananController implements Initializable {

    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnTambah;
    
    @FXML
    private Button btnDelete;

    @FXML
    private TableColumn<Makanan, Integer> idProduk;

    @FXML
    private TableColumn<Makanan, String> namaProduk;

    @FXML
    private TableView<Makanan> tableMakanan;
    
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
    private TextField fieldId;
    
    @FXML
    private TextField fieldIdProduk;

    @FXML
    private TextField fieldJumlah;
    
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
    
    @FXML
    void sendData(ActionEvent event) throws IOException, SQLException {
        String name = searchName(Integer.parseInt(fieldIdProduk.getText()));
        Penjualan pjl = new Penjualan(name,Integer.parseInt(fieldJumlah.getText()),3000.00);
        PenjualanMakananModel pm = new PenjualanMakananModel();
        pm.addPenjualan(pjl);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanMakanan.fxml"));
        Parent root = loader.load();
        PenjualanMakananController penjualanMakananController = loader.getController();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    public String searchName(int id) throws SQLException{
        Connection CONN = DBHelper.getConnection();
        String query ="SELECT * FROM makanan WHERE id="+id;
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
    
    public ObservableList<Makanan> getMakananList(){
        ObservableList<Makanan> makananList = FXCollections.observableArrayList();
       Connection CONN = DBHelper.getConnection();
       String query ="SELECT * FROM makanan;";
       Statement st;
       ResultSet rs; 
       

       try{
           st = CONN.createStatement();
           rs = st.executeQuery(query);
           System.out.println(rs);
           Makanan makanan;
           while(rs.next()){
           makanan = new Makanan(rs.getInt("id"),rs.getInt("daya_tahan"),rs.getString("nama_produk"),rs.getDouble("harga"),rs.getInt("jumlah"),rs.getDouble("diskon")); 
               makananList.add(makanan);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return makananList;
    }
    public void showMakanan(){
        ObservableList<Makanan> list = getMakananList();
        idProduk.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("id"));
        namaProduk.setCellValueFactory(new PropertyValueFactory<Makanan,String>("nama_produk"));
        tableMakanan.setItems(list);
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
