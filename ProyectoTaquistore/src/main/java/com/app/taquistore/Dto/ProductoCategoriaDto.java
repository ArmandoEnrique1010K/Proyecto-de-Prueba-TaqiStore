package com.app.taquistore.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCategoriaDto {

    private Long id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;
    private Boolean estado_categoria;
    
    private Long id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Double precio_producto;
    private Boolean estado_producto;

}
