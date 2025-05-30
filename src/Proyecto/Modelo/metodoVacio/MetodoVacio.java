package Proyecto.Modelo.metodoVacio;

public class MetodoVacio {
    private final static char VACIO = '-';
    private char[][] tablero = {
            {VACIO, VACIO, VACIO},
            {VACIO, VACIO, VACIO},
            {VACIO, VACIO, VACIO}
    };

    public char[][] getTablero() {
        return tablero;
    }
}