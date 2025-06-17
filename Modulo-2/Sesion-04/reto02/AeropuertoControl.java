import java.util.concurrent.*;

public class AeropuertoControl {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = Math.random() < 0.80; // 80% de probabilidad de que la pista esté disponible
            System.out.println("Pista disponible: " + resultado);
            return resultado;
        }, executor);
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = Math.random() < 0.85; // 85% de probabilidad de que el clima sea favorable
            System.out.println("Clima favorable: " + resultado);
            return resultado;
        }, executor);
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = Math.random() < 0.90; // 90% de probabilidad de que el tráfico aéreo esté despejado
            System.out.println("Tráfico aéreo despejado: " + resultado);
            return resultado;
        }, executor);
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia(2, 3);
            boolean resultado = Math.random() < 0.95; // 95% de probabilidad de que el personal de tierra esté disponible
            System.out.println("Personal disponible: " + resultado);
            return resultado;
        }, executor);
    }

    public void autorizarAterrizaje() {
        System.out.println("Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture.allOf(pista, clima, trafico, personal)
            .thenApply(v -> {
                try {
                    return pista.get() && clima.get() && trafico.get() && personal.get();
                } catch (Exception e) {
                    throw new CompletionException(e);
                }
            })
            .thenAccept(resultado -> {
                if (resultado) {
                    System.out.println("\nAterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\nAterrizaje denegado: condiciones no óptimas.");
                }
            })
            .exceptionally(ex -> {
                System.out.println("\nError al verificar condiciones de aterrizaje: " + ex.getMessage());
                return null;
            });
    }

    private void simularLatencia(int minSeg, int maxSeg) {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(minSeg, maxSeg + 1));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupción simulando latencia");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AeropuertoControl control = new AeropuertoControl();
        control.autorizarAterrizaje();

        // Tiempo suficiente para esperar la finalización de todos los servicios antes de cerrar main
        TimeUnit.SECONDS.sleep(5);
        control.executor.shutdown();
    }
}
