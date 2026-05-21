
package com.biblioteca.inclusiva.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmprestimoDtoRequest {

    @NotNull(message = "O id do usuário não pode ser nulo.")
    @Schema(description = "Id do usuario", example = "1")
    private Long usuarioId;
    @NotNull(message = "O id do livro não pode ser nulo.")
    @Schema(description = "Id do livro", example = "1")
    private Long livroId;
    @Future
    @Schema(description = "Data de possivel devolução", example = "11-07-26")
    private LocalDate dataPrevistaDevolucao;
    public EmprestimoDtoRequest() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
}
