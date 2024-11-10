package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class TelaConsulta extends JFrame {
    public TelaConsulta() {
        setTitle("Imagem em JFrame");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Usando BorderLayout
        setLayout(new BorderLayout());
        
        // Painel para o botão
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Cria o botão
        JButton botaoSelecao = new JButton("Escolha sua consulta");
        buttonPanel.add(botaoSelecao);
        
        // Adiciona o painel do botão ao topo
        add(buttonPanel, BorderLayout.NORTH);
        
        // Carrega a imagem
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\Bruno de Oliveira\\Downloads\\logo.jpeg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        
        // Cria um JLabel com a imagem redimensionada
        JLabel label = new JLabel(resizedIcon);
        
        // Centraliza a imagem no topo
        add(label, BorderLayout.CENTER);
        
        setVisible(true); // Tornando o JFrame visível
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TelaConsulta(); 
        });
    }
}
