/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empiretech;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ControleIncluir implements Initializable {
    
    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPreco;

    @FXML
    private AnchorPane AnchorIncluir;

    @FXML
    private TextField txtID_Prod;
    
       
    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
        AnchorPane anchorIncluir = FXMLLoader.load(getClass().getResource("Controle.fxml"));
        AnchorIncluir.getChildren().setAll(anchorIncluir);
    }
    static Connection conexao = null;
    static Statement consulta;
    static ResultSet resultadoDaConsulta;
    static String nomeDaTabela = "Produtos";
    static String servidor = "92df49ae-0545-4861-add6-a77f01102e6b.mysql.sequelizer.com";
    static String banco = "db92df49ae05454861add6a77f01102e6b";
    static String usuario = "oeyhpkkocitjfkav";
    static String senha = "tt3TsY7a7qiWVEUaR3vWcUt3hBEfX58Jk7bkx6BSn8tupKUGGTMtcnVFa8LXsZkb";
    static String url = "jdbc:mysql://" + servidor + "/" + banco;
    static String Nome, Tipo;
    static String ID_Prod, Preco;
    
   static void testeDoDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver instalado corretamente.");
        } catch (Exception e) {
            System.out.println("Falha no teste do driver!");
            e.printStackTrace();
        }
    }

    static void testeDaConexao() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao com o banco realizada com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha durante o teste de conexão!");
            e.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("Conexão com o banco encerrada com sucesso.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Falha no encerramento da conexão com o banco!");
                }
            }
        }
    }
    
     @FXML
    void acaoCadastrar(ActionEvent event) {
       
     
       ID_Prod = txtID_Prod.getText();
       Nome = txtNome.getText();
       Tipo = txtTipo.getText();
       Preco = txtPreco.getText();
             
        testeDoDriver();
        testeDaConexao();
        inserir(ID_Prod , Nome , Tipo , Preco);
        
        txtID_Prod.clear();
        txtNome.clear();
        txtTipo.clear();
        txtPreco.clear();
        txtID_Prod.requestFocus();
    }
    
    
    
    
    static void inserir(String ID_Prod, String Nome, String Tipo, String Preco) {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            consulta = (Statement) conexao.createStatement();
            consulta.executeUpdate("INSERT INTO " + nomeDaTabela +
                    "(ID_Prod, Nome, Tipo, Preco)" + " VALUES " +"('" +
                     ID_Prod + "','" +
                    Nome + "','" +
                    Tipo  + "','" +
                    Preco + "')");

            conexao.close();

        } catch (SQLException e) {
            System.out.println("Falha ao inserir dados na tabela!");
        }
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
