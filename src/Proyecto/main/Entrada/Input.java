package Proyecto.main.Entrada;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public int[] pedirCoordenadas() {
        int fila, columna;
        System.out.print("Ingrese la fila (1-3): ");
        fila = scanner.nextInt() - 1;
        System.out.print("Ingrese la columna (1-3): ");
        columna = scanner.nextInt() - 1;
        return new int[]{fila, columna};
    }
}
