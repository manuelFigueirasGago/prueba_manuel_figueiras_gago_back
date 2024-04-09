package com.prueba.prueba.controller;

import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.model.OperativaRequestBody;
import com.prueba.prueba.services.OperativaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/operativa")
public class OperativaController {

    @Autowired
    private OperativaService operativaService;

    public OperativaController(OperativaService operativaService) {
        this.operativaService = operativaService;
    }

    /**
     * 
     * @param x
     * @param y
     * @param n
     * @return ResponseEntity como resultado requerido
     * @throws Exception 
     */
    @GetMapping()
    @Operation(summary = "Función que dados tres números enteros x,y,n encuentra el entero máximo k tal que 0 <= k <= n (que k mod x = y)")
    @ApiResponse(responseCode = "200", description = "Función que datos tres números enteros x,y,n encuentra el entero máximo k tal que 0 <= k <= n (que k mod x = y)", 
        content=@Content(mediaType = "application/json", 
        schema = @Schema(implementation = OperativaController.class)))
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Integer> operacion(@RequestParam (required = false) Integer x, @RequestParam (required = false) Integer y, @RequestParam (required = false) Integer n) throws Exception {
        // Verificar el estado de autenticación del usuario
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // El usuario está autenticado
            // Realiza las operaciones necesarias
        } else {
            // El usuario no está autenticado
            // Puede manejar este caso de acuerdo a tus requerimientos
        }
        
        try {
            if (x != null && y != null && n != null) {
                Integer resultado = operativaService.logicaOperativa(x, y, n);
    
                //System.out.println("Resultado de x=" + x + ", y="+ y + "n=" + n + " es " + a);
    
                return ResponseEntity.status(HttpStatus.OK).body(resultado);
            }
    
            throw new IllegalArgumentException("Uno o varios de los parámetros de entrada se están mandando vacíos");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (Exception e) {
            throw new Exception("Se ha producido un error al procesar la petición");
        }
        
    }
    
    /**
     * 
     * @param operativaRequest
     * @return Integer como resultado requerido
     * @throws Exception 
     */
    @PostMapping()
    @Operation(summary = "Función que dados tres números enteros x,y,n encuentra el entero máximo k tal que 0 <= k <= n (que k mod x = y)")
    @ApiResponse(responseCode = "200", description = "Función que datos tres números enteros x,y,n encuentra el entero máximo k tal que 0 <= k <= n (que k mod x = y)", 
        content=@Content(mediaType = "application/json", 
        schema = @Schema(implementation = OperativaController.class)))
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Integer> operacion(@RequestBody OperativaRequestBody operativaRequest) throws Exception {
        try {
            // Obtenemos los parámetros de entrada
            Integer x = operativaRequest.getX();
            Integer y = operativaRequest.getY();
            Integer n = operativaRequest.getN();

            // Llamamos a la lógica de negocio
            return ResponseEntity.status(HttpStatus.OK).body(operativaService.logicaOperativa(x, y, n));
    
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (Exception e) {
            throw new Exception("Se ha producido un error al procesar la petición");
        }
    }
}
