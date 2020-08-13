package cl.desafiolatam.pruebaperritosapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import cl.desafiolatam.pruebaperritosapp.view.ListDogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.mainFrameLayout, ListDogFragment.newInstance(1), "listaPerritos").commit();
    }

    @Override
    public void onBackPressed() {
        Fragment oldFragment = getSupportFragmentManager().findFragmentByTag("details");
        if (oldFragment == null) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.mainFrameLayout, ListDogFragment.newInstance(1), "listaPerritos").remove(oldFragment).commit();
        }

    }
}
