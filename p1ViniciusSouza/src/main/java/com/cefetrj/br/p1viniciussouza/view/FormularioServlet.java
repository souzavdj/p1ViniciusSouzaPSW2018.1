/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cefetrj.br.p1viniciussouza.view;

import com.cefetrj.br.p1viniciussouza.model.Conta;
import com.cefetrj.br.p1viniciussouza.model.ContaOrcamento;
import com.cefetrj.br.p1viniciussouza.model.Empresa;
import com.cefetrj.br.p1viniciussouza.model.Orcamento;
import com.cefetrj.br.p1viniciussouza.model.PlanoDeContas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Servlet para a JSP Formulario.
 * @author vinicius
 * @version 1.0
 */
@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
    
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
        String nome = req.getParameter("empresa");
        int ano = 0;
        
        //Validação do campo Empresa.
        if (nome.isEmpty()) {
            validity = false;
            String msgErrEmpresa = "A empresa não pode estar vazia.";
            req.setAttribute("msgErrEmpresa", msgErrEmpresa);
        }else {
            //isValidity = "is-valid";
            //req.setAttribute("isValidityMarca", isValidity);
        }
        
        //Validação do campo Ano de fabricação.
        try {
            ano = Integer.parseInt(req.getParameter("ano"));
        }catch (NumberFormatException e) {
            if (ano == 0 && !req.getParameter("ano").isEmpty()) {
                validity = false;
                String msgErrAno = "Campo Numérico, digite somente numeros inteiros. ";
                req.setAttribute("msgErrAno", msgErrAno);
            }
        }
        /*if ((anoDeFabricacao < 1000 || anoDeFabricacao > 9999) && anoDeFabricacao != 0) {
            validity = false;
            isValidity = "is-invalid";
            req.setAttribute("isValidityAnoDeFabricacao", isValidity);
            String msgErrAnoDeFabricacao = "O campo ano de fabricação deve possuir 4 digitos.";
            req.setAttribute("msgErrAnoDeFabricacao", msgErrAnoDeFabricacao);
        }*/
        
        if (validity) {
            Empresa empresa = new Empresa(nome);
            ArrayList<ContaOrcamento> contas = new ArrayList<ContaOrcamento> ();
            ArrayList<ContaOrcamento> subContas = new ArrayList<ContaOrcamento> ();
            ArrayList<ContaOrcamento> subsubContas1 = new ArrayList<ContaOrcamento> ();
            ArrayList<PlanoDeContas> planosDeContas = new ArrayList();
            ArrayList<Orcamento> orcamentos = new ArrayList();
            ContaOrcamento conta = new ContaOrcamento(20000, 5000, 12000);
            ContaOrcamento subConta = new ContaOrcamento(2000, 3000, 2000);
            ContaOrcamento subConta1 = new ContaOrcamento(18000, 2000, 10000);
            ContaOrcamento subConta2 = new ContaOrcamento(18000, 2000, 10000);
            //ContaOrcamento subConta3 = new ContaOrcamento(10, 5, 1);
            subConta1.setCodigo(1);
            subConta1.setNome("Empregados");
            subConta.setCodigo(2);
            subConta.setNome("Empregados2");
            subConta2.setCodigo(1);
            subConta2.setNome("Adriano");
            subsubContas1.add(subConta2);
            subConta1.setSubContasOrcamento(subsubContas1);
            conta.setCodigo(1);
            conta.setNome("Despesas");
            //subConta1.atualizarValores(0);
            subContas.add(subConta1);
            subContas.add(subConta);
            conta.setSubContasOrcamento(subContas);
            //conta.atualizarValores(0);
            contas.add(conta);
            Orcamento orcamento = new Orcamento(ano);
            orcamento.setContas(contas);
            orcamentos.add(orcamento);
            empresa.setOrcamentos(orcamentos);
            
            req.getServletContext().setAttribute("empresa", empresa);
            req.getRequestDispatcher("Historico.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("Formulario.jsp").forward(req, resp);
        }
    }

    

}
