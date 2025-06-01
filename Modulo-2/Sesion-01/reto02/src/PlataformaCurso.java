import java.util.List;
import java.util.function.Predicate;

public class PlataformaCurso {

    // Mostrar todos los materiales
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("Materiales del curso:");
        for (MaterialCurso m : lista) {
            m.mostrarDetalle();
        }
    }

    // Sumar duración de videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("\nDuración total de videos: " + total + " minutos");
    }

    // Marcar ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        System.out.println();
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio e = (Ejercicio) obj;
                e.marcarRevisado();
                System.out.println("Ejercicio '" + e.titulo + "' marcado como revisado.");
            }
        }
    }

    // Desafío adicional: Filtrar por autor
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\nFiltrando materiales por autor:");
        for (MaterialCurso m : lista) {
            if (filtro.test(m)) {
                m.mostrarDetalle();
            }
        }
    }
}
