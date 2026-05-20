package com.biblioteca.inclusiva.DTO.Request;

import jakarta.validation.constraints.NotBlank;

public class PerfilDtoRequest {
    @NotBlank(message = "É preciso informar o tipo de deficiencia.")
    private String tipoDeficiencia;
    @NotBlank(message = "É preciso informar o formato preferido.")
    private String formatoPreferido;
    private String observacoes;

    public PerfilDtoRequest() {
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
