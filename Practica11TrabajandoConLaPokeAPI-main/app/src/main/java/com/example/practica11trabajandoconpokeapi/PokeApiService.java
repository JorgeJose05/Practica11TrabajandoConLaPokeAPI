package com.example.practica11trabajandoconpokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiService {
    @GET("pokemon/{name}")
    Call<PokeResponse> getPokemon(@Path("name") String name);
}
