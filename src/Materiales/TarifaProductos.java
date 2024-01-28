package Materiales;

import java.util.HashMap;
import java.util.Map;

public class TarifaProductos {
    private Map<String, Materiales> mapaMateriales;

    public TarifaProductos() {
        this.mapaMateriales = new HashMap<>();
    }

    public void agregarMaterial(Materiales material) {
        mapaMateriales.put(material.getCodigo(), material);
    }

    public Materiales buscarMaterialPorCodigo(String codigo) {
        return mapaMateriales.get(codigo);
    }

    public static void main(String[] args) {
        TarifaProductos tarifa = new TarifaProductos();

        // Crear y almacenar materiales
        Materiales material1 = new Materiales("A01", "Rojo", "Cerámica", 5.0, "Material1", "A4");
        Materiales material2 = new Materiales("A02", "Azul", "Madera", 3.5, "Material2", "A3");

        tarifa.agregarMaterial(material1);
        tarifa.agregarMaterial(material2);

        // Buscar material por código
        Materiales resultado = tarifa.buscarMaterialPorCodigo("A01");

        // Imprimir el resultado
        if (resultado != null) {
            System.out.println("Material encontrado: " + resultado.toString());
        } else {
            System.out.println("Material no encontrado.");
        }
    }
}
