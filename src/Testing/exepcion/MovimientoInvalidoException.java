package Testing.exepcion;

public class MovimientoInvalidoException extends RuntimeException {
    public MovimientoInvalidoException(String mensaje) {
        super(mensaje);
    }
}