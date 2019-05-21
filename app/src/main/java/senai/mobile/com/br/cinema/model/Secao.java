package senai.mobile.com.br.cinema.model;

import java.util.List;

public class Secao {

    private Integer id;

    private String data;

    private float valorDoIngresso;

    private Sala idSala;

    private Filme idFilme;

    private List<Ingresso> ingressos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValorDoIngresso() {
        return valorDoIngresso;
    }

    public void setValorDoIngresso(float valorDoIngresso) {
        this.valorDoIngresso = valorDoIngresso;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Filme getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Filme idFilme) {
        this.idFilme = idFilme;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    @Override
    public String toString() {
        return "Secao{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", valorDoIngresso=" + valorDoIngresso +
                ", idSala=" + idSala +
                ", idFilme=" + idFilme +
                ", ingressos=" + ingressos +
                '}';
    }
}