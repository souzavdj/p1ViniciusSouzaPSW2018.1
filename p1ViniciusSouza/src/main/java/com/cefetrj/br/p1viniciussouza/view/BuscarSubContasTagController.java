/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.view;

import com.cefetrj.br.p1viniciussouza.model.ContaOrcamento;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Tag customizada para controlar a busca das subcontas de uma conta.
 * @author vinicius
 * @version 1.0
 */
public class BuscarSubContasTagController extends SimpleTagSupport {
    
    /**
     * Atributo conta é do tipo ContaOrcamento e é responsável por armazenar a contaOrcamento vinda de uma JSP.
     */
    private ContaOrcamento conta;
    
    /**
     * Atributo printHtml é do tipo String e é responsável por armazenar o codigo html que será inserido na JSP.
     */
    private String printHtml;
    
    /**
     * Método que retorna a conta recebida da JSP.
     * @return o atributo {@link #conta}
     */
    public ContaOrcamento getConta() {
        return conta;
    }
    
    /**
     * Método para atribuir valor ao atributo conta.
     * @param conta variável do tipo ContaOrcamento a ser inserida no atributo {@link #conta}
     */
    public void setConta(ContaOrcamento conta) {
        this.conta = conta;
    }
    
    /**
     * Método que retorna o codigo a ser inserido no JSP.
     * @return o atributo {@link #printHtml}
     */
    public String getPrintHtml() {
        return printHtml;
    }
    
    /**
     * Método para atribuir valor ao atributo printHtml.
     * @param printHtml variável do tipo String a ser inserida no atributo {@link #printHtml}
     */
    public void setPrintHtml(String printHtml) {
        this.printHtml = printHtml;
    }
    
    /**
     * Método que executa a tab.
     * @throws JspException as subclasses podem lançar JspException para indicar que ocorreu um erro ao processar essa tag
     * @throws IOException Subclasses podem lançar IOException se houver um erro ao gravar no fluxo de saída
     */
    @Override
    public void doTag() throws JspException, IOException {
        printHtml =
                    "<tr>" + 
                        "<th>"+conta.getCodigo() +". "+ conta.getNome()+"</th>" +
                        "<td>"+conta.getValorOrcado()+"</td>" + 
                        "<td>"+conta.getValorRealizado()+"</td>" + 
                        "<td>"+conta.getValorComprometido()+"</td>" + 
                        "<td>"+conta.getValorDisponivel()+"</td>" +
                    "</tr>";
        getJspContext().getOut().print(printHtml);
        if (this.conta.hasSubContasOrcamento()) {
            String codigo = String.valueOf(this.conta.getCodigo()) + ".";
            for (int i = 0; i < this.conta.getSubContasOrcamento().size(); i++) {
                buscarSubContas(this.conta.getSubContasOrcamento().get(i), codigo);
            }
        }else {
            System.out.println("A conta não possui subcontas");
        }
    }
    
    public void buscarSubContas (ContaOrcamento subConta, String codigo) throws JspException, IOException{
        codigo = codigo + String.valueOf(subConta.getCodigo()) + ".";
        String subContasString = 
                        "<tr>" + 
                            "<th>"+codigo+" "+subConta.getNome()+"</th>" +
                            "<td>"+subConta.getValorOrcado()+"</td>" + 
                            "<td>"+subConta.getValorRealizado()+"</td>" + 
                            "<td>"+subConta.getValorComprometido()+"</td>" + 
                            "<td>"+subConta.getValorDisponivel()+"</td>" +
                        "</tr>";
        getJspContext().getOut().print(subContasString);
        if (subConta.hasSubContasOrcamento()) {
            for (int i=0; i < subConta.getSubContasOrcamento().size(); i++) {
                buscarSubContas(subConta.getSubContasOrcamento().get(i), codigo);
            }
        }else {
            System.out.println("Não possui mais subContas.");
        }
    }
}
