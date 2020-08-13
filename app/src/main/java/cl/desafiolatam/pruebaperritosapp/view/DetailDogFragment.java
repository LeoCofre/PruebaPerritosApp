package cl.desafiolatam.pruebaperritosapp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.pruebaperritosapp.R;
import cl.desafiolatam.pruebaperritosapp.model.BreedModel;
import cl.desafiolatam.pruebaperritosapp.presenter.IPresenterViewDetail;
import cl.desafiolatam.pruebaperritosapp.presenter.PresenterDetail;


public class DetailDogFragment extends Fragment implements PresenterDetail.IPresenterViewImages, IPresenterViewDetail {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String raza;

    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;

    public DetailDogFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailDogFragment newInstance(String param1, String param2) {
        DetailDogFragment fragment = new DetailDogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView;
        textView = view.findViewById(R.id.nombreRazaDetalle);
        textView.setText(mParam1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            this.raza = mParam1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_dog, container, false);

        Context context = view.getContext();
        recyclerView = view.findViewById(R.id.recyclerViewDetail);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        //Enlace entre vista y presentador
        PresenterDetail presentador = new PresenterDetail(this);
        presentador.setImodel(new BreedModel(presentador));
        presentador.loadBreedImages(raza);

        return view;
    }

    @Override
    public void notificar(List<String> lista) {
        DogPhotoRecycleViewAdapter myAdaptador = new DogPhotoRecycleViewAdapter(lista);
        recyclerView.setAdapter(myAdaptador);
    }

    @Override
    public void showBreedImages(String breed) {

    }
}

