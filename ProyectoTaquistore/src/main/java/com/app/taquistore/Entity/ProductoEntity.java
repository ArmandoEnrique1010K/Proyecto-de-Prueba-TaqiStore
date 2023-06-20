package com.app.taquistore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Table(name = "tabla_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_id_producto", nullable = false)
    private Long id_producto;
    
    @Column(name = "C_nombre_producto", nullable = false, length = 200)
    private String nombre_producto;
    
    @Column(name = "C_descripcion_producto", nullable = false, length = 1500)
    private String descripcion_producto;
    
    @Column(name = "C_precio_producto", nullable = false)
    private Double precio_producto;
    
    @Column(name = "C_estado_producto", nullable = false)
    private Boolean estado_producto;
    
    @ManyToOne
    @JoinColumn(name = "C_id_categoria", nullable = false, referencedColumnName = "C_id_categoria")
    private CategoriaEntity id_categoria_producto;
}
