/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.testesUnitarios;

import com.cefetrj.br.p1viniciussouza.model.ContaOrcamento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe test para testar os metodos get da classe ContaOrcamento.
 * @author vinicius
 * @version 1.0
 */
public class ContaOrcamentoTeste {
    
    /**
     * Teste do retorno do método getValorOrcamento da classe ContaOrcamento.
     */
    @Test
    public void testMethodGetValorOrcamento() {
        ContaOrcamento instance = new ContaOrcamento(20000,5000,3000);
        float resultOrcado = instance.getValorOrcado();
        float expResult = 20000;
        String result = String.valueOf(resultOrcado);
        String exp = String.valueOf(expResult);
        assertEquals(result, exp);
        //assertEquals(resultiOrcado, expResult);
    }
    
    /**
     * Teste do retorno do método getValorRealizado da classe ContaOrcamento.
     */
    @Test
    public void testMethodGetValorRealizado() {
        ContaOrcamento instance = new ContaOrcamento(20000,5000,3000);
        float resultRealizado = instance.getValorRealizado();
        float expResult = 5000;
        String result = String.valueOf(resultRealizado);
        String exp = String.valueOf(expResult);
        assertEquals(result, exp);
        //assertEquals(resultRealizado, expResult);
        //assertEquals(resultiOrcado, expResult);
    }
    
    /**
     * Teste do retorno do método getValorComprometido da classe ContaOrcamento.
     */
    @Test
    public void testMethodGetValorComprometido() {
        ContaOrcamento instance = new ContaOrcamento(20000,5000,3000);
        float resultComprometido = instance.getValorComprometido();
        float expResult = 3000;
        String result = String.valueOf(resultComprometido);
        String exp = String.valueOf(expResult);
        assertEquals(result, exp);
        //assertEquals(resultComprometido, expResult);
        //assertEquals(resultiOrcado, expResult);
    }
    
    /**
     * Teste do retorno do método getValorDisponivel da classe ContaOrcamento.
     */
    @Test
    public void testMethodGetValorDisponivel() {
        ContaOrcamento instance = new ContaOrcamento(20000,5000,3000);
        float resultDisponivel = instance.getValorDisponivel();
        float expResult = 12000;
        String result = String.valueOf(resultDisponivel);
        String exp = String.valueOf(expResult);
        assertEquals(result, exp);
        //assertEquals(resultiOrcado, expResult);
        //assertEquals(resultiOrcado, expResult);
    }
}
