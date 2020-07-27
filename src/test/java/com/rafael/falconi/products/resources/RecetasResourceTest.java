package com.rafael.falconi.products.resources;

import com.rafael.falconi.products.documents.Categoria;
import com.rafael.falconi.products.documents.Ingredientes;
import com.rafael.falconi.products.documents.Receta;
import com.rafael.falconi.products.documents.Resenia;
import com.rafael.falconi.products.resource.RestService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class RecetasResourceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private Ingredientes ingredientes;
    private Resenia resenia;
    private Receta receta;
    private Categoria categoria;

    @Before
    public void before(){
        this.ingredientes= new Ingredientes("1","leche");
        this.resenia=new Resenia("1","foto", "informacion");
        List<Ingredientes> ingredientes= new ArrayList<Ingredientes>();
        ingredientes.add(this.ingredientes);
        List<Resenia> resenias= new ArrayList<Resenia>();
        resenias.add(this.resenia);
        this.receta= new Receta("1",ingredientes,resenias,"receta","foto");
        List<Receta> recetas= new ArrayList<Receta>();
        recetas.add(this.receta);
        this.categoria= new Categoria();
        this.categoria.setId("1");
        this.categoria.setFoto("foto");
        this.categoria.setName("name");
        this.categoria.setRecetas(recetas);
    }
    @Test
    public void createCategoria() {
        restService.restBuilder().path(RecetasResource.CATEGORIAS).body(this.categoria).post().build();
    }

    @Test
    public void createReceta() {
        restService.restBuilder().path(RecetasResource.CATEGORIAS).path(RecetasResource.RECETAS).body(this.receta).post().build();
    }


}