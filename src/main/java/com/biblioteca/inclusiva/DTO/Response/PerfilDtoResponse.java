package com.biblioteca.inclusiva.DTO.Response;

import com.biblioteca.inclusiva.Domain.Entidades.PerfilAcessibilidade;

import java.time.LocalDateTime;

public class PerfilDtoResponse {

    private Long id;
    private String tipoDeficiencia;
    private String formatoPreferido;
    private String observacoes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PerfilDtoResponse() {
    }

    public PerfilDtoResponse (PerfilAcessibilidade p){
        this.id = p.getId();
        this.tipoDeficiencia = p.getTipoDeficiencia();
        this.formatoPreferido = p.getFormatoPreferido();
        this.observacoes = p.getObservacoes();
        this.createdAt = p.getCreatedAt();
        this.updatedAt = p.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public String getFormatoPreferido() {
        return formatoPreferido;
    }

    public void setFormatoPreferido(String formatoPreferido) {
        this.formatoPreferido = formatoPreferido;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
