package Proyecto.Modelo.creacionRandom;

import java.util.Random;

public class CreacionRandom {
    private Random random = new Random();

    public int[] generarCoordenadas() {
        int fila = random.nextInt(3);
        int columna = random.nextInt(3);

        return new int[]{fila, columna};
    }
}