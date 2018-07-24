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
public class ControleControle implements Initializable {
    
    @FXML
    private AnchorPane AnchorControle;
    
    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
        AnchorPane anchorControle = FXMLLoader.load(getClass().getResource("Inicial.fxml"));
        AnchorControle.getChildren().setAll(anchorControle);
    }
    
    @FXML
    void acaoIncluir(ActionEvent event) throws IOException {
        AnchorPane anchorControle = FXMLLoader.load(getClass().getResource("Incluir.fxml"));
        AnchorControle.getChildren().setAll(anchorControle);
    }
    
    @FXML
    void acaoAlterar(ActionEvent event) throws IOException {
        AnchorPane anchorControle = FXMLLoader.load(getClass().getResource("Alterar.fxml"));
        AnchorControle.getChildren().setAll(anchorControle);
    }
    
    @FXML
    void acaoConsultar(ActionEvent event) throws IOException {
        AnchorPane anchorControle = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
        AnchorControle.getChildren().setAll(anchorControle);
    }
    
    @FXML
    void acaoDeletar(ActionEvent event) throws IOException {
        AnchorPane anchorControle = FXMLLoader.load(getClass().getResource("Deletar.fxml"));
        AnchorControle.getChildren().setAll(anchorControle);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
