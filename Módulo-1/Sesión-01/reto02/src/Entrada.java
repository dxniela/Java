public class Entrada {
    // Atributos
    String nombre;
    Double precio;

    // Constructor
    public Entrada (String Nombre, Double Precio) {
        this.nombre = Nombre;
        this.precio = Precio;
    }

    // Métodos
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombre + " | Precio: $" + precio);
    }
}