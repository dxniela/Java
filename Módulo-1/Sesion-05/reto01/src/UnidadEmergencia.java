public abstract class UnidadEmergencia {
    String nombre;

    // Constructor
    public UnidadEmergencia(String nombre) {
        this.nombre = nombre;
    }

    // Methods
    public void activarUnidad() {
        System.out.println("Activando unidad: " + nombre);
    }

    // Method to be implemented by subclasses
    public abstract void responder();
}
