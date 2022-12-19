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

public class MakananController implements Initializable{

    @FXML
    private Button btnBack;

    @FXML
    private Button btnTambah;
    
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Makanan> TBMakanan;
    
    @FXML
    private TextField fieldD;

    @FXML
    private TextField fieldDT;

    @FXML
    private TextField fieldH;

    @FXML
    private TextField fieldJ;

    @FXML
    private TextField fieldNp;
    
    @FXML
    private TextField fieldId;
    
    @FXML
    private TableColumn<Makanan, Integer> id_makanan;

    @FXML
    private TableColumn<Makanan, String> nama_makanan;
    
    
    @FXML
    private TableColumn<Makanan, Integer> daya_tahan;

    @FXML
    private TableColumn<Makanan, Double> diskon;
    
        @FXML
    private TableColumn<Makanan, Double> harga;

    @FXML
    private TableColumn<Makanan, Integer> jumlah;
    
    @FXML
    void deleteData(ActionEvent event) throws IOException {
        int id=Integer.parseInt(fieldId.getText());
        MakananModel mm = new MakananModel();
        mm.deleteMakanan(id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        MakananController makananController = loader.getController();
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
        Makanan mkn = new Makanan(fieldNp.getText(),Double.parseDouble(fieldH.getText()),Integer.parseInt(fieldJ.getText()),Double.parseDouble(fieldD.getText()),Integer.parseInt(fieldDT.getText()));
        MakananModel mm = new MakananModel();
        mm.addMakanan(mkn);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Makanan.fxml"));
        Parent root = loader.load();
        MakananController makananController = loader.getController();
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
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
        id_makanan.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("id"));
        daya_tahan.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("daya_tahan"));        
        nama_makanan.setCellValueFactory(new PropertyValueFactory<Makanan,String>("nama_produk"));
        harga.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("harga"));
        jumlah.setCellValueFactory(new PropertyValueFactory<Makanan,Integer>("jumlah"));
        diskon.setCellValueFactory(new PropertyValueFactory<Makanan,Double>("diskon"));
        TBMakanan.setItems(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        showMakanan();
    }
}

