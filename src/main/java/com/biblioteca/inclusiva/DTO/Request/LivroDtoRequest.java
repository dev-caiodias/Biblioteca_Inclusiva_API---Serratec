package com.biblioteca.inclusiva.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public class LivroDtoRequest {

    @NotBlank(message = "O titulo do livro não pode ser nulo.")
    @Schema(description = "Título do livro", example = "Chocolate quente às quintas feiras")
    private String titulo;
    @NotBlank(message = "O nome do autor não pode ser nulo.")
    @Schema(description = "Nome do autor", example = "Michiko Aoyama")
    private String autor;
    @NotBlank(message = "Isbn não pode ser nulo.")
    @Size(max = 13)
    @Schema(description = "International Standard Book Number")
    private String isbn;
    @Positive
    @Schema(description = "Quantidade de exemplares", example = "60")
    private int qtdExemplares;
    @Schema(description = "Formato de livro", example = "Audiobook")
    private String formato;
    @Schema(description = "IDs das categorias dos livros", example = "1")
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
