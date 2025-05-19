import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class RegistroSimulacion {
    public static void main(String[] args) {
        // Se define la ruta del archivo parametros.txt dentro de la carpeta config/
        Path rutaCarpeta = Paths.get("src/config");
        Path rutaArchivo = rutaCarpeta.resolve("parametros.txt");

        // Se crea un String con los parámetros de simulación
        String parametros = "Tiempo de ciclo: 55.8 segundos\n"
                          + "Velocidad de línea: 1.2 m/s\n"
                          + "Número de estaciones: 8\n";

        try {
            // Crear la carpeta si no existe
            if (!Files.exists(rutaCarpeta)) {
                Files.createDirectory(rutaCarpeta);
                System.out.println("Carpeta 'config' creada.");
            }

            // Escribir el contenido en el archivo (crea o sobrescribe)
            Files.write(rutaArchivo, parametros.getBytes());
            System.out.println("Archivo de parámetros escrito correctamente.");

            // Se valida si el archivo fue creado
            if (Files.exists(rutaArchivo)) {
                System.out.println("El archivo fue creado exitosamente en: " + rutaArchivo.toAbsolutePath());

                // Leer el contenido y mostrarlo
                String contenidoLeido = Files.readString(rutaArchivo);
                System.out.println("Contenido del archivo:");
                System.out.println(contenidoLeido);
            } else {
                System.out.println("El archivo no fue creado.");
            }

        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());
        }
    }
    
}
