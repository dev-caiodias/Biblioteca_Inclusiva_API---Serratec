
package com.biblioteca.inclusiva.DTO.Request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmprestimoDtoRequest {

    @NotNull(message = "O id do usuário não pode ser nulo.")
    private Long usuarioId;
    @NotNull(message = "O id do livro não pode ser nulo.")
    private Long livroId;
    @Future
    private LocalDate dataPrevistaDevolucao;

    private

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
