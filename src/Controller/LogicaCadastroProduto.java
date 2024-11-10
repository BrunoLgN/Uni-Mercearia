/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;
/**
 *
 * @author 55459
 */
public class LogicaCadastroProduto {
           public boolean Inserir(Produto produto){
           int fornecedor = produto.getFornecedor();
           String nome = produto.getNome();
           float precoCompra = produto.getPrecoCompra();
           float precoVenda = produto.getPrecoVenda();
           String codigoDeBarra = produto.getCodigoDeBarra();
           int quantidade = produto.getQuantidade();

           
           boolean isValid = false;
           
           
           ConexaoBanco conexaoBanco = new ConexaoBanco();
            if (conexaoBanco.conectar()) {
                Connection connection = conexaoBanco.getConnection();
                String sql = "INSERT INTO TB_PRODUTO (pro_for_id, pro_name, pro_precoCompra, pro_precoVenda, pro_codigoBarra, pro_quantidade) VALUES (?,?, ?, ?, ?, ?)";

                 try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, fornecedor);
            statement.setString(2, nome);
            statement.setFloat(3, precoCompra);
            statement.setFloat(4, precoVenda);
                statement.setString(5, codigoDeBarra);
                statement.setInt(6, quantidade);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isValid = true; // Inserção bem-sucedida
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                connection.close(); // Fechando a conexão
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            }
                   
           
           
       }
return isValid;
           }
           
}