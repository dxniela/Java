public class Pasajero {
    String nombre;
    String pasaporte;

    // Constructor de la clase Pasajero
    public Pasajero(String nombre, String pasaporte) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    // Obtenemos el nombre del pasajero
    public String getNombre() {
        return nombre;
    }

    // Obtenemos el pasaporte del pasajero
    public String getPasaporte() {
        return pasaporte;
    }
}
