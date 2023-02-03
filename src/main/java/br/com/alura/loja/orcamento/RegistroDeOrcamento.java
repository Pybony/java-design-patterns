package br.com.alura.loja.orcamento;

import br.com.alura.loja.http.HttpAdapter;

import java.util.HashMap;
import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;
    private Map<String, Object> dados;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orcamento não finalizado!");
        }

        String url = "http://api.externa.com/orcamento";
        Map<String, Object> dados = new HashMap<>();
        dados.put("valor", orcamento.getValor());
        dados.put("quantidadeItens", orcamento.getQuantidadeItens());

        http.post(url, dados);
    }
}
