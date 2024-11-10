/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;
/**
 *
 * @author Bruno de Oliveira
 */
public class LogicaCadastroFornecedor {
    public boolean Inserir(Fornecedor fornecedor){
           String razaoSocial = fornecedor.getRazaoSocial();
           String telefone = fornecedor.getTelefone();
           String cnpj = fornecedor.getCnpj();
           String email = fornecedor.getEmail();
           boolean isValid = false;
           
            ConexaoBanco conexaoBanco = new ConexaoBanco();
            if (conexaoBanco.conectar()) {
                Connection connection = conexaoBanco.getConnection();
                String sql = "INSERT INTO TB_FORNECEDOR (for_cnpj, for_razaosocial, for_telefone, for_email) VALUES (?, ?, ?, ?)";
    
                 try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cnpj);
            statement.setString(2, razaoSocial);
            statement.setString(3, telefone);
            statement.setString(4, email);
            
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

