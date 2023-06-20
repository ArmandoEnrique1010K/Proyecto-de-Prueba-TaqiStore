package com.app.taquistore.Service;

import com.app.taquistore.Dto.ProductoCategoriaDto;
import com.app.taquistore.Entity.ProductoEntity;
import com.app.taquistore.Repository.ProductoCategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.Normalizer;
import java.util.regex.Pattern;

@Service
public class ProductoCategoriaServiceImpl implements ProductoCategoriaService{
    @Autowired
    private ProductoCategoriaRepository productocategoriarepositorio;

    @Override
    public List<ProductoCategoriaDto> listaGeneraldeProductosTaqiStore(Boolean estado_producto, Boolean estado_categoria) {
        List<ProductoEntity> listProductoEntity = productocategoriarepositorio.listaGeneraldeProductosTaqiStore(Boolean.TRUE, Boolean.TRUE);
        List<ProductoCategoriaDto> list = new ArrayList<>();
        for (ProductoEntity productoEntity : listProductoEntity){
            list.add(ProductoCategoriaDto.builder()
                    .id_producto(productoEntity.getId_producto())
                    .nombre_producto(productoEntity.getNombre_producto())
                    .descripcion_producto(productoEntity.getDescripcion_producto())
                    .precio_producto(productoEntity.getPrecio_producto())
                    .estado_producto(productoEntity.getEstado_producto())
                    
                    .id_categoria(productoEntity.getId_categoria_producto().getId_categoria())
                    .nombre_categoria(productoEntity.getId_categoria_producto().getNombre_categoria())
                    .descripcion_categoria(productoEntity.getId_categoria_producto().getDescripcion_categoria())
                    .estado_categoria(productoEntity.getId_categoria_producto().getEstado_categoria())
                    .build());
        }
        return list;
    }

    @Override
    public List<ProductoCategoriaDto> barraDeBusquedadeProductosTaqiStore(Boolean estado_producto, Boolean estado_categoria, String palabraClave) {
        List<ProductoEntity> listProductoEntity = productocategoriarepositorio.listaGeneraldeProductosTaqiStore(Boolean.TRUE, Boolean.TRUE);
        List<ProductoCategoriaDto> resultList = new ArrayList<>();
        // TODOS LOS PRODUCTOS DE LA LISTA
        for (ProductoEntity productoEntity : listProductoEntity){
            ProductoCategoriaDto productoCategoriaDto = ProductoCategoriaDto.builder()
                    .id_producto(productoEntity.getId_producto())
                    .nombre_producto(productoEntity.getNombre_producto())
                    .descripcion_producto(productoEntity.getDescripcion_producto())
                    .precio_producto(productoEntity.getPrecio_producto())
                    .estado_producto(productoEntity.getEstado_producto())
                    
                    .id_categoria(productoEntity.getId_categoria_producto().getId_categoria())
                    .nombre_categoria(productoEntity.getId_categoria_producto().getNombre_categoria())
                    .descripcion_categoria(productoEntity.getId_categoria_producto().getDescripcion_categoria())
                    .estado_categoria(productoEntity.getId_categoria_producto().getEstado_categoria())
                    .build();
            resultList.add(productoCategoriaDto);
        }
        // RESULTADOS FILTRADOS
        if (palabraClave != null && !palabraClave.isEmpty()) {
            List<ProductoCategoriaDto> filteredList = new ArrayList<>();
            String palabraClaveNormalizada = normalizarPalabraClave(palabraClave);
            for (ProductoCategoriaDto productoCategoriaDto : resultList) {
                String nombreProducto = normalizarPalabraClave(productoCategoriaDto.getNombre_producto());
                String descripcionProducto = normalizarPalabraClave(productoCategoriaDto.getDescripcion_producto());
                String precioProducto = normalizarPalabraClave(productoCategoriaDto.getPrecio_producto().toString());
                String categoriaProducto = normalizarPalabraClave(productoCategoriaDto.getNombre_categoria());

                if (nombreProducto.contains(palabraClaveNormalizada) || descripcionProducto.contains(palabraClaveNormalizada) 
                        || precioProducto.contains(palabraClaveNormalizada) || categoriaProducto.contains(palabraClaveNormalizada)){
                    filteredList.add(productoCategoriaDto);
                }
            }
            return filteredList;
        }
        return resultList;
    }
    
    private String normalizarPalabraClave(String palabraClave) {
        String normalized = Normalizer.normalize(palabraClave, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
    }
}
