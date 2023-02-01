package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.orcamento.DomainException;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class Aprovado extends SituacaoOrcamento {

    @Override
    public void aprovar(Orcamento orcamento) {
        throw new DomainException("Não pode ser aprovado.");
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
