/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.model;

import java.util.ArrayList;

/**
 * Classe modelo para o Plano de contas.
 * @author vinicius
 * @version 1.0
 */
public class PlanoDeContas {
    
    /**
     * Atributo nome é do tipo String e é responsável por armazenar o nome do Plano de contas.
     */
    private String nome;
    
    /**
     * Atributo contas é uma lista de contas e é responsável por armazenar as contas do PlanoDeContas.
     */
    ArrayList<Conta> contas;
    
    /**
     * Método que retorna se o plano de contas é do tipo Orcamento ou não.
     * @return retorna verdadeiro se for um Orcamento e falso se nao for
     */
    public boolean isOrcamento() {
        if (this instanceof Orcamento) {
            return true;
        }
        return false;
    } 
}
