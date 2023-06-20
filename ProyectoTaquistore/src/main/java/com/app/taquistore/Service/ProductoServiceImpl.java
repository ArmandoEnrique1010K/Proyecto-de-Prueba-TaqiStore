package com.app.taquistore.Service;

import com.app.taquistore.Dto.ProductoDto;
import com.app.taquistore.Entity.ProductoEntity;
import com.app.taquistore.Repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productorepositorio;
    
    @Override
    public List<ProductoDto> listarTodosLosProductos() {
        List<ProductoEntity> listProductoEntity = productorepositorio.findAll();
        List<ProductoDto> list = new ArrayList<>();
        for (ProductoEntity productoEntity : listProductoEntity){
            list.add(ProductoDto.builder()
                    .id_producto(productoEntity.getId_producto())
                    .nombre_producto(productoEntity.getNombre_producto())
                    .descripcion_producto(productoEntity.getDescripcion_producto())
                    .precio_producto(productoEntity.getPrecio_producto())
                    .estado_producto(productoEntity.getEstado_producto())
                    .id_categoria_producto(productoEntity.getId_categoria_producto())
                    .build());
        }
        return list;
    }

    @Override
    public ProductoDto listarUnProducto(Long id_producto) {
        ProductoEntity productoEntity = productorepositorio.findById(id_producto).orElse(null);
        ProductoDto productoDto = ProductoDto.builder()
                    .id_producto(productoEntity.getId_producto())
                    .nombre_producto(productoEntity.getNombre_producto())
                    .descripcion_producto(productoEntity.getDescripcion_producto())
                    .precio_producto(productoEntity.getPrecio_producto())
                    .estado_producto(productoEntity.getEstado_producto())
                    .id_categoria_producto(productoEntity.getId_categoria_producto())
                    .build();
        return productoDto;
    }

    @Override
    public ProductoDto crearProducto(ProductoDto objetoproducto) {
        ProductoEntity productoEntity = ProductoEntity.builder()
                .nombre_producto(objetoproducto.getNombre_producto())
                .descripcion_producto(objetoproducto.getDescripcion_producto())
                .precio_producto(objetoproducto.getPrecio_producto())
                .estado_producto(Boolean.TRUE)
                .id_categoria_producto(objetoproducto.getId_categoria_producto())
                .build();
        productorepositorio.save(productoEntity);
        objetoproducto.setId_producto(productoEntity.getId_producto());
        return objetoproducto;
    }

    @Override
    public ProductoDto actualizarProducto(ProductoDto objetoproducto) {
        ProductoEntity productoEntity = productorepositorio.findById(objetoproducto.getId_producto()).orElse(null);
        productoEntity.setNombre_producto(objetoproducto.getNombre_producto());
        productoEntity.setDescripcion_producto(objetoproducto.getDescripcion_producto());
        productoEntity.setPrecio_producto(objetoproducto.getPrecio_producto());
        productoEntity.setEstado_producto(Boolean.TRUE);
        productoEntity.setId_categoria_producto(objetoproducto.getId_categoria_producto());
        productorepositorio.save(productoEntity);
        return objetoproducto;
    }

    @Override
    public void eliminarProducto(Long id_producto) {
        ProductoEntity productoEntity = productorepositorio.findById(id_producto).orElse(null);
        productoEntity.setEstado_producto(Boolean.FALSE);
        productorepositorio.save(productoEntity);
    }

    @Override
    public List<ProductoDto> listarporEstadoTrue(Boolean estado_producto) {
        List<ProductoEntity> listProductoEntity = productorepositorio.listarPorEstadoTrue(Boolean.TRUE);
        List<ProductoDto> list = new ArrayList<>();
        for (ProductoEntity productoEntity : listProductoEntity){
            list.add(ProductoDto.builder()
                    .id_producto(productoEntity.getId_producto())
                    .nombre_producto(productoEntity.getNombre_producto())
                    .descripcion_producto(productoEntity.getDescripcion_producto())
                    .precio_producto(productoEntity.getPrecio_producto())
                    .estado_producto(productoEntity.getEstado_producto())
                    .id_categoria_producto(productoEntity.getId_categoria_producto())
                    .build());
        }
        return list;
    }

}
