import java.util.ArrayList;
import java.util.Collections;

public class CatalogoDispositivos {

    private ArrayList<Dispositivo> dispositivos;

    public CatalogoDispositivos() {
        this.dispositivos = new ArrayList<>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        dispositivos.add(new SensorSuelo("SS-001", "Sensor Humedad Parcela A", 0.5, 45.0));
        dispositivos.add(new SensorSuelo("SS-002", "Sensor Humedad Parcela B", 0.5, 55.0));
        dispositivos.add(new EstacionMeteorologica("EM-001", "Estación Central", 2.5));
        dispositivos.add(new ValvulaRiego("VR-001", "Válvula Principal Norte", 1.2));
        dispositivos.add(new ValvulaRiego("VR-002", "Válvula Sector Sur", 1.2));
        dispositivos.add(new ValvulaRiego("VR-003", "Válvula Invernadero", 0.8));
        dispositivos.add(new DronRiego("DR-001", "Dron 'Aguilucho'", 5.0, 50.0));
        dispositivos.add(new DronRiego("DR-002", "Dron 'Colibrí'", 3.5, 25.0));
        dispositivos.add(new SensorSuelo("SS-003", "Sensor pH Invernadero", 0.6, 6.8));
        dispositivos.add(new EstacionMeteorologica("EM-002", "Estación Móvil", 1.9));
    }

    public ArrayList<Dispositivo> getDispositivos() {
        return new ArrayList<>(this.dispositivos);
    }

    public Dispositivo buscarPorId(String id) {
        for (Dispositivo d : dispositivos) {
            if (d.getId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    public ArrayList<Dispositivo> buscarPorNombre(String nombre) {
        ArrayList<Dispositivo> resultados = new ArrayList<>();
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(d);
            }
        }
        return resultados;
    }

    public void ordenarPorConsumo() {
        Collections.sort(this.dispositivos);
    }
}