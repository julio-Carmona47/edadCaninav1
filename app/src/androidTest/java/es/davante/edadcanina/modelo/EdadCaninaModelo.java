package es.davante.edadcanina.modelo;

public class EdadCaninaModelo {

    public static final int FACTOR_CANINO = 7;
    public static final int EDAD_MINIMA = 1;
    public static final int EDAD_MAXIMA = 30;

    // Este método valida la entrada y devuelve un estado
    public Validacion validar(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return Validacion.VACIO;
        }
        int edad;
        try {
            edad = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return Validacion.NO_NUMERICO;
        }
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            return Validacion.FUERA_RANGO;
        }
        return Validacion.OK;
    }

    // Método que hace el cálculo matemático
    public int calcular(int edad) {
        return edad * FACTOR_CANINO;
    }
}