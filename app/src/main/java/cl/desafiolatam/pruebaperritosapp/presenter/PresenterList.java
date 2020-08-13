package cl.desafiolatam.pruebaperritosapp.presenter;

import android.util.Log;

import java.util.List;

import cl.desafiolatam.pruebaperritosapp.model.IModel;


public class PresenterList implements IPresenterList, IPresenterModel {

    private static final String TAG = "Presenter";
    IModel imodel;
    IPresenterViewList iPresenterViewList;


    public PresenterList(IPresenterViewList iPresenterViewList) {
        this.iPresenterViewList = iPresenterViewList;

    }

    public void setImodel(IModel imodel) {
        this.imodel = imodel;
    }

    @Override
    public void loadBreeds() {
        imodel.loadBreeds();
    }

    @Override
    public void notificar(List<String> breeds) {
        Log.d(TAG, breeds.toString());
        iPresenterViewList.notificar(breeds);
    }

    public interface IPresenterViewList {
        void notificar(List<String> lista);
    }
}
