package com.rafael.falconi.products.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Categoria {
    @Id
    private String id;

    private String name,foto;

    private List<Receta> recetas;

    public Categoria() {
    }

    public Categoria(String id, String name, String foto, List<Receta> recetas) {
        this.id = id;
        this.name = name;
        this.foto = foto;
        this.recetas = recetas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }


}
