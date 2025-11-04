public abstract class Dispositivo implements Comparable<Dispositivo> {
    
    protected String id;
    protected String nombre;
    protected double consumoElectrico;
    protected String ultimoRegistro;

    public Dispositivo(String id, String nombre, double consumoElectrico) {
        this.id = id;
        this.nombre = nombre;
        this.consumoElectrico = consumoElectrico;
        this.ultimoRegistro = "N/A";
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getConsumoElectrico() { return consumoElectrico; }

    @Override
    public int compareTo(Dispositivo o) {
        return Double.compare(this.consumoElectrico, o.consumoElectrico);
    }

    @Override
    public abstract String toString();
}