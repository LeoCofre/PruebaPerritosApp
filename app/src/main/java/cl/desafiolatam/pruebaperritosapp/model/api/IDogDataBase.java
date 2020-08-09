package cl.desafiolatam.pruebaperritosapp.model.api;

import cl.desafiolatam.pruebaperritosapp.model.RazaImagen;
import cl.desafiolatam.pruebaperritosapp.model.RazasLista;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDogDataBase {
    @GET("api/breeds/list/all")
    Call<RazasLista> listaRazas();

    @GET("api/breed/{breed}/images")
    Call<RazaImagen> listaImagenes(@Path("breed") String breed);
}
