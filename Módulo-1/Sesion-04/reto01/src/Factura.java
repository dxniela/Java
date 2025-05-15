public class Factura {
    private String folio;
    private String cliente;
    private double total;

    // Constructor
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // toString method
    @Override
    public String toString() {
        return "Factura [folio=" + folio + ", cliente=" + cliente + ", total= $" + total + "]";
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Factura factura = (Factura) obj;
        return this.folio.equals(factura.folio); // Compare only folio
    }

    // hashCode method
    @Override
    public int hashCode() {
        return folio.hashCode(); 
    }
}
