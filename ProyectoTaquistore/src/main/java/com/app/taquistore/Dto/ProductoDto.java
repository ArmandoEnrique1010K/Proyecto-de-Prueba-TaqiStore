package com.app.taquistore.Dto;

import com.app.taquistore.Entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private Double precio_producto;
    private Boolean estado_producto;
    private CategoriaEntity id_categoria_producto;
}
