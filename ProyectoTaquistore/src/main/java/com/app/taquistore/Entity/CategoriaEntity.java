package com.app.taquistore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Table(name = "tabla_categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_id_categoria", nullable = false)
    private Long id_categoria;
    
    @Column(name = "C_nombre_categoria", nullable = false, length = 100)
    private String nombre_categoria;
    
    @Column(name = "C_descripcion_categoria", nullable = false, length = 1000)
    private String descripcion_categoria;

    @Column(name = "C_estado_categoria", nullable = false)
    private Boolean estado_categoria;
        
}
