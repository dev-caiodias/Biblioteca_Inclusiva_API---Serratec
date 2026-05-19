package com.biblioteca.inclusiva.DTO.Response;

import com.biblioteca.inclusiva.Domain.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriaDtoResponse { // é o objeto que VOLTA para o cliente
    @Schema(description = "ID da categoria")
    private Long id;

    @Schema(description = "Nome da categoria")
    private String nome;

    @Schema(description = "Descrição da categoria")
    private String descricao;

    public CategoriaDtoResponse() {
    }

    public CategoriaDtoResponse(Categoria c){
        this.id = c.getId();
        this.nome = c.getNome();
        this.descricao = c.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
