
/**
 * Clase Controlador. Orquesta la aplicación, conecta Vista y Modelo.
 * Contiene el bucle principal del programa.
 */
public class ControladorPrincipal {

    private CatalogoDispositivos modelo;
    private VistaConsola vista;

    public ControladorPrincipal() {
        this.modelo = new CatalogoDispositivos();
        this.vista = new VistaConsola();
    }

    /**
     * Inicia la ejecución del programa.
     */
    public void run() {
        // Bandera para controlar el bucle principal (evita while(true))
        boolean seguirEjecutando = true;

        while (seguirEjecutando) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    // Listar todos
                    vista.mostrarDispositivos(modelo.getDispositivos());
                    break;
                case 2:
                    // Buscar por ID
                    String id = vista.solicitarEntrada("Ingrese el ID a buscar: ");
                    vista.mostrarDispositivo(modelo.buscarPorId(id));
                    break;
                case 3:
                    // Buscar por Nombre
                    String nombre = vista.solicitarEntrada("Ingrese el término de nombre a buscar: ");
                    vista.mostrarDispositivos(modelo.buscarPorNombre(nombre));
                    break;
                case 4:
                    // Ordenar por Consumo
                    modelo.ordenarPorConsumo();
                    vista.mostrarMensaje("Catálogo ordenado por consumo eléctrico.");
                    vista.mostrarDispositivos(modelo.getDispositivos());
                    break;
                case 5:
                    // Salir
                    seguirEjecutando = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }

            // Pausa amigable
            if (seguirEjecutando && opcion != 5) {
                vista.pausar();
            }
        }
        
        vista.cerrarScanner();
    }
}