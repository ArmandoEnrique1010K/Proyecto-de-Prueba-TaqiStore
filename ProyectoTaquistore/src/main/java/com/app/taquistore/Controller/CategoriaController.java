package com.app.taquistore.Controller;

import com.app.taquistore.Dto.CategoriaDto;
import com.app.taquistore.Entity.CategoriaEntity;
import com.app.taquistore.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaservicio;
    
    @GetMapping
    public String mostrarcategorias(Model modelo) {
        // var varcategorias = categoriaservicio.listarTodasLasCategorias();
        var varcategorias = categoriaservicio.listarPorEstadoTrue(Boolean.TRUE);
        modelo.addAttribute("lista_categorias", varcategorias);
        return "categorias.html";
    }

    @GetMapping("/detalles/{id_categoria}")
    public String mostrarunacategoria(@PathVariable Long id_categoria, Model modelo) {
        var varunacategoria = categoriaservicio.listarUnaCategoria(id_categoria);
        modelo.addAttribute("caracteristicas_categoria", varunacategoria);
        return "plantillaunacategoria.html";
    }

    // MODIFICAR LOS CONTROLADORES PARA UNIR LAS 2 PÁGINAS WEB
    @GetMapping("/nuevo")
    public String mostrarformularioderegistrarcategoria(Model modelo) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        modelo.addAttribute("datos_categoria", categoriaEntity);
        // return "formulariocategoria.html";
        return "formcategoria.html";
    }

    @PostMapping
    public String guardarcategoria(@ModelAttribute("datos_categoria") CategoriaDto objetocategoria) {
        categoriaservicio.crearCategoria(objetocategoria);
        return "redirect:/categorias";
    }
    
    @GetMapping("/editar/{id_categoria}")
    public String mostrarformulariodeeditarcategoria(@PathVariable Long id_categoria, Model modelo) {
        var varunacategoria = categoriaservicio.listarUnaCategoria(id_categoria);
        // modelo.addAttribute("parametros_categoria", varunacategoria);
        modelo.addAttribute("datos_categoria", varunacategoria);
        // return "formularioeditarcategoria.html";
        return "formcategoria.html";
    }
    
    @PostMapping("/{id_categoria}")
    // public String actualizarelcategoriaseleccionado(@PathVariable Long id_categoria, @ModelAttribute("parametros_categoria") CategoriaDto categoriaeditado) {
    public String actualizarelcategoriaseleccionado(@PathVariable Long id_categoria, @ModelAttribute("datos_categoria") CategoriaDto categoriaeditado) {
        categoriaservicio.actualizarCategoria(categoriaeditado);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id_categoria}")
    public String eliminarelcategoria(@PathVariable Long id_categoria){
        categoriaservicio.eliminarCategoria(id_categoria);
        return "redirect:/categorias";
    }
    
    
}
