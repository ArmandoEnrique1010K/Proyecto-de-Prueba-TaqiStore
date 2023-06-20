package com.app.taquistore.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Long id_categoria;
    private String nombre_categoria;
    private String descripcion_categoria;
    private Boolean estado_categoria;

}
