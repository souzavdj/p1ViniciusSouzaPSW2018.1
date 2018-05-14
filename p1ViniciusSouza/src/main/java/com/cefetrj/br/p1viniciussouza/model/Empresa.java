/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.model;

import java.util.ArrayList;

/**
 * Classe modelo para a Empresa.
 *
 * @author vinicius
 * @version 1.0
 */
public class Empresa {

    /**
     * Atributo nome é do tipo String e é responsável por armazenar o nome da
     * Empresa.
     */
    private String nome;

    /**
     * Atributo planoDeContas é uma lista de PlanoDeContas e é responsável por
     * armazenar os planos de contas da Empresa.
     */
    ArrayList<PlanoDeContas> planoDeContas;

    /**
     * Atributo orcamentos é uma lista de Orcamento e é responsável por
     * armazenar os orcamentos da Empresa.
     */
    ArrayList<Orcamento> orcamentos;
    
    /**
     * Método construtor com o nome da Empresa
     * @param nome variavel String com o nome da Empresa
     */
    public Empresa(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método que retorna o nome da Empresa.
     * @return o atributo {@link #nome}
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Método para atribuir valor ao atributo nome.
     * @param nome variável com String a ser inserida no atributo {@link #nome}
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método que retorna os planos de contas da Empresa.
     * @return o atributo {@link #planoDeContas}
     */
    public ArrayList<PlanoDeContas> getPlanoDeContas() {
        return planoDeContas;
    }
    
    /**
     * Método para atribuir valor ao atributo planoDeContas.
     * @param planoDeContas variável com a lista de planos de contas a ser inserida no atributo {@link #planoDeContas}
     */
    public void setPlanoDeContas(ArrayList<PlanoDeContas> planoDeContas) {
        this.planoDeContas = planoDeContas;
    }
    
    /**
     * Método que retorna os orcamentos da Empresa.
     * @return o atributo {@link #orcamentos}
     */
    public ArrayList<Orcamento> getOrcamentos() {
        return orcamentos;
    }
    
    /**
     * Método para atribuir valor ao atributo orcamentos.
     * @param orcamentos variável com a lista de orcamentos a ser inserida no atributo {@link #orcamentos}
     */
    public void setOrcamentos(ArrayList<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
        
}
