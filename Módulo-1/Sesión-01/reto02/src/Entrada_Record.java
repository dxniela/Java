public record Entrada_Record (String nombre, Double precio) {
    public void mostrarInformacion() {
       System.out.println("Evento: " + nombre + " | Precio: $" + precio);
    }
}