import controlador.ControladorInventario;
import modelo.BaseDeDatos;
import vista.InventarioVista;

/**
 * Clase principal que arranca la aplicación.
 * Responsable de crear e inyectar las dependencias del patrón MVC.
 */
public class App {
    
    /**
     * Punto de entrada de la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear la instancia del Modelo
        BaseDeDatos baseDatos = new BaseDeDatos();
        
        // Crear la instancia de la Vista
        InventarioVista vista = new InventarioVista();
        
        // Crear la instancia del Controlador, inyectando el Modelo y la Vista
        ControladorInventario controlador = new ControladorInventario(baseDatos, vista);
        
        // Iniciar la aplicación
        controlador.iniciar();
    }
}