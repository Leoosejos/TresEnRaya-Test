package Proyecto.Documentation;

public class documentacion {
    /*package Proyecto.main;

import Proyecto.main.input.Input;
import Proyecto.main.output.Output;
import Proyecto.validator.Validador;
import Proyecto.Modelo.metodoVacio1.MetodoVacio;
import Proyecto.Modelo.metodoVacio.MetodoModificado;
import Proyecto.Modelo.creacionRandom.CreacionRandom;
import Proyecto.sorteo.Sorteo;

import java.util.Scanner;

public class TresEnRaya {
    public static void Proyecto.main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MetodoVacio tablero = new MetodoVacio();
        Validador validador = new Validador();
        MetodoModificado modificador = new MetodoModificado();
        CreacionRandom random = new CreacionRandom();
        Sorteo Proyecto.sorteo = new Sorteo();
        Output Proyecto.main.output = new Output();
        Input Proyecto.main.input = new Input();

        int turno = Proyecto.sorteo.definirTurno();
        boolean juegoActivo = true;

        while (juegoActivo) {
            Proyecto.main.output.mostrarTablero(tablero.getTablero());
            int[] coordenadas;
            if (turno == 1) {
                Proyecto.main.output.pedirMovimiento();
                coordenadas = Proyecto.main.input.pedirCoordenadas();
            } else {
                coordenadas = random.generarCoordenadas();
            }

            if (validador.esMovimientoValido(tablero.getTablero(), coordenadas)) {
                modificador.realizarMovimiento(tablero.getTablero(), coordenadas, turno);
                if (validador.hayGanador(tablero.getTablero())) {
                    Proyecto.main.output.mostrarGanador(turno);
                    juegoActivo = false;
                } else if (validador.esEmpate(tablero.getTablero())) {
                    Proyecto.main.output.mostrarEmpate();
                    juegoActivo = false;
                } else {
                    turno = (turno == 1) ? 2 : 1;
                }
            } else {
                Proyecto.main.output.movimientoInvalido();
            }
        }
    }
}


--------------------------------------------------------------------------------------------
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

--------------------------------------------------------------------------------------------package Proyecto.Modelo.creacionRandom;

import java.util.Random;

public class CreacionRandom {
    private Random random = new Random();

    public int[] generarCoordenadas() {
        int fila = random.nextInt(3) + 1;
        int columna = random.nextInt(3) + 1;

        return new int[]{fila - 1, columna - 1};
    }
}

--------------------------------------------------------------------------------------------
package Proyecto.Modelo.metodoVacio;

public class MetodoModificado {
    public void realizarMovimiento(char[][] tablero, int[] coordenadas, int jugador) {
        int fila = coordenadas[0];
        int columna = coordenadas[1];

        tablero[fila][columna] = (jugador == 1) ? 'X' : 'O';
    }
}

--------------------------------------------------------------------------------------------
package Proyecto.Modelo.metodoVacio;

public class MetodoVacio {
    private final static char JUGADOR = 'X';
    private final static char MAQUINA = 'O';
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
--------------------------------------------------------------------------------------------
package Proyecto.main.output;

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

--------------------------------------------------------------------------------------------

package Proyecto.sorteo;

import java.util.Random;

public class Sorteo {
    private Random random = new Random();

    public int definirTurno() {
        return random.nextInt(2) + 1;
    }
}
--------------------------------------------------------------------------------------------
package Proyecto.validator;

public class Validador {
    public boolean esMovimientoValido(char[][] tablero, int[] coordenadas) {
        int fila = coordenadas[0];
        int columna = coordenadas[1];
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-';
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
        return true;
    }
}
--------------------------------------------------------------------------------------------
package Proyecto.main.input;

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
}*/
}
