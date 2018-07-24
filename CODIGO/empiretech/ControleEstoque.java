/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empiretech;
import static empiretech.ControleSoftware.pesquisarSoftware;
import static empiretech.ControleHardware.pesquisarHardware;
import static empiretech.ControleIncluir.testeDaConexao;
import static empiretech.ControleIncluir.testeDoDriver;
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
public class ControleEstoque implements Initializable {
    
    @FXML
    private AnchorPane AnchorEstoque;
    
    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
        AnchorPane anchorEstoque = FXMLLoader.load(getClass().getResource("Inicial.fxml"));
        AnchorEstoque.getChildren().setAll(anchorEstoque);
    }
    
    @FXML
    void acaoSoftware(ActionEvent event) throws IOException {
        AnchorPane anchorEstoque = FXMLLoader.load(getClass().getResource("Software.fxml"));
        AnchorEstoque.getChildren().setAll(anchorEstoque);
        
    }
    
    @FXML
    void acaoHardware(ActionEvent event) throws IOException {
        AnchorPane anchorEstoque = FXMLLoader.load(getClass().getResource("Hardware.fxml"));
        AnchorEstoque.getChildren().setAll(anchorEstoque);
        
    
    }
    
    @FXML
    void acaoServicos(ActionEvent event) throws IOException {
        AnchorPane anchorEstoque = FXMLLoader.load(getClass().getResource("Servicos.fxml"));
        AnchorEstoque.getChildren().setAll(anchorEstoque);
    }
    
     @FXML
    void acaoInfo(ActionEvent event) throws IOException {
        AnchorPane anchorEstoque = FXMLLoader.load(getClass().getResource("Info.fxml"));
        AnchorEstoque.getChildren().setAll(anchorEstoque);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
