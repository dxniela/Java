class Tema implements Comparable<Tema> {
    String titulo;
    int prioridad;

    // Constructor
    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    // CompareTo para ordenar alfabéticamente por título
    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareTo(otro.titulo);
    }

    // Método para mostrar el tema y su prioridad
    @Override
    public String toString() {
        return "Tema: " + titulo + " | Prioridad: " + prioridad;
    }
}