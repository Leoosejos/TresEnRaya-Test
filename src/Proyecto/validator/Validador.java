package Proyecto.validator;

import Testing.exepcion.MovimientoInvalidoException;

public class Validador {
    public boolean esMovimientoValido(char[][] tablero, int[] coordenadas) {
        int fila = coordenadas[0];
        int columna = coordenadas[1];
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length || tablero[fila][columna] != '-') {
            throw new MovimientoInvalidoException("Movimiento inválido en coordenadas: (" + (fila + 1) + ", " + (columna + 1) + ")");
        }
        return true;
    }

    public boolean hayGanador(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
            if (tablero[0][i] != '-' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                return true;
            }
        }
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }
        return false;
    }

    public boolean esEmpate(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                if (celda == '-') {
                    return false;
                }
            }
        }
        return !hayGanador(tablero);
    }
}
