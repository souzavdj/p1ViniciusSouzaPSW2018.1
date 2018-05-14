/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.model;

import java.util.ArrayList;

/**
 * Classe modelo para o Orcamento.
 * @author vinicius
 * @version 1.0
 */
public class Orcamento extends PlanoDeContas{
    
    /**
     * Atributo ano é do tipo int e é responsável por armazenar o ano do Orcamento.
     */
    private int ano;
    
    private ArrayList<ContaOrcamento> contas;
    
    /**
     * Método construtor com o ano do Orcamento
     * @param ano variavel int com o ano do orcamento
     */
    public Orcamento(int ano) {
        this.ano = ano;
    }
    
    /**
     * Método que retorna o ano do Orcamento.
     * @return o atributo {@link #ano}
     */
    public int getAno() {
        return ano;
    }
    
    /**
     * Método para atribuir valor ao atributo ano.
     * @param ano variável inteira a ser inserida no atributo {@link #ano}
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    /**
     * Método que retorna as contas do Orcamento.
     * @return o atributo {@link #contas}
     */
    public ArrayList<ContaOrcamento> getContas() {
        return contas;
    }
    
    /**
     * Método para atribuir valor ao atributo contas.
     * @param contas variável com a lista de contas a ser inserida no atributo {@link #contas}
     */
    public void setContas(ArrayList<ContaOrcamento> contas) {
        this.contas = contas;
    }
    
    
}
