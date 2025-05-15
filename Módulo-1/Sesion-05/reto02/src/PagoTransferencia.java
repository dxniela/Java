public class PagoTransferencia extends MetodoPago {
    private boolean validadoExternamente;

    // Constructor
    public PagoTransferencia(double monto, boolean validadoExternamente) {
        super(monto);
        this.validadoExternamente = validadoExternamente;
    }

    // Implementación del método autenticar
    @Override
    public boolean autenticar() {
        return validadoExternamente;
    }

    // Implementación del método procesarPago
    @Override
    public void procesarPago() {
        System.out.println("Procesando transferencia por $" + monto);
    }
}
