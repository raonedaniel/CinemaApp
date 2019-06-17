package senai.mobile.com.br.cinema.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Filme implements Parcelable {

    private Integer id;

    private String nome;

    private String genero;

    private String sinopse;

    private String duracao;

    private boolean status;

    protected Filme(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nome = in.readString();
        genero = in.readString();
        sinopse = in.readString();
        duracao = in.readString();
        status = in.readByte() != 0;
    }

    public static final Creator<Filme> CREATOR = new Creator<Filme>() {
        @Override
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

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

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", duracao='" + duracao + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(nome);
        dest.writeString(genero);
        dest.writeString(sinopse);
        dest.writeString(duracao);
        dest.writeByte((byte) (status ? 1 : 0));
    }
}
