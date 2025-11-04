public class ValvulaRiego extends Dispositivo implements Accionable, Registrable {

    private boolean abierta;

    public ValvulaRiego(String id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.abierta = false;
    }

    @Override
    public String ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("abrir")) {
            this.abierta = true;
            registrarEvento("Válvula abierta.");
            return "Válvula " + id + " está ABIERTA.";
        } else if (accion.equalsIgnoreCase("cerrar")) {
            this.abierta = false;
            registrarEvento("Válvula cerrada.");
            return "Válvula " + id + " está CERRADA.";
        }
        return "Acción no reconocida (use 'abrir' o 'cerrar').";
    }

    @Override
    public void registrarEvento(String evento) {
        this.ultimoRegistro = evento;
    }

    @Override
    public String toString() {
        String estado = abierta ? "ABIERTA" : "CERRADA";
        return String.format("[Válvula de Riego]\n  ID: %s, Nombre: %s, Consumo: %.2f kWh\n  Estado: %s\n  Ult. Registro: %s",
                id, nombre, consumoElectrico, estado, ultimoRegistro);
    }
}