package cl.desafiolatam.pruebaperritosapp.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.desafiolatam.pruebaperritosapp.model.api.IDogDataBase;
import cl.desafiolatam.pruebaperritosapp.model.api.RetrofitClient;
import cl.desafiolatam.pruebaperritosapp.presenter.IPresenterDetail;
import cl.desafiolatam.pruebaperritosapp.presenter.IPresenterModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedModel implements IModel {
    private IPresenterModel iPresenterModel;
    IPresenterDetail iPresenterDetail;

    public BreedModel(IPresenterModel iPresenterModel) {
        this.iPresenterModel = iPresenterModel;
    }

    private static final String TAG = "breedModel";

    @Override
    public void loadBreeds() {
        IDogDataBase servicio = RetrofitClient.getRetrofitInstance().create(IDogDataBase.class);

        Call<RazasLista> listCall = servicio.listaRazas();
        final List<String> listaPerros = new ArrayList<>();

        listCall.enqueue(new Callback<RazasLista>() {
            @Override
            public void onResponse(Call<RazasLista> call, Response<RazasLista> response) {
                RazasLista listaRazas = response.body();
                Map<String, List<String>> mapa = listaRazas.getMessage();

                for (String key : mapa.keySet()) {
                    if (mapa.get(key).isEmpty()) {
                        listaPerros.add(key);
                    } else {
                        for (String subRaza : mapa.get(key)) {
                            listaPerros.add(key + " " + subRaza);
                        }
                    }

                }
                Log.i("Valor", "" + listaPerros);
                iPresenterModel.notificar(listaPerros);
            }

            @Override
            public void onFailure(Call<RazasLista> call, Throwable t) {

            }
        });


    }

    @Override
    public void loadImages(String raza, String subRaza) {

        IDogDataBase servicio = RetrofitClient.getRetrofitInstance().create(IDogDataBase.class);

        Call<RazaImagen> listCall = servicio.listaImagenes(raza);
        List<String> listaFotosPerros = new ArrayList<>();

        listCall.enqueue(new Callback<RazaImagen>() {
            @Override
            public void onResponse(Call<RazaImagen> call, Response<RazaImagen> response) {
                RazaImagen listaRazas = response.body();
                List<String> lista = (List<String>) listaRazas.getMessage();

                //Log.i("Valor", ""+listaPerros);
                iPresenterModel.notificar(lista);
            }

            @Override
            public void onFailure(Call<RazaImagen> call, Throwable t) {

            }
        });
    }
}