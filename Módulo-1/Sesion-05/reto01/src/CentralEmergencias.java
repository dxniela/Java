public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia = new Ambulancia("Ambulancia", "Ana");
        Patrulla patrulla = new Patrulla("Patrulla", "Alejandro");
        UnidadBomberos bomberos = new UnidadBomberos("UnidadBomberos", "Daniela");

        ambulancia.iniciarOperacion();

        patrulla.iniciarOperacion();

        bomberos.iniciarOperacion();
    }
}
