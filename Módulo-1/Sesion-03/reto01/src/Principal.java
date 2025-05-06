public class Principal {
    public static void main(String[] args) {
        // Crear un vuelo
        Vuelo vuelo1 = new Vuelo("AA123", "Nueva York", "10:00 AM");
        
        // Crear un pasajero
        Pasajero pasajero1 = new Pasajero("Juan Perez", "AB123456");
        
        // Reservar asiento para el pasajero
        if (vuelo1.reservarAsiento(pasajero1)) {
            System.out.println("Reserva realizada con éxito.");
            vuelo1.mostrarItinerario();
        } else {
            System.out.println("No se pudo reservar el asiento.");
        }

        // Cancelar la reserva
        vuelo1.cancelarReserva();
        
        // Mostrar itinerario después de cancelar la reserva
        vuelo1.mostrarItinerario();

        // Reservar asiento con nombre y pasaporte
        if (vuelo1.reservarAsiento("Maria Lopez", "CD789012")) {
            System.out.println("\nReserva realizada con éxito.");
            vuelo1.mostrarItinerario();
        } else {
            System.out.println("No se pudo reservar el asiento.");
        }

    }
}
