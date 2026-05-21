package com.biblioteca.inclusiva.DTO.Response;

import com.biblioteca.inclusiva.Domain.Entidades.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class CategoriaDtoResponse { // é o objeto que VOLTA para o cliente
    @Schema(description = "ID da categoria")
    private Long id;

    @Schema(description = "Nome da categoria")
    private String nome;

    @Schema(description = "Descrição da categoria")
    private String descricao;

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public CategoriaDtoResponse() {
    }

    public CategoriaDtoResponse(Categoria c){
        this.id = c.getId();
        this.nome = c.getNome();
        this.descricao = c.getDescricao();
        this.createAt = c.getCreatedAt();
        this.updatedAt = c.getUpdatedAt();
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
