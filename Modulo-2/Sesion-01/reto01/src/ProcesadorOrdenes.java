import java.util.List;

public class ProcesadorOrdenes {

    // Genérico con upper bound (para mostrar cualquier tipo de orden)
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println();
    }

    // Genérico con lower bound (para procesar solo las personalizadas)
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).procesarConCostoAdicional(costoAdicional);
            }
        }
        System.out.println();
    }

    // Desafío adicional: contar por tipo
    public static void contarOrdenes(List<? extends OrdenProduccion> lista) {
        int masa = 0, personalizadas = 0, prototipos = 0;

        for (OrdenProduccion orden : lista) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizadas++;
            else if (orden instanceof OrdenPrototipo) prototipos++;
        }

        System.out.println("Resumen total de órdenes:");
        System.out.println("Producción en masa: " + masa);
        System.out.println("Personalizadas: " + personalizadas);
        System.out.println("Prototipos: " + prototipos);
    }
}
