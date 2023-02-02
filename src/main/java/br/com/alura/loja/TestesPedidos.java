package br.com.alura.loja;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {

    public static void main(String[] args) {
        //simulação entrada de dados
        String cliente = "Rodrigo";
        BigDecimal valorOrcamento = new BigDecimal("200");
        int quantidadeItens = Integer.parseInt("4");

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);

        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(
                        new SalvarPedidoNoBancoDeDados(),
                        new EnviarEmailPedido()
                ));
        handler.execute(gerador);

    }
}
