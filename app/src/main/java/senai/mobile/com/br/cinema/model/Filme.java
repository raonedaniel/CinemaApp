package senai.mobile.com.br.cinema.model;

import java.util.List;

public class Filme {

    private Integer id;

    private String nome;

    private String genero;

    private String sinopse;

    private String duracao;

    private boolean status;

    private String capaDoFilme;

    private List<Sessao> sessoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCapaDoFilme() {
        return capaDoFilme;
    }

    public void setCapaDoFilme(String capaDoFilme) {
        this.capaDoFilme = capaDoFilme;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
}
