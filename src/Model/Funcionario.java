/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bruno de Oliveira
 */
public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String ctps;
    private String cep;
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String cpf, String ctps, String cep, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ctps = ctps;
        this.cep = cep;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCep() {
        return cep;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
