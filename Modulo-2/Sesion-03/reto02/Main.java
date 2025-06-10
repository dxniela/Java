import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Datos simulados
        Sucursal centro = new Sucursal("Centro", Arrays.asList(
            new Encuesta("Ana", "El tiempo de espera fue largo", 2),
            new Encuesta("Luis", null, 3),
            new Encuesta("Carlos", "Buena atención", 5)
        ));

        Sucursal norte = new Sucursal("Norte", Arrays.asList(
            new Encuesta("María", "La atención fue buena, pero la limpieza puede mejorar", 3),
            new Encuesta("Pedro", null, 4)
        ));

        List<Sucursal> sucursales = Arrays.asList(centro, norte);

        // Procesamiento funcional
        sucursales.stream()
            .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .flatMap(encuesta ->
                        encuesta.getComentario()
                            .map(comentario ->
                                "Sucursal " + sucursal.getNombre() + ": Seguimiento a paciente con comentario: \"" + comentario + "\""
                            ).stream()
                    )
            )
            .forEach(System.out::println);
    }
}
