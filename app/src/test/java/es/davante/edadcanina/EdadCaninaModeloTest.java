package es.davante.edadcanina;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import es.davante.edadcanina.modelo.EdadCaninaModelo;
import es.davante.edadcanina.modelo.Validacion;

public class EdadCaninaModeloTest {

    EdadCaninaModelo modelo = new EdadCaninaModelo();

    @Test
    public void testEntradaVacia() {
        assertEquals(Validacion.VACIO, modelo.validar(""));
        assertEquals(Validacion.VACIO, modelo.validar("   "));
        assertEquals(Validacion.VACIO, modelo.validar(null));
    }

    @Test
    public void testEntradaNoNumerica() {
        assertEquals(Validacion.NO_NUMERICO, modelo.validar("hola"));
        assertEquals(Validacion.NO_NUMERICO, modelo.validar("6.5"));
    }

    @Test
    public void testFueraDeRango() {
        assertEquals(Validacion.FUERA_RANGO, modelo.validar("0"));
        assertEquals(Validacion.FUERA_RANGO, modelo.validar("31"));
        assertEquals(Validacion.FUERA_RANGO, modelo.validar("-5"));
    }

    @Test
    public void testEntradaValida() {
        assertEquals(Validacion.OK, modelo.validar("6"));
        assertEquals(Validacion.OK, modelo.validar("15"));
    }

    @Test
    public void testCalculo() {
        modelo.setEntrada("6");
        modelo.calcular();
        assertEquals("42 años humanos", modelo.getResultado());
    }
}