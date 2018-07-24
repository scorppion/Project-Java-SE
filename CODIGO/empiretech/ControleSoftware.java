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
import static empiretech.ControleIncluir.consulta;
import static empiretech.ControleIncluir.resultadoDaConsulta;
import static empiretech.ControleIncluir.senha;
import static empiretech.ControleIncluir.testeDaConexao;
import static empiretech.ControleIncluir.testeDoDriver;
import static empiretech.ControleIncluir.url;
import static empiretech.ControleIncluir.usuario;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author paguiar
 */
public class ControleSoftware implements Initializable {
   
    @FXML
    private TableColumn<?, ?> tbIDSoft;

    @FXML
    private TableColumn<?, ?> tbNomeSoft;

    @FXML
    private TableColumn<?, ?> tbTipoSoft;

    @FXML
    private TableView<?> tbSoftware;

    @FXML
    private TableColumn<?, ?> tbPrecoSoft;
    
    @FXML
    private AnchorPane AnchorSoftware;
    
    @FXML
    private Label lblSoftware;
    
    @FXML
    private Label lblDados;
    
    @FXML
    void AcaoTabela(ActionEvent event) throws SQLException {
        
        testeDoDriver();
        testeDaConexao();
        pesquisarSoftware();
        
        
               lblDados.setText("\tID\t|\tNome\t\t|\tTipo\t\t\t|\tPreco");
               lblSoftware.setText("\t" + ID_Prod + "\t|\t" + Nome + "\t\t|\t" + Tipo + "\t\t|\t" + Preco);
               
       
    }
    
    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
        AnchorPane anchorSoftware = FXMLLoader.load(getClass().getResource("Estoque.fxml"));
        AnchorSoftware.getChildren().setAll(anchorSoftware);
    }
   
    
       
    static void pesquisarSoftware() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            consulta = (Statement) conexao.createStatement();
            resultadoDaConsulta = consulta.executeQuery("SELECT * FROM Produtos WHERE Tipo = 'Software'");

            System.out.println("\n\tID\t\t|\tProdutos\t\t\t\t\t|\tPreco");
            System.out.println("\t------------------------------------------------");

            while (resultadoDaConsulta.next()) {
                ID_Prod = resultadoDaConsulta.getString("ID_Prod");
                Nome = resultadoDaConsulta.getString("Nome");
                Tipo = resultadoDaConsulta.getString("Tipo");
                Preco = resultadoDaConsulta.getString("Preco");


                System.out.println("\t" + ID_Prod +
                        "\t|\t" + Nome +
                        "\t\t|\t" + Tipo +
                         "\t\t|\t" + Preco);
              }
            
            System.out.println("");
                

            conexao.close();
            resultadoDaConsulta.close();

        } catch (SQLException e) {
            System.out.println("Falha na consulta ao banco!");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    
}
