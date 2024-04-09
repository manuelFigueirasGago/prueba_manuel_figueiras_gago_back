package com.prueba.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.prueba.prueba.controller.OperativaController;
import com.prueba.prueba.services.impl.OperativaServceImpl;

@SpringBootTest
public class OperativaTest {

    OperativaController operatividad = new OperativaController(new OperativaServceImpl());

    @Test
    public void testOperativaParametrosVacios() {
        // Revisamos que cuando un parámetro de entrada es null devuelve lo correcto
        assertThrows(IllegalArgumentException.class, () -> operatividad.operacion(7, null, null));
    }

    @Test
    public void testOperativa1() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(7, 5, 12345);
        assertEquals(12339, resultadoObtenido.getBody());
    }

    @Test
    public void testOperativa2() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(5, 0, 4);
        assertEquals(0, resultadoObtenido.getBody());
    }

    @Test
    public void testOperativa3() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(10, 5, 15);
        assertEquals(15, resultadoObtenido.getBody());
    }

    @Test
    public void testOperativa4() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(17, 8, 54321);
        assertEquals(54306, resultadoObtenido.getBody());
    }

    @Test
    public void testOperativa5() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(499999993, 9, 1000000000);
        assertEquals(999999995, resultadoObtenido.getBody());
    }

    @Test
    public void testOperativa6() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(10, 5, 187);
        assertEquals(185, resultadoObtenido.getBody());
    }

    @Test
    public void testOperativa7() throws Exception {
        ResponseEntity<Integer> resultadoObtenido = operatividad.operacion(2, 0, 999999999);
        assertEquals(999999998, resultadoObtenido.getBody());
    }

}
