package Proyecto.Modelo.creacionPersona;

import java.util.Scanner;

public class CreacionPersona {
    private Scanner sc = new Scanner(System.in);

    public int[] obtenerCoordenadas() {
        int fila, columna;
        do {
            System.out.println("Ingrese la fila (1-3): ");
            fila = sc.nextInt();
            System.out.println("Ingrese la columna (1-3): ");
            columna = sc.nextInt();
        } while (fila < 1 || fila > 3 || columna < 1 || columna > 3);

        return new int[]{fila - 1, columna - 1};
    }
}