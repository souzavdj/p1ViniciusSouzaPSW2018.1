/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.model;

import java.util.ArrayList;

/**
 * Classe modelo para as contas.
 * @author vinicius
 * @version 1.0
 */
public class Conta {
    
    /**
     * Atributo nome é do tipo String e é responsável por armazenar o nome da Conta.
     */
    private String nome;
    
    /**
     * Atributo codigo é do tipo int e é responsável por armazenar o codigo da Conta.
     */
    private int codigo;
    
    /**
     * Atributo subContas é uma lista de Contas e é responsável por armazenar as subContas da Conta.
     */
    ArrayList<Conta> subContas;
    
    /**
     * Método que retorna o nome da Conta.
     * @return o atributo {@link #nome}
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Método para atribuir valor ao atributo nome.
     * @param nome variável com o nome a ser inserida no atributo {@link #nome}
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método que retorna o codigo da Conta.
     * @return o atributo {@link #codigo}
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Método para atribuir valor ao atributo codigo.
     * @param codigo variável com o codigo a ser inserida no atributo {@link #codigo}
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Método que retorna uma lista de subConta.
     * @return o atributo {@link #subContas}
     */
    public ArrayList<Conta> getSubContas() {
        return subContas;
    }
    
    /**
     * Método para atribuir valor ao atributo subContas.
     * @param subContas variável com a lista de subContas a ser inserida no atributo {@link #subContas}
     */
    public void setSubContas(ArrayList<Conta> subContas) {
        this.subContas = subContas;
    }
    
    
}
