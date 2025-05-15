public class PagoTarjeta extends MetodoPago {
    private double saldoDisponible;

    // Constructor
    public PagoTarjeta(double monto, double saldoDisponible) {
        super(monto);
        this.saldoDisponible = saldoDisponible;
    }

    // Implementación del método autenticar
    @Override
    public boolean autenticar() {
        return saldoDisponible >= monto;
    }

    // Implementación del método procesarPago
    @Override
    public void procesarPago() {
        System.out.println("Procesando pago con tarjeta por $" + monto);
    }
}
