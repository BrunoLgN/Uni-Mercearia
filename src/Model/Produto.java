/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bruno de Oliveira
 */
public class Produto {
    private int id;
    private String nome;
    private float precoCompra;
    private float precoVenda;
    private String codigoDeBarra;
    private int fornecedor;
    private int quantidade;

    public Produto() {
    }

    public Produto(int id, String nome, float precoCompra, float precoVenda, String codigoDeBarra, int fornecedor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.codigoDeBarra = codigoDeBarra;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    
    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public int getQuantidade(){
    return quantidade;
    }
    
    public void setQuantidade(int quantidade){
    this.quantidade = quantidade;
    }
    
}
