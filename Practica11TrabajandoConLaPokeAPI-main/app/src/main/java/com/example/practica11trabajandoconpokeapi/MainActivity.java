package com.example.practica11trabajandoconpokeapi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear una instancia del servicio de la API
        PokeApiService service = RetrofitInstance.getRetrofitInstance().create(PokeApiService.class);

        // Llamar al endpoint para obtener información de Pikachu
        Call<PokeResponse> call = service.getPokemon("ditto");

        call.enqueue(new Callback<PokeResponse>() {
            @Override
            public void onResponse(Call<PokeResponse> call, Response<PokeResponse> response) {
                if (response.isSuccessful()) {
                    PokeResponse pokemon = response.body();
                    Log.d("MainActivity", "Nombre: " + pokemon.getName());
                    Log.d("MainActivity", "Altura: " + pokemon.getHeight());
                    Log.d("MainActivity", "Peso: " + pokemon.getWeight());

                } else {
                    Log.e("MainActivity", "Error en la respuesta: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokeResponse> call, Throwable t) {
                Log.e("MainActivity", "Error al llamar a la API", t);
            }
        });
    }
}
