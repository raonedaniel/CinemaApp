package senai.mobile.com.br.cinema.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Secao implements Parcelable {

    private Integer id;

    private String data;

    private float valorDoIngresso;

    private String numeroDaSala;

    private String nomeDoFilme;

    public static final Creator<Secao> CREATOR = new Creator<Secao>() {
        @Override
        public Secao createFromParcel(Parcel in) {
            return new Secao(in);
        }

        @Override
        public Secao[] newArray(int size) {
            return new Secao[size];
        }
    };

    protected Secao(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        data = in.readString();
        valorDoIngresso = in.readFloat();
        numeroDaSala = in.readString();
        nomeDoFilme = in.readString();
    }

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

    public String getNumeroDaSala() {
        return numeroDaSala;
    }

    public void setNumeroDaSala(String numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    @Override
    public String toString() {
        return "Secao{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", valorDoIngresso=" + valorDoIngresso +
                ", numeroDaSala='" + numeroDaSala + '\'' +
                ", nomeDoFilme='" + nomeDoFilme + '\'' +
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
        dest.writeString(data);
        dest.writeFloat(valorDoIngresso);
        dest.writeString(numeroDaSala);
        dest.writeString(nomeDoFilme);
    }
}