package Controller;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class LogicaCadastroCliente {
    public boolean Inserir(Cliente cliente) {
        String nome = cliente.getNome();
        String cpf = cliente.getCpf();
        String cep = cliente.getCep(); // Corrigido para pegar o cep correto
        String telefone = cliente.getTelefone();

        // Verifica se o nome é válido
        if (!isNomeValido(nome)) {
            JOptionPane.showMessageDialog(null, "O nome deve conter apenas letras.");
            return false; // Se o nome for inválido, retorna false
        }

        // Verifica se o CPF é válido
        if (!isCpfValido(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido.");
            return false; // Se o CPF for inválido, retorna false
        }

        // Verifica se o CEP é válido
        if (!isCepValido(cep)) {
            JOptionPane.showMessageDialog(null, "CEP inválido. Deve conter 8 dígitos.");
            return false; // Se o CEP for inválido, retorna false
        }

        boolean isValid = false;
        ConexaoBanco conexaoBanco = new ConexaoBanco();

        if (conexaoBanco.conectar()) {
            Connection connection = conexaoBanco.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (cli_nome, cli_cpf, cli_cep, cli_telefone) VALUES (?, ?, ?, ?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nome);
                statement.setString(2, cpf);
                statement.setString(3, cep);
                statement.setString(4, telefone);

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

    // Método para verificar se o nome é válido
    private boolean isNomeValido(String nome) {
        // Expressão regular que permite apenas letras (maiúsculas e minúsculas) e espaços
        return nome.matches("^[a-zA-ZÀ-ÿ\\s]+$");
    }

    // Método para verificar se o CPF é válido
    private boolean isCpfValido(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        // Validação dos dígitos verificadores
        int soma = 0;
        int peso = 10;

        // Primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            soma += (peso * (cpf.charAt(i) - '0'));
            peso--;
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) digito1 = 0;

        if (digito1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Resetar a soma e o peso para o segundo dígito verificador
        soma = 0;
        peso = 11;

        // Segundo dígito verificador
        for (int i = 0; i < 10; i++) {
            soma += (peso * (cpf.charAt(i) - '0'));
            peso--;
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) digito2 = 0;

        return digito2 == (cpf.charAt(10) - '0');
    }

    // Método para verificar se o CEP é válido
    private boolean isCepValido(String cep) {
        // Remove caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        // Verifica se o CEP possui 8 dígitos
        return cep.length() == 8;
    }
}
