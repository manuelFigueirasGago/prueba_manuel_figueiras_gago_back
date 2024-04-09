package com.prueba.prueba.services.impl;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.prueba.prueba.services.OperativaService;
import com.prueba.prueba.utils.ExcepcionPersonalizada;

/**
    * Lógica de negocio utilizada para aplicar lo requerido para la prueba 
    * 
    * @param x
    * @param y
    * @param n
    * @return Integer como resultado requerido
    * @throws ExcepcionPersonalizada 
*/
@Service
public class OperativaServceImpl implements OperativaService {
    
    // Función que implementa la lógica para obtener los resultados requeridos
    @Override
    public Integer logicaOperativa(Integer x, Integer y, Integer n) throws ExcepcionPersonalizada {
        // Nos aseguramos de que los parámetros de entrada no son null. Si los son devolvemos la excepción
        if (x != null && y != null && n != null) {
            // Nos aseguramos que los datos de entrada cumplen lo exigido
            Integer result = IntStream.rangeClosed(0, n).filter((value) -> value % x == y).max().orElseThrow(() -> new ExcepcionPersonalizada("No existe ningún valor que cumpla las condiciiones"));
        
            //System.out.println("(x:" + x + ", y:" + y + ", n:" + n + ") = " + result );

            return result;
        }

        throw new IllegalArgumentException("Uno o varios de los parámetros de entrada se están mandando vacíos");
    }
}
