import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc; // Optional<String> es un contenedor que puede o no contener un valor

    // Public methods
    // Constructor
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc); // Si rfc es null, se asigna un Optional vacío
    }

    // Getter
    public String getResumen() {
        return "Factura generada:\n" +
                "Descripción: " + descripcion + "\n" +
                "Monto: " + monto + "\n" +
                "RFC: " + rfc.orElse("[No proporcionado]") + "\n"; // orElse devuelve el valor contenido o un valor por defecto si está vacío
    }
}