package Proyecto.main.Salida;

public class Output {
    public void mostrarTablero(char[][] tablero) {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    public void pedirMovimiento() {
        System.out.println("Introduce las coordenadas que desees.");
    }

    public void mostrarGanador(int turno) {
        System.out.println("¡El jugador " + (turno == 1 ? "X" : "O") + " ha ganado!");
    }

    public void mostrarEmpate() {
        System.out.println("¡Empate!");
    }

    public void movimientoInvalido() {
        System.out.println("Intenta nuevamente.");
    }
}