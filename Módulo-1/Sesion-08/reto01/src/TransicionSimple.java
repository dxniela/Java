public class TransicionSimple implements TransicionHistoria {
    public void realizarTransicion(String decision) {
        if (decision.equalsIgnoreCase("A")) {
            System.out.println("El jugador se adentra en el camino más oscuro...");
        } else {
            System.out.println("El jugador se adentra en el camino más iluminado...");
        }
    }
}
