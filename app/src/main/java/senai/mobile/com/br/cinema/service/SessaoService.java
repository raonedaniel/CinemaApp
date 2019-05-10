package senai.mobile.com.br.cinema.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import senai.mobile.com.br.cinema.model.Sessao;

public interface SessaoService {

    @GET("/sessoes/{id}")
    Call<Sessao> getAlbum(@Path("id") String id);

    @GET("/sessoes")
    Call<List<Sessao>> list();

}
