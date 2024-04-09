package com.prueba.prueba.services;

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
public interface OperativaService {
    public Integer logicaOperativa(Integer x, Integer y, Integer n)  throws ExcepcionPersonalizada;    
}
