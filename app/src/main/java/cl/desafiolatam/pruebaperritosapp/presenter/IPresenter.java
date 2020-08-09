package cl.desafiolatam.pruebaperritosapp.presenter;

public interface IPresenter {

    void loadBreeds();

    void loadBreedImages(String raza);

    void loadSubBreedImages(String raza, String subraza);
}
