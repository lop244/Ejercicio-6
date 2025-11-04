public class SensorSuelo extends Dispositivo implements Medible, Registrable {
    
    private double humedadActual;

    public SensorSuelo(String id, String nombre, double consumoElectrico, double humedadInicial) {
        super(id, nombre, consumoElectrico);
        this.humedadActual = humedadInicial;
    }

    @Override
    public String medir() {
        this.humedadActual = (Math.random() * 50.0) + 20.0;
        registrarEvento("Medición de humedad realizada.");
        return String.format("Humedad del suelo: %.2f%%", this.humedadActual);
    }

    @Override
    public void registrarEvento(String evento) {
        this.ultimoRegistro = evento;
    }

    @Override
    public String toString() {
        return String.format("[Sensor de Suelo]\n  ID: %s, Nombre: %s, Consumo: %.2f kWh\n  Ult. Medición: %.2f%%\n  Ult. Registro: %s",
                id, nombre, consumoElectrico, humedadActual, ultimoRegistro);
    }
}