/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.model;

import java.util.ArrayList;

/**
 * Classe modelo para as contas dos Orcamentos.
 * @author vinicius
 * @version 1.0
 */
public class ContaOrcamento extends Conta{
    /**
     * Atributo valorOrcado é do tipo float e é responsável por armazenar o valor orçado da ContaOrcamento.
     */
    private float valorOrcado;
    /**
     * Atributo valorRealizado é do tipo float e é responsável por armazenar o valor realizado da ContaOrcamento.
     */
    private float valorRealizado;
    
    /**
     * Atributo valorComprometido é do tipo float e é responsável por armazenar o valor comprometido da ContaOrcamento.
     */
    private float valorComprometido;
    
    /**
     * Atributo subContas é uma lista de ContaOrcamento e é responsável por armazenar as subcontas da ContaOrcamento.
     */
    private ArrayList<ContaOrcamento> subContasOrcamento = null;
    
    /**
     * Método construtor com todos os atributos
     * @param valorOrcado variavel float valorOrcado com o valorOrcado da ContaOrcamento
     * @param valorRealizado variavel float valorRealizado com o valorRealizado da ContaOrcamento
     * @param valorComprometido variavel float valorComprometido com o valorComprometido da ContaOrcamento
     */
    public ContaOrcamento(float valorOrcado, float valorRealizado, float valorComprometido) {
        super();
        this.valorOrcado = valorOrcado;
        this.valorRealizado = valorRealizado;
        this.valorComprometido = valorComprometido;
    }
    
    /**
     * Método para atribuir valor ao atributo valorRealizado.
     * @param valorRealizado variável com o valor Realizado a ser inserida no atributo {@link #valorRealizado}
     */
    public void setValorRealizado(float valorRealizado) {
        this.valorRealizado = valorRealizado;
    }
    
    /**
     * Método que retorna o valor orçado da ContaOrcamento.
     * @return o atributo {@link #valorOrcado}
     */
    public float getValorOrcado() {
        if(this.hasSubContasOrcamento()){
            float valor=0;
            for(ContaOrcamento a: subContasOrcamento){
                valor+=a.getValorOrcado();
            }
            return valor;
        }else{    
            return valorOrcado;
        }
    }
    
    /**
     * Método que retorna o valor realizado da ContaOrcamento.
     * @return o atributo {@link #valorRealizado}
     */
    public float getValorRealizado() {
        if(this.hasSubContasOrcamento()){
            float valor=0;
            for(ContaOrcamento a: subContasOrcamento){
                valor+=a.getValorRealizado();
            }
            return valor;
        }else{    
            return valorRealizado;
        }
    }
    
    /**
     * Método que retorna o valor comprometido da ContaOrcamento.
     * @return o atributo {@link #valorComprometido}
     */
    public float getValorComprometido() {
        if(this.hasSubContasOrcamento()){
            float valor=0;
            for(ContaOrcamento a: subContasOrcamento){
                valor+=a.getValorComprometido();
            }
            return valor;
        }else{    
            return valorComprometido;
        }
    }    

    /**
     * Método que retorna uma lista de subContaOrcamento.
     * @return o atributo {@link #subContasOrcamento}
     */
    public ArrayList<ContaOrcamento> getSubContasOrcamento() {
        return subContasOrcamento;
    }
    
    /**
     * Método para atribuir valor ao atributo subContasOrcamento.
     * @param subContasOrcamento  variável com a lista de subContasOrcamento a ser inserida no atributo {@link #subContasOrcamento}
     */
    public void setSubContasOrcamento(ArrayList<ContaOrcamento> subContasOrcamento) {
        this.subContasOrcamento = subContasOrcamento;
    }
    
    /**
     * Método que retorna o valor disponivel da ContaOrcamento.
     * @return valorDisponivel
     */
    public float getValorDisponivel() {
        return this.getValorOrcado()-this.getValorRealizado()-this.getValorComprometido();
    }
    
    /**
     * Método para verificar se o arrayList de subContas está vazio.
     * @return verdadeiro se está vazio e falso se não estiver
     */
    public boolean hasSubContasOrcamento () {
        if (this.subContasOrcamento == null) {
            return false;
        }else {
            return true;
        }
        
    }
    
    /*public void atualizarValores (float valor) {
        if (this.hasSubContasOrcamento()) {
            this.valorRealizado = valor;
            this.valorComprometido = 0;
            this.valorOrcado = 0;
            buscarSubContas(this);
        }
    }*/
    
    public void buscarSubContas (ContaOrcamento subConta) {
        this.valorRealizado = this.valorRealizado + subConta.valorRealizado;
        this.valorComprometido = this.valorComprometido + subConta.valorComprometido;
        this.valorOrcado = this.valorOrcado + subConta.valorOrcado;
        if (subConta.hasSubContasOrcamento()) {
            for (int i=0; i < subConta.getSubContasOrcamento().size(); i++) {
                buscarSubContas(subConta.getSubContasOrcamento().get(i));
            }
        }
    }
}
