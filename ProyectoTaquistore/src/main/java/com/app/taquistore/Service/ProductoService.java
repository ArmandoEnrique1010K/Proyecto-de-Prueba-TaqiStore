package com.app.taquistore.Service;

import com.app.taquistore.Dto.ProductoDto;
import java.util.List;

public interface ProductoService {
    
    public List<ProductoDto> listarTodosLosProductos();
    
    public ProductoDto listarUnProducto(Long id_producto);
    
    public ProductoDto crearProducto(ProductoDto objetoproducto);
    
    public ProductoDto actualizarProducto(ProductoDto objetoproducto);
    
    public void eliminarProducto(Long id_producto);
    
    public List<ProductoDto> listarporEstadoTrue(Boolean estado_producto);
    
}
