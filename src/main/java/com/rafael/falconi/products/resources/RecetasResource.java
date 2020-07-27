package com.rafael.falconi.products.resources;

import com.rafael.falconi.products.controllers.RecetasController;
import com.rafael.falconi.products.documents.Categoria;
import com.rafael.falconi.products.documents.Receta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RecetasResource.CATEGORIAS)
public class RecetasResource {
    public static final String RECETAS = "/recetas";
    public static final String CATEGORIAS = "/categorias";
    public static final String ID = "/{id}";

    @Autowired
    private RecetasController recetasController;

    @PostMapping
    public void createCategoria(@Valid @RequestBody Categoria categoria){
        this.recetasController.createCategoria(categoria);
    }

    @PostMapping(value =RECETAS)
    public void createReceta(@Valid @RequestBody Receta receta){
        this.recetasController.createRecetas(receta);
    }

    @GetMapping()
    public List<Categoria> todasLasCategorias(){
        return this.recetasController.readAllCategorias();
    }
    @GetMapping(value = RECETAS+ID)
    public Receta readReceta(@PathVariable String id){
        return this.recetasController.readReceta(id);
    }

    @GetMapping(value = ID)
    public Categoria categoriaPorId(@PathVariable String id){
        return this.recetasController.readAllRecetas(id);
    }

}
