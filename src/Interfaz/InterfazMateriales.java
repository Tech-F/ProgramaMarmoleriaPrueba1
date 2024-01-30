package Interfaz;

import Materiales.Materiales;
import Materiales.TarifaProductos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class InterfazMateriales extends Application {
    private TarifaProductos tarifa = new TarifaProductos();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tarifa de Productos");

        // Crear controles
        TextField codigoField = new TextField();
        TextField nombreField = new TextField();
        TextField colorField = new TextField();
        TextField tipoField = new TextField();
        TextField precioField = new TextField();
        TextField ubicacionField = new TextField();
        TextArea resultadoArea = new TextArea();

        Button agregarButton = new Button("Agregar Material");
        Button buscarCodigoButton = new Button("Buscar por Código");
        Button buscarNombreButton = new Button("Buscar por Nombre");
        Button buscarColorButton = new Button("Buscar por Color");
        Button buscarTipoButton = new Button("Buscar por Tipo");
        Button buscarPrecioButton = new Button("Buscar por Precio");
        Button buscarUbicacionButton = new Button("Buscar por Ubicación");

        // Configurar acciones de los botones
        agregarButton.setOnAction(e -> agregarMaterial(codigoField, nombreField, colorField, tipoField, precioField, ubicacionField));
        buscarCodigoButton.setOnAction(e -> buscarPorCodigo(codigoField.getText(), resultadoArea));
        buscarNombreButton.setOnAction(e -> buscarPorNombre(nombreField.getText(), resultadoArea));
        buscarColorButton.setOnAction(e -> buscarPorColor(colorField.getText(), resultadoArea));
        buscarTipoButton.setOnAction(e -> buscarPorTipo(tipoField.getText(), resultadoArea));
        buscarPrecioButton.setOnAction(e -> buscarPorPrecio(precioField.getText(), resultadoArea));
        buscarUbicacionButton.setOnAction(e -> buscarPorUbicacion(ubicacionField.getText(), resultadoArea));

        // Crear diseño
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                codigoField, nombreField, colorField, tipoField, precioField, ubicacionField,
                agregarButton, buscarCodigoButton, buscarNombreButton, buscarColorButton,
                buscarTipoButton, buscarPrecioButton, buscarUbicacionButton, resultadoArea
        );

        // Configurar escena
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarMaterial(TextField codigoField, TextField nombreField, TextField colorField, TextField tipoField, TextField precioField, TextField ubicacionField) {
        // Lógica para agregar un nuevo material
        String codigo = codigoField.getText();
        String nombre = nombreField.getText();
        String color = colorField.getText();
        String tipo = tipoField.getText();
        double precio = Double.parseDouble(precioField.getText());
        String ubicacion = ubicacionField.getText();

        Materiales nuevoMaterial = new Materiales(codigo, color, tipo, precio, nombre, ubicacion,precio);
        tarifa.agregarMaterial(nuevoMaterial);

        // Limpiar campos después de agregar
        codigoField.clear();
        nombreField.clear();
        colorField.clear();
        tipoField.clear();
        precioField.clear();
        ubicacionField.clear();
    }

    private void buscarPorCodigo(String codigo, TextArea resultadoArea) {
        Materiales resultado = tarifa.buscarMaterialPorCodigo(codigo);
        mostrarResultado(resultado, resultadoArea);
    }

    private void buscarPorNombre(String nombre, TextArea resultadoArea) {
        Materiales resultado = tarifa.buscarMaterialPorNombre(nombre);
        mostrarResultado(resultado, resultadoArea);
    }

    private void buscarPorColor(String color, TextArea resultadoArea) {
        // Lógica para búsqueda por color
        List<Materiales> resultados = tarifa.buscarMaterialPorColor(color);
        mostrarResultados(resultados, resultadoArea);
    }

    private void buscarPorTipo(String tipo, TextArea resultadoArea) {
        // Lógica para búsqueda por tipo
        List<Materiales> resultados = tarifa.buscarMaterialPorTipo(tipo);
        mostrarResultados(resultados, resultadoArea);
    }

    private void buscarPorPrecio(String precio, TextArea resultadoArea) {
        // Lógica para búsqueda por precio
        double precioBusqueda = Double.parseDouble(precio);
        List<Materiales> resultados = tarifa.buscarMaterialPorPrecio(precioBusqueda);
        mostrarResultados(resultados, resultadoArea);
    }

    private void buscarPorUbicacion(String ubicacion, TextArea resultadoArea) {
        // Lógica para búsqueda por ubicación
        List<Materiales> resultados = tarifa.buscarMaterialPorUbicacion(ubicacion);
        mostrarResultados(resultados, resultadoArea);
    }

    private void mostrarResultado(Materiales resultado, TextArea resultadoArea) {
        if (resultado != null) {
            resultadoArea.setText("Material encontrado:\n" + resultado.toString());
        } else {
            resultadoArea.setText("Material no encontrado.");
        }
    }

    private void mostrarResultados(List<Materiales> resultados, TextArea resultadoArea) {
        if (!resultados.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("Resultados encontrados:\n");
            for (Materiales material : resultados) {
                stringBuilder.append(material.toString()).append("\n");
            }
            resultadoArea.setText(stringBuilder.toString());
        } else {
            resultadoArea.setText("No se encontraron resultados.");
        }
    }
}
