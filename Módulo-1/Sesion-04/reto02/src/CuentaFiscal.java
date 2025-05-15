import java.util.Objects;

public class CuentaFiscal {

    private final String rfc;
    private double saldoDisponible;

    // Constructor
    public CuentaFiscal(String rfc, double saldoDisponible) {
        this.rfc = rfc;
        if (saldoDisponible < 0) {
            System.out.println("El saldo disponible no puede ser negativo. Se establece a 0.");
            this.saldoDisponible = 0;
        } else {
            this.saldoDisponible = saldoDisponible;
        }
    }

    // Getters
    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Method to validate the RFC
    public boolean validarRFC(DeclaracionImpuestos declaracion) {
        return Objects.equals(this.rfc, declaracion.rfcContribuyente());
    }

    // Method to show account info
    public void mostrarCuenta() {
        System.out.println("Cuenta fiscal registrada con RFC: " + rfc + ", saldo disponible: $" + saldoDisponible);
    }    
}
