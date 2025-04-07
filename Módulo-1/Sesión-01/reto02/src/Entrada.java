public class Entrada {
    // Atributos
    String nombre;
    Double precio;

    // Constructor
    public Entrada (String Nombre, Double Precio) {
        nombre = Nombre;
        precio = Precio;
    }

    // Métodos
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombre + " | Precio: $" + precio);
    }
}