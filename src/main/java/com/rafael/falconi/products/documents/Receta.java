package com.rafael.falconi.products.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Receta {
    @Id
    private String id;

    private List<Ingredientes> ingredientes;

    private List<Resenia> resenias;

    private String instruccion,foto;

    public Receta() {
    }

    public Receta(String id, List<Ingredientes> ingredientes, List<Resenia> resenias, String instruccion,String foto) {
        this.id = id;
        this.ingredientes = ingredientes;
        this.resenias = resenias;
        this.instruccion = instruccion;
        this.foto=foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
