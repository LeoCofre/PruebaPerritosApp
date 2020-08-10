package cl.desafiolatam.pruebaperritosapp.model;

public class PojoPerritos {

    String raza;
    String SubRaza;

    public PojoPerritos(String raza, String subRaza) {
        this.raza = raza;
        SubRaza = subRaza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSubRaza() {
        return SubRaza;
    }

    public void setSubRaza(String subRaza) {
        SubRaza = subRaza;
    }

    @Override
    public String toString() {
        return "PojoPerritos{" +
                "raza='" + raza + '\'' +
                ", SubRaza='" + SubRaza + '\'' +
                '}';
    }
}
