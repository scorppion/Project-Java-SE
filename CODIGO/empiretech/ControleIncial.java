/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empiretech;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author paguiar
 */
public class ControleIncial implements Initializable {
    
    @FXML
    private AnchorPane AnchorInicial;
    
    @FXML
    void acaoEstoque(ActionEvent event) throws IOException {
        AnchorPane anchorInicial = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
        AnchorInicial.getChildren().setAll(anchorInicial);
    }
    
    @FXML
    void acaoControle(ActionEvent event) throws IOException {
        AnchorPane anchorInicial = FXMLLoader.load(getClass().getResource("Controle.fxml"));
        AnchorInicial.getChildren().setAll(anchorInicial);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
