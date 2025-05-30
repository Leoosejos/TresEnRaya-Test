package Proyecto.main;

import Proyecto.main.Entrada.Input;
import Proyecto.main.Salida.Output;
import Proyecto.validator.Validador;
import Proyecto.Modelo.metodoVacio.MetodoVacio;
import Proyecto.Modelo.metodoModificado.MetodoModificado;
import Proyecto.Modelo.creacionRandom.CreacionRandom;
import Proyecto.sorteo.Sorteo;
import Testing.exepcion.MovimientoInvalidoException;

public class TresEnRaya {
    public static void main(String[] args) {
        MetodoVacio tablero = new MetodoVacio();
        Validador validador = new Validador();
        MetodoModificado modificador = new MetodoModificado();
        CreacionRandom random = new CreacionRandom();
        Sorteo sorteo = new Sorteo();
        Output output = new Output();
        Input input = new Input();

        int turno = sorteo.definirTurno();
        boolean juegoActivo = true;

        while (juegoActivo) {
            output.mostrarTablero(tablero.getTablero());
            int[] coordenadas;
            try {
                if (turno == 1) {
                    output.pedirMovimiento();
                    coordenadas = input.pedirCoordenadas();
                } else {
                    coordenadas = random.generarCoordenadas();
                }

                if (validador.esMovimientoValido(tablero.getTablero(), coordenadas)) {
                    modificador.realizarMovimiento(tablero.getTablero(), coordenadas, turno);
                    if (validador.hayGanador(tablero.getTablero())) {
                        output.mostrarGanador(turno);
                        juegoActivo = false;
                    } else if (validador.esEmpate(tablero.getTablero())) {
                        output.mostrarEmpate();
                        juegoActivo = false;
                    } else {
                        turno = (turno == 1) ? 2 : 1;
                    }
                }
            } catch (MovimientoInvalidoException e) {
                output.movimientoInvalido();
            }
        }
    }
}