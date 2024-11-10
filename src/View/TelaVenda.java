/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ConexaoBanco;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;

public class TelaVenda extends javax.swing.JFrame {
private DefaultTableModel tableModel;
 

   public TelaVenda() {
     initComponents();
        loadProducts();
        setCurrentDate();
        setupTableModel();
    

    FinVenda.addActionListener(evt -> finalizarVenda());
    ADDProduto.addActionListener(evt -> adicionarProduto());
    RemovProduto.addActionListener(evt -> {
        System.out.println("Botão Remover clicado.");
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    });
    
    CanVenda.addActionListener(evt -> {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        Total.setText(""); 
    });
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ADDProduto = new javax.swing.JButton();
        RemovProduto = new javax.swing.JButton();
        CanVenda = new javax.swing.JButton();
        FinVenda = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(30, 30, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Venda");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Data:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Produto:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Quantidade:");

        jTextField1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Valor", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        ADDProduto.setText("Adicionar");
        ADDProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDProdutoActionPerformed(evt);
            }
        });

        RemovProduto.setText("Remover");
        RemovProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovProdutoActionPerformed(evt);
            }
        });

        CanVenda.setText("Cancelar ");
        CanVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanVendaActionPerformed(evt);
            }
        });

        FinVenda.setText("Finalizar");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("TOTAL:   R$");

        Total.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Total.setEnabled(false);
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        jButton1.setText("VOLTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(241, 241, 241)
                                        .addComponent(jLabel1)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ADDProduto)
                .addGap(28, 28, 28)
                .addComponent(RemovProduto)
                .addGap(27, 27, 27)
                .addComponent(CanVenda)
                .addGap(26, 26, 26)
                .addComponent(FinVenda)
                .addGap(97, 97, 97)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADDProduto)
                    .addComponent(RemovProduto)
                    .addComponent(CanVenda)
                    .addComponent(FinVenda)
                    .addComponent(jLabel5)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaInicial TelaInicial = new TelaInicial();
        TelaInicial.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

    private void CanVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanVendaActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Total.setText("0.00");

    }//GEN-LAST:event_CanVendaActionPerformed

    private void RemovProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovProdutoActionPerformed
        System.out.println("Botão Remover clicado.");
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);

            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_RemovProdutoActionPerformed

    private void ADDProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDProdutoActionPerformed
        ADDProduto.setText("Adicionar");
        for (ActionListener al : ADDProduto.getActionListeners()) {
            ADDProduto.removeActionListener(al);
        }
        ADDProduto.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarProduto();

            }
        });
        RemovProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovProdutoActionPerformed(evt);
            }
        });
    }//GEN-LAST:event_ADDProdutoActionPerformed

   private void finalizarVenda() {
    
    String totalVendaStr = Total.getText().isEmpty() ? "0.00" : Total.getText().replace(",", ".");
    double totalVenda;

    try {
        totalVenda = Double.parseDouble(totalVendaStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Total invalido.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String dataVenda = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    int totalItems = tableModel.getRowCount(); // Total de itens vendidos

    ConexaoBanco conexaoBanco = new ConexaoBanco();
    if (conexaoBanco.conectar()) {
        Connection connection = conexaoBanco.getConnection();
        String query = "INSERT INTO TB_VENDA (ven_data, ven_precoTotal, ven_items) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, dataVenda);
            pstmt.setDouble(2, totalVenda);
            pstmt.setInt(3, totalItems);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Venda finalizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            cancelarVenda(); 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao finalizar a venda.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

private void removerProduto() {
    
    System.out.println("Botao Remover clicado.");
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        
        tableModel.removeRow(selectedRow);
        calcularTotal();
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um produto para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}

private void cancelarVenda() {
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    Total.setText("");
}

private void calcularTotal() {
    double total = 0.0;
    
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        Object valor = tableModel.getValueAt(i, 3); 
        if (valor != null) {
            total += (double) valor;
        }
    }
    
    Total.setText(String.format("%.2f", total));
}

private void setupTableModel() {
   
    tableModel = (DefaultTableModel) jTable1.getModel();
}

private void setCurrentDate() {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String currentDate = sdf.format(new Date());
    jTextField1.setText(currentDate);
}

private void loadProducts() {
    
    ConexaoBanco conexaoBanco = new ConexaoBanco();
    if (conexaoBanco.conectar()) {
        Connection connection = conexaoBanco.getConnection();
        String query = "SELECT pro_id, pro_name, pro_precoVenda FROM TB_PRODUTO";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                
                String produto = rs.getString("pro_name");
                jComboBox1.addItem(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

private void adicionarProduto() {
   
    String selectedProduct = (String) jComboBox1.getSelectedItem();
    String quantidadeStr = jTextField2.getText();

    if (selectedProduct != null && !quantidadeStr.trim().isEmpty()) {
        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            double preco = getProductPrice(selectedProduct);
            double total = preco * quantidade;

         
            tableModel.insertRow(0, new Object[]{selectedProduct, preco, quantidade, total});

           
            jTextField2.setText("");

            
            calcularTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Insira uma quantidade valida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um produto e insira uma quantidade.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}

private double getProductPrice(String productName) {
    double price = 0.0;
    ConexaoBanco conexaoBanco = new ConexaoBanco();
    if (conexaoBanco.conectar()) {
        Connection connection = conexaoBanco.getConnection();
        String query = "SELECT pro_precoVenda FROM TB_PRODUTO WHERE pro_name = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, productName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                price = rs.getDouble("pro_precoVenda");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar preco do produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    return price;
}

public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> new TelaVenda().setVisible(true));
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDProduto;
    private javax.swing.JButton CanVenda;
    private javax.swing.JButton FinVenda;
    private javax.swing.JButton RemovProduto;
    private javax.swing.JTextField Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
