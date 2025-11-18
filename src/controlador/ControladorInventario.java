package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;
import java.util.List;

/**
 * Clase Controlador que conecta el Modelo y la Vista.
 * Orquesta el flujo de la aplicación y coordina las interacciones.
 */
public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    /**
     * Constructor que recibe e inicializa el modelo y la vista.
     * Implementa Inyección de Dependencias.
     * 
     * @param baseDatos Instancia del modelo (base de datos)
     * @param vista Instancia de la vista (interfaz de usuario)
     */
    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    /**
     * Método principal que inicia el bucle de la aplicación.
     * Maneja el menú y coordina las operaciones.
     */
    public void iniciar() {
        boolean salir = false;
        
        vista.mostrarMensaje("¡Bienvenido al Sistema de Gestión de Inventario DevSolutions!");
        
        while (!salir) {
            int opcion = vista.mostrarMenu();
            
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                    
                case 2:
                    buscarProducto();
                    break;
                    
                case 3:
                    mostrarTodosLosProductos();
                    break;
                    
                case 4:
                    eliminarProducto();
                    break;
                    
                case 5:
                    salir = true;
                    vista.mostrarMensaje("¡Gracias por usar el sistema! Hasta pronto.");
                    vista.cerrar();
                    break;
                    
                default:
                    vista.mostrarMensaje("❌ Opción inválida. Por favor, seleccione una opción del 1 al 5.");
                    break;
            }
        }
    }

    /**
     * Maneja la operación de agregar un nuevo producto.
     */
    private void agregarProducto() {
        Producto nuevoProducto = vista.pedirDatosProducto();
        baseDatos.agregarProducto(nuevoProducto);
        vista.mostrarMensaje("✓ Producto agregado correctamente.");
    }

    /**
     * Maneja la operación de buscar un producto por SKU.
     */
    private void buscarProducto() {
        String sku = vista.pedirSku();
        Producto producto = baseDatos.buscarProductoSku(sku);
        vista.mostrarProducto(producto);
    }

    /**
     * Maneja la operación de mostrar todos los productos.
     */
    private void mostrarTodosLosProductos() {
        List<Producto> productos = baseDatos.buscarTodos();
        vista.mostrarProductos(productos);
    }

    /**
     * Maneja la operación de eliminar un producto.
     */
    private void eliminarProducto() {
        String sku = vista.pedirSku();
        boolean eliminado = baseDatos.eliminarProducto(sku);
        
        if (eliminado) {
            vista.mostrarMensaje("✓ Producto eliminado correctamente.");
        } else {
            vista.mostrarMensaje("❌ Error: No se encontró un producto con ese SKU.");
        }
    }
}