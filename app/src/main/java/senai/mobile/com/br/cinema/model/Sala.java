package senai.mobile.com.br.cinema.model;

import java.util.List;

public class Sala {

    private Integer id;

    private String numero;

    private long quantidadeDeLugares;

    private List<Sessao> sessoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getQuantidadeDeLugares() {
        return quantidadeDeLugares;
    }

    public void setQuantidadeDeLugares(long quantidadeDeLugares) {
        this.quantidadeDeLugares = quantidadeDeLugares;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
}