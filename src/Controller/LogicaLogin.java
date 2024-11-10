package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

public class LogicaLogin {
    public boolean authenticateUser(JTextField nomeField, JTextField senhaField) {
        String username = nomeField.getText();
        String password = senhaField.getText();
        boolean isValid = false;

        // Instanciar a classe de conexão
        ConexaoBanco conexaoBanco = new ConexaoBanco();

        // Conectar ao banco de dados
        if (conexaoBanco.conectar()) {
            Connection connection = conexaoBanco.getConnection();
            String sql = "SELECT * FROM TB_USUARIO WHERE USU_NOME = ? AND USU_SENHA = ?";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                
                ResultSet resultSet = statement.executeQuery();
                isValid = resultSet.next(); 
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }

        return isValid;
    }
}
