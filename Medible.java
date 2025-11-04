// Interfaz para dispositivos que realizan mediciones.
public interface Medible {
    /**
     * Realiza una medición y la reporta.
     * @return String con el resultado de la medición.
     */
    String medir();
}