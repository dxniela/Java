import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Introducción a Java", "Mario", 15));
        materiales.add(new Video("POO en Java", "Carlos", 20));
        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));
        materiales.add(new Ejercicio("Variables y tipos", "Luis"));
        materiales.add(new Ejercicio("Condicionales", "Mario"));

        // Mostrar todos los materiales
        PlataformaCurso.mostrarMateriales(materiales);

        // Contar duración de los videos
        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        PlataformaCurso.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        PlataformaCurso.marcarEjerciciosRevisados(materiales);

        // Filtrar materiales por autor: "Mario"
        PlataformaCurso.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}
