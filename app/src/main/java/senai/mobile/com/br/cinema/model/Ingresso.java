package senai.mobile.com.br.cinema.model;

public class Ingresso {

    private Integer id;

    private Integer idUsuario;

    private Integer idSecao;

    private String tipoIngresso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(Integer idSecao) {
        this.idSecao = idSecao;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idSecao=" + idSecao +
                ", tipoIngresso='" + tipoIngresso + '\'' +
                '}';
    }
}