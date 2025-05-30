package Testing;

import Proyecto.validator.Validador;
import Testing.exepcion.MovimientoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {

    @Test
    void testMovimientoValido() {
        Validador validador = new Validador();
        char[][] tablero = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        int[] coordenadas = {0, 0};
        assertTrue(validador.esMovimientoValido(tablero, coordenadas));
    }

    @Test
    void testMovimientoInvalido() {
        Validador validador = new Validador();
        char[][] tablero = {
                {'X', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        int[] coordenadas = {0, 0};  // Coordenadas inválidas porque ya están ocupadas.

        // Verificar que la excepción se lanza correctamente
        MovimientoInvalidoException exception = assertThrows(
                MovimientoInvalidoException.class, // Excepción esperada
                () -> validador.esMovimientoValido(tablero, coordenadas) // Acción que dispara la excepción
        );

        // Verificar que el mensaje de error es el esperado
        assertEquals("Movimiento inválido en coordenadas: (1, 1)", exception.getMessage());
    }

    @Test
    void testHayGanador() {
        Validador validador = new Validador();
        char[][] tablero = {
                {'X', 'X', 'X'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        assertTrue(validador.hayGanador(tablero));
    }

    @Test
    void testEsEmpate() {
        Validador validador = new Validador();
        char[][] tablero = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };

        assertTrue(validador.esEmpate(tablero));
    }
}