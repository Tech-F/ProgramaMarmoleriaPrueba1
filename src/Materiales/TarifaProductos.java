package Materiales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TarifaProductos {
    private Map<String, Materiales> mapaMaterialesPorCodigo;
    private Map<String, Materiales> mapaMaterialesPorNombre;
    private Map<String, List<Materiales>> mapaMaterialesPorColor;
    private Map<String, List<Materiales>> mapaMaterialesPorTipo;
    private Map<Double, List<Materiales>> mapaMaterialesPorPrecio;
    private Map<String, List<Materiales>> mapaMaterialesPorFamilia;

    public TarifaProductos() {
        this.mapaMaterialesPorCodigo = new HashMap<>();
        this.mapaMaterialesPorNombre = new HashMap<>();
        this.mapaMaterialesPorColor = new HashMap<>();
        this.mapaMaterialesPorTipo = new HashMap<>();
        this.mapaMaterialesPorPrecio = new HashMap<>();
        this.mapaMaterialesPorFamilia = new HashMap<>();
    }

    public void agregarMaterial(Materiales material) {
        mapaMaterialesPorCodigo.put(material.getCodigo(), material);
        mapaMaterialesPorNombre.put(material.getNombre(), material);

        // Por tono
        mapaMaterialesPorColor.computeIfAbsent(material.getTono(), k -> new ArrayList<>()).add(material);

        // Por familia
        mapaMaterialesPorTipo.computeIfAbsent(material.getFamilia(), k -> new ArrayList<>()).add(material);

        // Por precio
        mapaMaterialesPorPrecio.computeIfAbsent(material.getPrecio(), k -> new ArrayList<>()).add(material);

        // Por familia
        mapaMaterialesPorFamilia.computeIfAbsent(material.getFamilia(), k -> new ArrayList<>()).add(material);
    }

    public Materiales buscarMaterialPorCodigo(String codigo) {
        return mapaMaterialesPorCodigo.get(codigo);
    }

    public Materiales buscarMaterialPorNombre(String nombre) {
        return mapaMaterialesPorNombre.get(nombre);
    }

    public List<Materiales> buscarMaterialPorColor(String color) {
        return mapaMaterialesPorColor.getOrDefault(color, new ArrayList<>());
    }

    public List<Materiales> buscarMaterialPorTipo(String tipo) {
        return mapaMaterialesPorTipo.getOrDefault(tipo, new ArrayList<>());
    }

    public List<Materiales> buscarMaterialPorPrecio(double precio) {
        return mapaMaterialesPorPrecio.getOrDefault(precio, new ArrayList<>());
    }

    public List<Materiales> buscarMaterialPorUbicacion(String ubicacion) {
        return mapaMaterialesPorFamilia.getOrDefault(ubicacion, new ArrayList<>());
    }

    // Otros métodos de búsqueda según sea necesario...

    public static void main(String[] args) {
        TarifaProductos tarifa = new TarifaProductos();

        // Crear y almacenar materiales
        Materiales material1 = new Materiales("A01", "Rojo", "Cerámica", 5.0, "Material1", "A4",14);
        Materiales material2 = new Materiales("A02", "Azul", "Madera", 3.5, "Material2", "A3",14);

        tarifa.agregarMaterial(material1);
        tarifa.agregarMaterial(material2);

        // Ejemplos de búsqueda por atributo
        Materiales resultadoCodigo = tarifa.buscarMaterialPorCodigo("A01");
        Materiales resultadoNombre = tarifa.buscarMaterialPorNombre("Material2");
        List<Materiales> resultadosColor = tarifa.buscarMaterialPorColor("Rojo");
        List<Materiales> resultadosTipo = tarifa.buscarMaterialPorTipo("Madera");
        List<Materiales> resultadosPrecio = tarifa.buscarMaterialPorPrecio(5.0);
        List<Materiales> resultadosUbicacion = tarifa.buscarMaterialPorUbicacion("A4");

        // Imprimir resultados
        // ... (Imprime los resultados según sea necesario)
    }
}
