package com.app.taquistore.Repository;

import com.app.taquistore.Entity.ProductoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoCategoriaRepository extends JpaRepository<ProductoEntity, Long>{
    @Query(value = "SELECT p.*, q.* FROM tabla_productos p JOIN tabla_categorias q "
            + "ON p.c_id_categoria = q.c_id_categoria "
            + "WHERE p.c_estado_producto = true AND q.c_estado_categoria = true"
            , nativeQuery = true)
    List<ProductoEntity> listaGeneraldeProductosTaqiStore(Boolean estado_producto, Boolean estado_categoria);
    
    // QUERY PARA BARRA DE BUSQUEDA
    @Query(value = "SELECT p.*, q.* FROM tabla_productos p JOIN tabla_categorias q "
            + "ON p.c_id_categoria = q.c_id_categoria "
            + "WHERE p.c_estado_producto = true AND q.c_estado_categoria = true "
            + "AND CONCAT(p.c_id_producto, p.c_descripcion_producto, p.c_nombre_producto,"
            + "p.c_precio_producto, q.c_nombre_categoria) LIKE %?3%"
            , nativeQuery = true)
    public List<ProductoEntity> barraDeBusquedadeProductosTaqiStore(Boolean estado_producto, Boolean estado_categoria, String palabraClave);

}
