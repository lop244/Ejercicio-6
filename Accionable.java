// Interfaz para dispositivos que ejecutan una acción de comando.
public interface Accionable {
    /**
     * Ejecuta una acción específica.
     * @param accion El comando a ejecutar (ej. "rociar").
     * @return String confirmando el resultado de la acción.
     */
    String ejecutarAccion(String accion);
}