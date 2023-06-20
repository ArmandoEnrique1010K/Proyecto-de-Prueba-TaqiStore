package com.app.taquistore.Service;

import com.app.taquistore.Dto.CategoriaDto;
import java.util.List;

public interface CategoriaService {
    
    public List<CategoriaDto> listarTodasLasCategorias();
    
    public CategoriaDto listarUnaCategoria(Long id_categoria);
    
    public CategoriaDto crearCategoria(CategoriaDto objetocategoria);
    
    public CategoriaDto actualizarCategoria(CategoriaDto objetocategoria);
    
    public void eliminarCategoria(Long id_categoria);
    
    public List<CategoriaDto> listarPorEstadoTrue(Boolean estado_categoria);
}
