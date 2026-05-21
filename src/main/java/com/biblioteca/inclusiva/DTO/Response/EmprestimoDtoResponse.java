package com.biblioteca.inclusiva.DTO.Response;

import com.biblioteca.inclusiva.Domain.Entidades.Emprestimo;
import com.biblioteca.inclusiva.Domain.Enums.StatusEmprestimo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmprestimoDtoResponse {

    private Long id;
    private StatusEmprestimo status;
    private String usuarioNome;
    private String livroTitulo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private LocalDate dataEmprestimo;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EmprestimoDtoResponse() {
    }

    public EmprestimoDtoResponse (Emprestimo e){
        this.id = e.getId();
        this.usuarioNome = e.getUsuario().getNome();
        this.livroTitulo = e.getLivro().getTitulo();
        this.status = e.getStatus();
        this.dataEmprestimo = e.getDataEmprestimo();
        this.dataPrevistaDevolucao = e.getDataPrevistaDevolucao();
        this.dataDevolucao = e.getDataDevolucao();
        this.createdAt = e.getCreatedAt();
        this.updatedAt = e.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getLivroTitulo() {
        return livroTitulo;
    }

    public void setLivroTitulo(String livroTitulo) {
        this.livroTitulo = livroTitulo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
