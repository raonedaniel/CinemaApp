package senai.mobile.com.br.cinema.session;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;

public class Session {

    private SharedPreferences preferences;

    public Session(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Integer getUsuario() {
        Integer idUsuario = preferences.getInt("idUsuario",0);
        return idUsuario;
    }

    public void setUsuario(Integer idUsuario) {
        preferences.edit().putInt("idUsuario", idUsuario).commit();
    }

}
