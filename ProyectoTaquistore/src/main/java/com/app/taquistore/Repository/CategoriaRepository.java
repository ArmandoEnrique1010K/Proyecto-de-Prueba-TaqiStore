package com.app.taquistore.Repository;

import com.app.taquistore.Entity.CategoriaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
    @Query(value = "select x from CategoriaEntity x where x.estado_categoria = true")
    List<CategoriaEntity> listarPorEstadoTrue(Boolean estado_categoria);
    
}
