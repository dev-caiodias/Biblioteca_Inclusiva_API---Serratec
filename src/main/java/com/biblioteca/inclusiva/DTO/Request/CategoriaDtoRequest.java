package com.biblioteca.inclusiva.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para criar ou atualizar uma planilha")

public class CategoriaDtoRequest { //recebe dados, ele faz um put ou um post

    @NotBlank(message = "A mensagem é obrigatória.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Schema(description = "Nome da categoria")
    private String nome;

    @Size(max = 200, message = "A descrição deve ter no máximo 200 caracteres.")
    @Schema(description = "Descrição da categoria")
    private String descricao;

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
