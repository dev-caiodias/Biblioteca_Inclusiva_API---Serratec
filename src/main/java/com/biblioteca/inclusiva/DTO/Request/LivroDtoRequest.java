package com.biblioteca.inclusiva.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class LivroDtoRequest {

    @NotBlank(message = "O titulo do livro não pode ser nulo.")
    private String titulo;
    @NotBlank(message = "O nome do autor não pode ser nulo.")
    private String autor;
    @NotBlank(message = "Isbn não pode ser nulo.")
    private String isbn;
    @Positive
    private int qtdExemplares;

    private String formato;
    private List<Long> categoriaIds;

    public LivroDtoRequest() {
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
}
