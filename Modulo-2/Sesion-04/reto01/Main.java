import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        // Se espera lo suficiente para que las tareas se completen antes de finalizar main
        TimeUnit.SECONDS.sleep(5);
    }
}
