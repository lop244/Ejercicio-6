public class DronRiego extends Dispositivo implements Medible, Accionable, Registrable {

    private double nivelTanqueAgua;
    private boolean enVuelo;

    public DronRiego(String id, String nombre, double consumoElectrico, double capacidadTanque) {
        super(id, nombre, consumoElectrico);
        this.nivelTanqueAgua = capacidadTanque;
        this.enVuelo = false;
    }

    @Override
    public String medir() {
        registrarEvento("Escaneo multiespectral iniciado.");
        return "Escaneo multiespectral completado. Parcela 'A-5' necesita agua.";
    }

    @Override
    public String ejecutarAccion(String accion) {
        if (accion.equalsIgnoreCase("rociar") && nivelTanqueAgua > 0) {
            this.nivelTanqueAgua -= 10.0;
            if (this.nivelTanqueAgua < 0) this.nivelTanqueAgua = 0;
            registrarEvento("Acción: Rociar parcela.");
            return "Rociando... Tanque restante: " + this.nivelTanqueAgua + "L";
        } else if (accion.equalsIgnoreCase("aterrizar")) {
            this.enVuelo = false;
            return "Aterrizando.";
        } else if (nivelTanqueAgua <= 0) {
            return "No se puede rociar: Tanque vacío.";
        }
        return "Acción no reconocida.";
    }

    @Override
    public void registrarEvento(String evento) {
        this.ultimoRegistro = evento;
    }

    @Override
    public String toString() {
        return String.format("[Dron de Riego]\n  ID: %s, Nombre: %s, Consumo: %.2f kWh\n  Tanque: %.1f L, En Vuelo: %s\n  Ult. Registro: %s",
                id, nombre, consumoElectrico, nivelTanqueAgua, enVuelo, ultimoRegistro);
    }
}