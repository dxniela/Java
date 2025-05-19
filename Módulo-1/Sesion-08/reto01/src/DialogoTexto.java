public class DialogoTexto implements GestorDialogo {
    public void mostrarDialogo(PaqueteNarrativo paquete) {
        System.out.println("Escena actual: " + paquete.getEscenaActual());
        System.out.println("Un señor misterioso se acerca a ti y te dice: ");
    }
}

