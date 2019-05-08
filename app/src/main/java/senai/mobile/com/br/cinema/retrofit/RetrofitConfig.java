package senai.mobile.com.br.cinema.retrofit;

import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import retrofit2.converter.jackson.JacksonConverterFactory;
import senai.mobile.com.br.cinema.service.FilmeService;

public class RetrofitConfig {

    public final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.44:8090")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }


    public FilmeService getFilmeService() {
        return this.retrofit.create(FilmeService.class);
    }

}
