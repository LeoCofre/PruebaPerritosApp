package cl.desafiolatam.pruebaperritosapp.model;

import java.util.List;
import java.util.Map;

public class RazasLista {
    private String status;
    private Map<String, List<String>> message;

    public RazasLista(String status, Map<String, List<String>> message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    Map<String, List<String>> getMessage() {
        return message;
    }
}
