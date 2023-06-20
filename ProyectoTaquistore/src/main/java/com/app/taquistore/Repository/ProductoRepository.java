package com.app.taquistore.Repository;

import com.app.taquistore.Entity.ProductoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
    @Query(value = "select x from ProductoEntity x where x.estado_producto = true")
    List<ProductoEntity> listarPorEstadoTrue(Boolean estado_producto);

}
