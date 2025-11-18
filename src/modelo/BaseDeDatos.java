package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private List<Producto> productos;

    /**
     * Constructor que inicializa la lista de productos.
     */
    public BaseDeDatos() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto a la base de datos.
     * 
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Busca un producto por su código SKU (ignora mayúsculas/minúsculas).
     * 
     * @param sku Código SKU a buscar
     * @return El producto encontrado o null si no existe
     */
    public Producto buscarProductoSku(String sku) {
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Retorna la lista completa de productos.
     * 
     * @return Lista de todos los productos
     */
    public List<Producto> buscarTodos() {
        return productos;
    }

    /**
     * Elimina un producto de la base de datos según su SKU.
     * 
     * @param sku Código SKU del producto a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarProducto(String sku) {
        Producto producto = buscarProductoSku(sku);
        if (producto != null) {
            productos.remove(producto);
            return true;
        }
        return false;
    }

}
