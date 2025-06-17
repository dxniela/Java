import java.util.concurrent.*;

public class MovilidadApp {

    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Calculando ruta...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4)); // 2-3 segundos
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Estimando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3)); // 1-2 segundos
                return 75.50; // Simulación simple
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public void procesarSolicitud() {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            return "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
        }).exceptionally(ex -> {
            return "Ocurrió un error al procesar la solicitud: " + ex.getMessage();
        }).thenAccept(System.out::println);
    }
}