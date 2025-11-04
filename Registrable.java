// Interfaz para dispositivos que registran eventos en una bitácora.
public interface Registrable {
    /**
     * Registra un evento en el dispositivo.
     * @param evento Mensaje o evento a registrar.
     */
    void registrarEvento(String evento);
}