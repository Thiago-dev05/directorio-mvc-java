package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

/**
 * Clase responsable de la interfaz de usuario (consola).
 * Maneja toda la interacción con el usuario.
 * NO debe contener lógica de negocio.
 */
public class InventarioVista {
    private Scanner scanner;

    /**
     * Constructor que inicializa el Scanner.
     */
    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y captura la opción del usuario.
     * 
     * @return La opción seleccionada por el usuario
     */
    public int mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE GESTIÓN DE INVENTARIO");
        System.out.println("========================================");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }

    /**
     * Solicita al usuario los datos de un nuevo producto.
     * 
     * @return Un objeto Producto con los datos ingresados
     */
    public Producto pedirDatosProducto() {
        System.out.println("\n--- NUEVO PRODUCTO ---");
        
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        
        System.out.print("SKU (código único): ");
        String sku = scanner.nextLine();
        
        System.out.print("Cantidad en stock: ");
        int cantidad = scanner.nextInt();
        
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        
        return new Producto(nombre, sku, cantidad, precio);
    }

    /**
     * Solicita al usuario un código SKU.
     * 
     * @return El SKU ingresado
     */
    public String pedirSku() {
        System.out.print("Ingrese el SKU del producto: ");
        return scanner.nextLine();
    }

    /**
     * Muestra la información de un producto.
     * 
     * @param producto El producto a mostrar (puede ser null)
     */
    public void mostrarProducto(Producto producto) {
        System.out.println("\n--- RESULTADO DE BÚSQUEDA ---");
        if (producto != null) {
            System.out.println(producto.toString());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Muestra la lista completa de productos.
     * 
     * @param productos Lista de productos a mostrar
     */
    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n--- INVENTARIO COMPLETO ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Total de productos: " + productos.size());
            System.out.println("----------------------------------------");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
            System.out.println("----------------------------------------");
        }
    }

    /**
     * Muestra un mensaje genérico al usuario.
     * 
     * @param mensaje El mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }

    /**
     * Cierra el Scanner al finalizar.
     */
    public void cerrar() {
        scanner.close();
    }
}
