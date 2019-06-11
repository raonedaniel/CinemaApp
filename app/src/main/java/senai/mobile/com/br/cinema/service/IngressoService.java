package senai.mobile.com.br.cinema.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import senai.mobile.com.br.cinema.model.Ingresso;

public interface IngressoService {

    @POST("/ingresso/new")
    Call<Ingresso> postIngresso(@Body Ingresso ingresso);

}
