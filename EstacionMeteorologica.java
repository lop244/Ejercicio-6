public class EstacionMeteorologica extends Dispositivo implements Medible, Registrable {

    private double temperatura;
    private double velocidadViento;

    public EstacionMeteorologica(String id, String nombre, double consumoElectrico) {
        super(id, nombre, consumoElectrico);
        this.temperatura = 25.0;
        this.velocidadViento = 10.0;
    }

    @Override
    public String medir() {
        this.temperatura = (Math.random() * 15.0) + 15.0; 
        this.velocidadViento = (Math.random() * 30.0);
        registrarEvento("Lectura de clima tomada.");
        return String.format("Clima: %.1f°C, Viento: %.1f km/h", this.temperatura, this.velocidadViento);
    }

    @Override
    public void registrarEvento(String evento) {
        this.ultimoRegistro = evento;
    }

    @Override
    public String toString() {
        return String.format("[Estación Meteorológica]\n  ID: %s, Nombre: %s, Consumo: %.2f kWh\n  Temp: %.1f°C, Viento: %.1f km/h\n  Ult. Registro: %s",
                id, nombre, consumoElectrico, temperatura, velocidadViento, ultimoRegistro);
    }
}