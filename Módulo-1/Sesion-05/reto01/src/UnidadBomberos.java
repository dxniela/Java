public class UnidadBomberos extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    // Constructor
    public UnidadBomberos(String nombre, String nombreOperador) {
        super(nombre);
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = new Operador(nombreOperador);
    }

    // Methods
    public void iniciarOperacion() {
        activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder();
    }

    // Overriding the responder method from UnidadEmergencia
    @Override
    public void responder() {
        System.out.println("Unidad de bomberos respondiendo a incendio estructural.\n");
    }
}
