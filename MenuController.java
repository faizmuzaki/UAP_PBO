package javafxapplication1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button btnProduct;

    @FXML
    void seeProduct(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Produk.fxml"));
        Parent root = loader.load();
        ProdukController produkController = loader.getController();
        Stage stage = (Stage) btnProduct.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
