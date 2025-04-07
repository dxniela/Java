public class Main {
    public static void main(String[] args) {
        Entrada entrada1 = new Entrada("Obra de Teatro", 450.0);
        Entrada entrada2 = new Entrada("Coachella", 995.45);

        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();

        System.out.println("\nDesafío adicional: entrada record");

        Entrada_Record entradaR1 = new Entrada_Record("Concierto", 455.00);
        Entrada_Record entradaR2 = new Entrada_Record("Congreso", 123.78);

        entradaR1.mostrarInformacion();
        entradaR2.mostrarInformacion();
    }
}
