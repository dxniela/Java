import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        String[] profesionales = {
            "Dra. Sánchez",
            "Dr. Gómez",
            "Enfermero Ramírez",
            "Dra. López",
            "Dr. Torres"
        };

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (String profesional : profesionales) {
            executor.submit(() -> salaCirugia.usar(profesional));
        }

        executor.shutdown();
    }
}
