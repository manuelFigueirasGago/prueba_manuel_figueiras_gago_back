package com.prueba.prueba.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto utilizado para tratar el objeto de entrada en funciones de la operativa implementada
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class OperativaRequestBody {
    private Integer x;
    private Integer y;
    private Integer n;
}
