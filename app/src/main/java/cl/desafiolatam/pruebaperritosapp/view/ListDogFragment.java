package cl.desafiolatam.pruebaperritosapp.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.pruebaperritosapp.R;
import cl.desafiolatam.pruebaperritosapp.model.BreedModel;
import cl.desafiolatam.pruebaperritosapp.presenter.PresenterList;


public class ListDogFragment extends Fragment implements PresenterList.IPresenterViewList {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    RecyclerView recyclerView;
    MyDogRecyclerViewAdapter myAdaptador;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListDogFragment() {
    }

    public static ListDogFragment newInstance(int columnCount) {
        ListDogFragment fragment = new ListDogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dog_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            PresenterList presentador = new PresenterList(this);
            presentador.setImodel(new BreedModel(presentador));
            presentador.loadBreeds();
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void notificar(List<String> lista) {
        Log.d("Datos", ""+lista);
        myAdaptador = new MyDogRecyclerViewAdapter(lista);
        recyclerView.setAdapter(myAdaptador);
        myAdaptador.setOnItemClickListener(new MyDogRecyclerViewAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Log.d("TAG", String.valueOf(position));
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.mainFrameLayout, DetailDogFragment.newInstance(lista.get(position),""), "details")
                .remove(getActivity().getSupportFragmentManager().findFragmentByTag("listaPerritos"))
                .commit();
            }
        });
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(int position);
    }
}
