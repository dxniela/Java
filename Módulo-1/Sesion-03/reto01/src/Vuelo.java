public class Vuelo {
    final String codigoVuelo;
    String destino;
    String horaSalida;
    Pasajero asientoReservado;

    public Vuelo(String codigo, String destino, String horaSalida) {
        this.codigoVuelo = codigo;
        this.destino = destino;
        this.horaSalida = horaSalida;
    }

    // Asigna al pasajero si no hay reserva previa
    boolean reservarAsiento(Pasajero pasajero) {
        if (asientoReservado == null) {
            asientoReservado = pasajero;
            return true;
        } else {
            return false;
        }
    }

    // Método sobrecargado para reservar asiento con nombre y pasaporte
    boolean reservarAsiento(String nombre, String pasaporte) {
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre, pasaporte);
            return true;
        } else {
            return false;
        }
    }
    
    // Método para cancelar la reserva de un asiento
    public void cancelarReserva() {
        asientoReservado = null;
        System.out.println("\nReserva cancelada.");
    }

    // Mostrar itinerario del vuelo y el pasajero
    public void mostrarItinerario() {
        System.out.println("\nItinerario del vuelo:");
        System.out.println("Código: "+ codigoVuelo);
        System.out.println("Destino: " + destino);
        System.out.println("Hora de salida: " + horaSalida);
        System.out.println("Pasajero: " + (asientoReservado != null ? asientoReservado.getNombre() : "No hay pasajero reservado"));        
    }

    
}