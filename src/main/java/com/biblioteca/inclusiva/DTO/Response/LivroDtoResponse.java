package com.biblioteca.inclusiva.DTO.Response;

import com.biblioteca.inclusiva.Domain.Livro;

import java.util.List;

public class LivroDtoResponse {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private int qtdExemplares;

    private String formato;
    private List<CategoriaDtoResponse> categorias;

    public LivroDtoResponse() {
    }

    public LivroDtoResponse (Livro l){
        this.id = l.getId();
        this.titulo = l.getTitulo();
        this.autor = l.getAutor();
        this.isbn = l.getIsbn();
        this.qtdExemplares = l.getQtdExemplares();
        this.formato = l.getFormato();
        this.categorias = l.getCategorias()
                .stream().map(categorias -> new CategoriaDtoResponse(categorias))
                .toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdExemplares(int qtdExemplares) {
        this.qtdExemplares = qtdExemplares;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Long> getCategoriaIds() {
        return categoriaIds;
    }

    public void setCategoriaIds(List<Long> categoriaIds) {
        this.categoriaIds = categoriaIds;
    }

    public List<CategoriaDtoResponse> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaDtoResponse> categorias) {
        this.categorias = categorias;
    }
}
