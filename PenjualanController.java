package javafxapplication1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PenjualanController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBarang;

    @FXML
    private Button btnMakanan;
    
    @FXML
    void seePenjualanBarang(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanBarang.fxml"));
        Parent root = loader.load();
        PenjualanBarangController penjualanBarangcontroller = loader.getController();
        Stage stage = (Stage) btnBarang.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void seePenjualanMakanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PenjualanMakanan.fxml"));
        Parent root = loader.load();
        PenjualanMakananController penjualanMakananController = loader.getController();
        Stage stage = (Stage) btnMakanan.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML    
        void openMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
