package Proyecto.sorteo;

import java.util.Random;

public class Sorteo {
    private Random random = new Random();

    public int definirTurno() {
        return random.nextInt(2) + 1;
    }
}