package org.bedu.reactivo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeSystem {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando monitoreo reactivo de sistemas criticos en Meridian Prime...\n");

        Flux<String> trafico = Flux.interval(Duration.ofMillis(500))
                .onBackpressureBuffer()
                .map(i -> (int) (Math.random() * 100))
                .filter(nivel -> nivel > 70)
                .map(nivel -> "Alerta: Congestion del " + nivel + "% en Avenida Solar");

        Flux<String> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> (int) (Math.random() * 100))
                .filter(pm -> pm > 50)
                .map(pm -> "Alerta: Contaminacion alta (PM2.5: " + pm + " ug/m3)");

        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    List<String> prioridades = Arrays.asList("Baja", "Media", "Alta");
                    String prioridad = prioridades.get((int) (Math.random() * 3));
                    return prioridad;
                })
                .filter(prioridad -> prioridad.equals("Alta"))
                .map(prioridad -> "Emergencia vial: Accidente con prioridad " + prioridad);

        Flux<String> trenes = Flux.interval(Duration.ofMillis(700))
                .onBackpressureBuffer()
                .map(i -> (int) (Math.random() * 11))
                .filter(retraso -> retraso > 5)
                .map(retraso -> "Tren maglev con retraso critico: " + retraso + " minutos");

        // Estado del semáforo por cruce, detectar 3 rojos seguidos
        AtomicInteger contadorRojos = new AtomicInteger(0);
        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    List<String> estados = Arrays.asList("Verde", "Amarillo", "Rojo");
                    return estados.get((int) (Math.random() * 3));
                })
                .filter(estado -> {
                    if (estado.equals("Rojo")) {
                        return contadorRojos.incrementAndGet() >= 3;
                    } else {
                        contadorRojos.set(0);
                        return false;
                    }
                })
                .map(e -> {
                    contadorRojos.set(0);
                    return "Semaforo en Rojo detectado 3 veces seguidas en cruce Norte";
                });

        // Combinamos todos los flujos críticos
        Flux<String> eventosCriticos = Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .doOnNext(System.out::println);

        // Alerta global si 3+ eventos críticos ocurren en un intervalo de 1s
        eventosCriticos
                .window(Duration.ofSeconds(1))
                .flatMap(window -> window.collectList())
                .filter(lista -> lista.size() >= 3)
                .map(lista -> "\nAlerta global: Multiples eventos criticos detectados en Meridian Prime\n")
                .subscribe(System.out::println);

        // Mantener el sistema corriendo por 15 segundos
        Thread.sleep(15000);
        System.out.println("\nMonitoreo finalizado.");
    }
}
