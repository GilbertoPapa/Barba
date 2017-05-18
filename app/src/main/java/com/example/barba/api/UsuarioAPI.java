package com.example.barba.api;

import com.example.barba.model.Usuario;

import retrofit.Call;
import retrofit.http.Path;

/**
 * Created by Gilbertopapa013 on 08/04/2017.
 */

public interface UsuarioAPI {

    @retrofit.http.GET("package/ctrl/{ctrlUsu}")
    Call<Usuario> getUser(@Path("ctrlUsu") String ctrl);
}
