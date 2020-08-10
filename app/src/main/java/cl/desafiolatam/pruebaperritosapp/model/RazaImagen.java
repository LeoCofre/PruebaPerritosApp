package cl.desafiolatam.pruebaperritosapp.model;

import java.util.Map;

public class RazaImagen {
    private String status;
    private Map<String,String> message;

    public RazaImagen(String status, Map<String, String> message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getMessage() {
        return message;

    }

    @Override
    public String toString() {
        return "RazaImagen{" +
                "status='" + status + '\'' +
                ", message=" + message +
                '}';
    }
}
