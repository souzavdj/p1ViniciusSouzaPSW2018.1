/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.view;

import com.cefetrj.br.p1viniciussouza.model.ContaOrcamento;
import com.cefetrj.br.p1viniciussouza.model.Empresa;
import com.cefetrj.br.p1viniciussouza.model.Orcamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Servlet para a JSP Historico.
 * @author vinicius
 */
@WebServlet("/HistoricoServlet")
public class HistoricoServlet extends HttpServlet {
    boolean buscaEncontra = false;
    /**
     * Método responsável por receber os dados do JSP Formulario, fazer a validação dos mesmo e envia-los para a JSP Historico.
     * @param req um objeto HttpServletRequest que contém a solicitação feita pelo cliente do servlet.
     * @param resp um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do POST não puder ser tratado
     * @throws IOException se um erro de entrada ou saída for detectado quando o servlet manipula o pedido
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        boolean validity = true;
        //String isValidity = "";
        String codigoDes;
        float valorRealizado = 0;
        this.buscaEncontra=false;
        //Validação do campo valorRealizado.
        try {
            valorRealizado = Integer.parseInt(req.getParameter("valorRealizado"));
        }catch (NumberFormatException e) {
            if (valorRealizado == 0 && !req.getParameter("valorRealizado").isEmpty()) {
                validity = false;
                String msgErrValorRealizado = "Campo Numérico, digite somente numeros inteiros. ";
                req.setAttribute("msgErrValorRealizado", msgErrValorRealizado);
            }
        }
        //Validação do campo Codigo.        
        codigoDes = req.getParameter("codigo");
        Empresa empresa = (Empresa) req.getServletContext().getAttribute("empresa");
        boolean encontrou = false;
            ArrayList<Orcamento> orcamentos = empresa.getOrcamentos();
            for (Orcamento orcamento: orcamentos) {
                for (ContaOrcamento contaOrcamento: orcamento.getContas()) {
                    if (contaOrcamento.hasSubContasOrcamento()) {
                        String codigo = String.valueOf(contaOrcamento.getCodigo()) + ".";
                        if (codigoDes.equals(codigo)) {
                            contaOrcamento.setValorRealizado(valorRealizado);
                            this.buscaEncontra = true;
                            System.out.println(contaOrcamento.getNome());
                        }
                        for (ContaOrcamento subConta : contaOrcamento.getSubContasOrcamento()) {
                            buscarSubContas(subConta, codigo, codigoDes, valorRealizado);
                        }
                    }
                }
            }
            if (this.buscaEncontra) {
                encontrou = this.buscaEncontra;
                /*for (int i = 0; i < orcamentos.size(); i++) {
                    for (int j = 0; j < orcamentos.get(i).getContas().size(); i++) {
                        orcamentos.get(i).getContas().get(j).atualizarValores();
                    }
                }*/
                //System.out.println("funciona");
            }
        if (!encontrou) {
            validity = false;
            String msgErrCodigo = "Codigo não encontrado.";
            req.setAttribute("msgErrCodigo", msgErrCodigo);
        }

        
        if (validity) {
            
            req.getRequestDispatcher("Historico.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("Historico.jsp").forward(req, resp);
        }
    }
    public void buscarSubContas (ContaOrcamento subConta, String codigo, String codigoDes, float valor) {
        codigo = codigo + String.valueOf(subConta.getCodigo()) + ".";
        if (codigo.equals(codigoDes)) {
            this.buscaEncontra = true;
            subConta.setValorRealizado(valor);
            System.out.println("Dentro do busca: "+subConta.getNome());
            //subConta.atualizarValores(valor);
        }
        if (subConta.hasSubContasOrcamento()) {
            for (int i=0; i < subConta.getSubContasOrcamento().size(); i++) {
                buscarSubContas(subConta.getSubContasOrcamento().get(i), codigo, codigoDes, valor);
            }
        }
    }
}
