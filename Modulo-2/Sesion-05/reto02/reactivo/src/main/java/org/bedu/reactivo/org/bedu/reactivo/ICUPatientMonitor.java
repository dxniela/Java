import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

public class ICUPatientMonitor {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando monitoreo de pacientes en la UCI...");

        Flux<String> paciente1 = generarDatosPaciente(1);
        Flux<String> paciente2 = generarDatosPaciente(2);
        Flux<String> paciente3 = generarDatosPaciente(3);

        Flux<String> todosLosEventos = Flux.merge(paciente1, paciente2, paciente3)
                .delayElements(Duration.ofSeconds(1)) // Backpressure: procesamos lento
                .subscribeOn(Schedulers.parallel());

        todosLosEventos.subscribe(System.out::println);

        Thread.sleep(30000); // Simula monitoreo por 30 segundos
        System.out.println("Monitoreo finalizado.");
    }

    private static Flux<String> generarDatosPaciente(int id) {
        return Flux.interval(Duration.ofMillis(300))
                .onBackpressureBuffer(100)
                .map(i -> generarSignosVitales(id))
                .filter(msg -> !msg.isEmpty());
    }

    private static String generarSignosVitales(int pacienteId) {
        int fc = random.nextInt(60) + 40; // 40 - 100 bpm
        int sistolica = random.nextInt(100) + 70; // 70 - 170
        int diastolica = random.nextInt(60) + 40; // 40 - 100
        int spo2 = random.nextInt(15) + 85; // 85 - 100

        StringBuilder alerta = new StringBuilder();

        // Filtrado y prioridad
        if (fc < 50 || fc > 120) {
            alerta.append("Paciente ").append(pacienteId).append(" - FC critica: ").append(fc).append(" bpm\n");
        }
        if (sistolica < 90 || sistolica > 140 || diastolica < 60 || diastolica > 90) {
            alerta.append("Paciente ").append(pacienteId)
                    .append(" - PA critica: ").append(sistolica).append("/").append(diastolica).append(" mmHg\n");
        }
        if (spo2 < 90) {
            alerta.append("Paciente ").append(pacienteId).append(" - SpO2 baja: ").append(spo2).append("%\n");
        }

        return alerta.toString();
    }
}

