package Materiales;

import java.util.HashMap;
import java.util.Map;

public class Materiales {
    private String codigo;
    private String tono;
    private String familia;
    private double espesor;
    private String nombre;
    private String formato;

    public Materiales(String codigo, String tono, String familia, double espesor, String nombre, String formato) {
        this.codigo = codigo;
        this.tono = tono;
        this.familia = familia;
        this.espesor = espesor;
        this.nombre = nombre;
        this.formato = formato;
    }

    // Getters para todas las propiedades

    public String getCodigo() {
        return codigo;
    }

    // Otros getters

    @Override
    public String toString() {
        return String.format("Tono: %s, Familia: %s, Espesor: %.2f, Nombre: %s, Formato: %s",
                tono, familia, espesor, nombre, formato);
    }
}



