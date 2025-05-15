public class PagoEfectivo extends MetodoPago {

    // Constructor
    public PagoEfectivo(double monto) {
        super(monto);
    }

    // Implementación del método autenticar
    @Override
    public boolean autenticar() {
        return true; 
    }

    // Implementación del método procesarPago
    @Override
    public void procesarPago() {
        System.out.println("Procesando pago en efectivo por $" + monto);
    }
}
