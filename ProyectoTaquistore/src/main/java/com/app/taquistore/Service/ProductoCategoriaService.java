package com.app.taquistore.Service;

import com.app.taquistore.Dto.ProductoCategoriaDto;
import java.util.List;

public interface ProductoCategoriaService {
    // LISTAR TODOS LOS PRODUCTOS QUE CUMPLA LA CONDICION:
    // El estado del producto sea True
    // La categoria del producto sea de una de las categorias que se encuentre en la tabla categoria y que tenga el estado True
    public List<ProductoCategoriaDto> listaGeneraldeProductosTaqiStore(Boolean estado_producto, Boolean estado_categoria);
    // BARRA DE BUSQUEDA
    public List<ProductoCategoriaDto> barraDeBusquedadeProductosTaqiStore(Boolean estado_producto, Boolean estado_categoria, String palabraClave);
}
