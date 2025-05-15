public class Principal {
    public static void main(String[] args) {
        // Crear una factura con RFC
        Factura facturaConRFC = new Factura(1000.0, "Compra de productos", "ABC123456789");
        System.out.println(facturaConRFC.getResumen());

        // Crear una factura sin RFC
        Factura facturaSinRFC = new Factura(2000.0, "Compra de servicios", null);
        System.out.println(facturaSinRFC.getResumen());
    }
}
