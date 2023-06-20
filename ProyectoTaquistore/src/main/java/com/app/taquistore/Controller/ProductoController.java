package com.app.taquistore.Controller;

import com.app.taquistore.Dto.ProductoDto;
import com.app.taquistore.Entity.ProductoEntity;
import com.app.taquistore.Service.CategoriaService;
import com.app.taquistore.Service.ProductoCategoriaService;
import com.app.taquistore.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoservicio;
    
    @Autowired
    private CategoriaService categoriaservicio;
    
    ///////////////
    @Autowired
    private ProductoCategoriaService productocategoriaservicio;
    ///////////////
    
    @RequestMapping
    public String mostrarproductos(Model modelo, @Param("palabraClave") String palabraClave) {
        // var varproductos = productoservicio.listarTodosLosProductos();
        // var varproductos = productoservicio.listarporEstadoTrue(Boolean.TRUE);
        // var varproductos = productocategoriaservicio.listaGeneraldeProductosTaqiStore(Boolean.TRUE, Boolean.TRUE);
        // String palabraClave = "Laptop";
        var varproductos = productocategoriaservicio.barraDeBusquedadeProductosTaqiStore(Boolean.TRUE, Boolean.TRUE, palabraClave);
        modelo.addAttribute("lista_productos", varproductos);
        modelo.addAttribute("palabraClave", palabraClave);
        return "productos.html";
    }

    @GetMapping("/detalles/{id_producto}")
    public String mostrarunproducto(@PathVariable Long id_producto, Model modelo) {
        var varunproducto = productoservicio.listarUnProducto(id_producto);
        modelo.addAttribute("caracteristicas_producto", varunproducto);
        return "plantillaunproducto.html";
    }

    @GetMapping("/nuevo")
    public String mostrarformularioderegistrarproducto(Model modelo1, Model modelo2) {
        ProductoEntity productoEntity = new ProductoEntity();
        modelo1.addAttribute("datos_producto", productoEntity);
        
        // var varcategorias = categoriaservicio.listarTodasLasCategorias();
        var varcategorias = categoriaservicio.listarPorEstadoTrue(Boolean.TRUE);
        modelo2.addAttribute("lista_categorias", varcategorias);
        return "formularioproducto.html";
    }

    @PostMapping
    public String guardarproducto(@ModelAttribute("datos_producto") ProductoDto objetoproducto) {
        productoservicio.crearProducto(objetoproducto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id_producto}")
    public String mostrarformulariodeeditarproducto(@PathVariable Long id_producto, Model modelo1, Model modelo2) {
        var varunproducto = productoservicio.listarUnProducto(id_producto);
        modelo1.addAttribute("parametros_producto", varunproducto);
        
        // var varcategorias = categoriaservicio.listarTodasLasCategorias();
        var varcategorias = categoriaservicio.listarPorEstadoTrue(Boolean.TRUE);
        modelo2.addAttribute("categoria_actual", varcategorias);
        return "formularioeditarproducto.html";
    }

    @PostMapping("/{id_producto}")
    public String actualizarelproductoseleccionado(@PathVariable Long id_producto, @ModelAttribute("parametros_producto") ProductoDto productoeditado) {
        productoservicio.actualizarProducto(productoeditado);
        return "redirect:/productos";
    }
    
    @GetMapping("/eliminar/{id_producto}")
    public String eliminarelproducto(@PathVariable Long id_producto){
        productoservicio.eliminarProducto(id_producto);
        return "redirect:/productos";
    }
    
}
