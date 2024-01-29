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
    private double precio;

    public Materiales(String codigo, String tono, String familia, double espesor, String nombre, String formato,double precio) {
        this.codigo = codigo;
        this.tono = tono;
        this.familia = familia;
        this.espesor = espesor;
        this.nombre = nombre;
        this.formato = formato;
        this.precio=precio;
    }

    // Getters para todas las propiedades

    public String getCodigo() {
        return codigo;
    }

    public String getTono() {
        return tono;
    }

    public String getFamilia() {
        return familia;
    }

    public double getEspesor() {
        return espesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFormato() {
        return formato;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("Tono: %s, Familia: %s, Espesor: %.2f, Nombre: %s, Formato: %s, Precio: %s",
                tono, familia, espesor, nombre, formato, precio);
    }
}



