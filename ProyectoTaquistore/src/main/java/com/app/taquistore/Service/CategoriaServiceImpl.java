package com.app.taquistore.Service;

import com.app.taquistore.Dto.CategoriaDto;
import com.app.taquistore.Entity.CategoriaEntity;
import com.app.taquistore.Repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriarepositorio;
    
    @Override
    public List<CategoriaDto> listarTodasLasCategorias() {
        List<CategoriaEntity> listCategoriaEntity = categoriarepositorio.findAll();
        List<CategoriaDto> list = new ArrayList<>();
        for (CategoriaEntity categoriaEntity : listCategoriaEntity){
            list.add(CategoriaDto.builder()
                    .id_categoria(categoriaEntity.getId_categoria())
                    .nombre_categoria(categoriaEntity.getNombre_categoria())
                    .descripcion_categoria(categoriaEntity.getDescripcion_categoria())
                    .estado_categoria(categoriaEntity.getEstado_categoria())
                    .build());
        }
        return list;
    }

    @Override
    public CategoriaDto listarUnaCategoria(Long id_categoria) {
        CategoriaEntity categoriaEntity = categoriarepositorio.findById(id_categoria).orElse(null);
        CategoriaDto categoriaDto = CategoriaDto.builder()
                    .id_categoria(categoriaEntity.getId_categoria())
                    .nombre_categoria(categoriaEntity.getNombre_categoria())
                    .descripcion_categoria(categoriaEntity.getDescripcion_categoria())
                    .estado_categoria(categoriaEntity.getEstado_categoria())
                    .build();
        return categoriaDto;
    }

    @Override
    public CategoriaDto crearCategoria(CategoriaDto objetocategoria) {
        CategoriaEntity categoriaEntity = CategoriaEntity.builder()
                    .nombre_categoria(objetocategoria.getNombre_categoria())
                    .descripcion_categoria(objetocategoria.getDescripcion_categoria())
                    .estado_categoria(Boolean.TRUE)
                    .build();
        categoriarepositorio.save(categoriaEntity);
        objetocategoria.setId_categoria(categoriaEntity.getId_categoria());
        return objetocategoria;
    }

    @Override
    public CategoriaDto actualizarCategoria(CategoriaDto objetocategoria) {
        CategoriaEntity categoriaEntity = categoriarepositorio.findById(objetocategoria.getId_categoria()).orElse(null);
        categoriaEntity.setNombre_categoria(objetocategoria.getNombre_categoria());
        categoriaEntity.setDescripcion_categoria(objetocategoria.getDescripcion_categoria());
        categoriaEntity.setEstado_categoria(Boolean.TRUE);
        categoriarepositorio.save(categoriaEntity);
        return objetocategoria;
    }

    @Override
    public void eliminarCategoria(Long id_categoria) {
        CategoriaEntity categoriaEntity = categoriarepositorio.findById(id_categoria).orElse(null);
        categoriaEntity.setEstado_categoria(Boolean.FALSE);
        categoriarepositorio.save(categoriaEntity);
        
    }

    @Override
    public List<CategoriaDto> listarPorEstadoTrue(Boolean estado_categoria) {
        List<CategoriaEntity> listCategoriaEntity = categoriarepositorio.listarPorEstadoTrue(Boolean.TRUE);
        List<CategoriaDto> list = new ArrayList<>();
        for (CategoriaEntity categoriaEntity : listCategoriaEntity){
            list.add(CategoriaDto.builder()
                    .id_categoria(categoriaEntity.getId_categoria())
                    .nombre_categoria(categoriaEntity.getNombre_categoria())
                    .descripcion_categoria(categoriaEntity.getDescripcion_categoria())
                    .estado_categoria(categoriaEntity.getEstado_categoria())
                    .build());
        }
        return list;
    }
    
    
}
