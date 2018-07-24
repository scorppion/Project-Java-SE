/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empiretech;

import static empiretech.ControleIncluir.ID_Prod;
import static empiretech.ControleIncluir.conexao;
import static empiretech.ControleIncluir.senha;
import static empiretech.ControleIncluir.testeDaConexao;
import static empiretech.ControleIncluir.testeDoDriver;
import static empiretech.ControleIncluir.url;
import static empiretech.ControleIncluir.usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author paguiar
 */
public class ControleDeletar implements Initializable {
    
    @FXML
    private TextField txtID_Prod;
    
    @FXML
    private AnchorPane AnchorDeletar;
    
    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
        AnchorPane anchorDeletar = FXMLLoader.load(getClass().getResource("Controle.fxml"));
        AnchorDeletar.getChildren().setAll(anchorDeletar);
    }
    
    
    
    
    @FXML
    void acaoDeletar(ActionEvent event) {
             
        ID_Prod = txtID_Prod.getText();
        
       testeDoDriver();
       testeDaConexao();
       
       apagar(ID_Prod);
       
        txtID_Prod.clear();
        txtID_Prod.requestFocus();
    }
    
     static void apagar (String ID_Prod) {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement delecao = null;
            String comando = "DELETE FROM Produtos WHERE ID_Prod = ?";
            delecao = conexao.prepareStatement(comando);
            delecao.setString(1,ID_Prod);
            delecao.executeUpdate();

            //pesquisar();

            conexao.close();

        } catch (SQLException e) {
            System.out.println("Falha ao alterar dados na tabela!");
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
