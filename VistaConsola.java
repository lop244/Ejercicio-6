import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase de la Vista. Gestiona toda la interacción (E/S) con el usuario.
 * ÚNICA clase que usa System.out.println.
 */
public class VistaConsola {

    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y valida la entrada numérica.
     */
    public int mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión Agro-Tecnológica ---");
        System.out.println("1. Listar todos los equipos");
        System.out.println("2. Buscar equipo por ID");
        System.out.println("3. Buscar equipo por Nombre");
        System.out.println("4. Ordenar equipos por Consumo Eléctrico");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar buffer
            return -1; // Opción inválida
        }
    }

    /**
     * Muestra una lista de dispositivos (usando d.toString() polimórfico).
     */
    public void mostrarDispositivos(ArrayList<Dispositivo> lista) {
        if (lista == null || lista.isEmpty()) {
            mostrarMensaje("No se encontraron dispositivos.");
            return;
        }

        System.out.println("\n--- Catálogo de Dispositivos ---");
        for (Dispositivo d : lista) {
            System.out.println("---------------------------------");
            System.out.println(d.toString()); // Polimorfismo
        }
        System.out.println("---------------------------------");
    }

    /**
     * Muestra un único dispositivo (para búsqueda por ID).
     */
    public void mostrarDispositivo(Dispositivo d) {
        if (d != null) {
            System.out.println("\n--- Resultado de la Búsqueda ---");
            System.out.println("---------------------------------");
            System.out.println(d.toString());
            System.out.println("---------------------------------");
        } else {
            mostrarMensaje("Dispositivo no encontrado.");
        }
    }

    /**
     * Muestra un mensaje genérico al usuario.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n[SISTEMA] " + mensaje);
    }

    /**
     * Solicita una entrada de texto al usuario.
     */
    public String solicitarEntrada(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    /**
     * Pausa la ejecución hasta que el usuario presione Enter.
     */
    public void pausar() {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Cierra el Scanner al final del programa.
     */
    public void cerrarScanner() {
        this.scanner.close();
    }
}