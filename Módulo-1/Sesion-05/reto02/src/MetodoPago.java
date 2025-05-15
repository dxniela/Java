public abstract class MetodoPago implements Autenticable {
    double monto;

    // Constructor
    public MetodoPago(double monto) {
        this.monto = monto;
    }

    // abstract method to be implemented by subclasses
    public abstract void procesarPago();

    // method to show payment summary
    public void mostrarResumen() {
        System.out.println("Tipo: " + this.getClass().getSimpleName() + " - Monto: $" + monto);
    }    
}
