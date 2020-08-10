package cl.desafiolatam.pruebaperritosapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cl.desafiolatam.pruebaperritosapp.view.DetailFragment;
import cl.desafiolatam.pruebaperritosapp.view.ListDogFragment;

public class MainActivity extends AppCompatActivity implements ListDogFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(String raza) {
        Log.d("AAAAAAAAAAA", raza);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetailFragment fragment = DetailFragment.newInstance("hola", "como estas?");
        //fragmentTransaction.add(R.id.frame_container, fragment, "FRAGMENT_DE_DETALLE");
        fragmentTransaction.commit();
    }

}



