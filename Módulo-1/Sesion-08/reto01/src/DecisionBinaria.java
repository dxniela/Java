import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {
    public String tomarDecision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println("A: Tomar el camino más oscuro");
        System.out.println("B: Tomar el camino más iluminado");
        System.out.print("Selecciona A o B: ");
        String input = scanner.nextLine();
        scanner.close();
        return input.toUpperCase();
    }
}

