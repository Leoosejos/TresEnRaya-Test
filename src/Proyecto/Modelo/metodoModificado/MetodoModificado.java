package Proyecto.Modelo.metodoModificado;

public class MetodoModificado {
    public void realizarMovimiento(char[][] tablero, int[] coordenadas, int jugador) {
        int fila = coordenadas[0];
        int columna = coordenadas[1];

        tablero[fila][columna] = (jugador == 1) ? 'X' : 'O';
    }
}