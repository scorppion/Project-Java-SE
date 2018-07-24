/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empiretech;

import static empiretech.ControleIncluir.ID_Prod;
import static empiretech.ControleIncluir.Nome;
import static empiretech.ControleIncluir.Preco;
import static empiretech.ControleIncluir.Tipo;
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
public class ControleAlterar implements Initializable {
    
    @FXML
    private TextField txtTipo;

    @FXML
    private AnchorPane AnchorAlterar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtID_Prod;

    
    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
        AnchorPane anchorAlterar = FXMLLoader.load(getClass().getResource("Controle.fxml"));
        AnchorAlterar.getChildren().setAll(anchorAlterar);
    }
    
      @FXML
    void acaoAlterar(ActionEvent event) {
       
     
       ID_Prod = txtID_Prod.getText();
       Nome = txtNome.getText();
       Tipo = txtTipo.getText();
       Preco = txtPreco.getText();
      
       
        testeDoDriver();
        testeDaConexao();
        atualizar(ID_Prod , Nome , Tipo , Preco);
        
        txtID_Prod.clear();
        txtNome.clear();
        txtTipo.clear();
        txtPreco.clear();
        txtID_Prod.requestFocus();
        
    }
    
    
    static void atualizar (String ID_Prod, String Nome, String Tipo, String Preco) {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement atualizacao = null;
            String comando = "UPDATE Produtos SET Nome = ? WHERE ID_Prod = ?";
            atualizacao = conexao.prepareStatement(comando);
            atualizacao.setString(1,Nome);
            atualizacao.setString(2,ID_Prod);
            atualizacao.executeUpdate();

           

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
