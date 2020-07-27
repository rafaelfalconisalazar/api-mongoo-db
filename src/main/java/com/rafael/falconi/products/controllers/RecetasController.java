package com.rafael.falconi.products.controllers;

import com.rafael.falconi.products.documents.Categoria;
import com.rafael.falconi.products.documents.Receta;
import com.rafael.falconi.products.documents.Resenia;
import com.rafael.falconi.products.repositories.CategoriaRepository;
import com.rafael.falconi.products.repositories.RecetaRepository;
import com.rafael.falconi.products.repositories.ReseniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RecetasController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private RecetaRepository recetaRepository;
    @Autowired
    private ReseniaRepository reseniaRepository;

    public void createCategoria(Categoria categoria){
        this.categoriaRepository.save(categoria);
    }

    public List<Categoria> readAllCategorias(){
        return this.categoriaRepository.findAll();
    }

    public Categoria readAllRecetas(String id){
        Categoria categoriadb= this.categoriaRepository.findOne(id);
        Categoria categoria = new Categoria();
        categoria.setRecetas(categoriadb.getRecetas());
        return  categoria;
    }

    public void createRecetas(Receta receta){
        this.recetaRepository.save(receta);
    }

    public Receta readReceta(String id){
        return this.recetaRepository.findOne(id);
    }



}
