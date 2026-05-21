package com.biblioteca.inclusiva.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class PerfilDtoRequest {
    @NotBlank(message = "É preciso informar o tipo de deficiencia.")
    @Schema(description = "Tipo de deficiencia", example = "Deficiente Auditivo")
    private String tipoDeficiencia;
    @NotBlank(message = "É preciso informar o formato preferido.")
    @Schema(description = "Formato de livro escolhido de acordo com a preferencia do usuario",
            example = "Braille")
    private String formatoPreferido;
    @Schema(description = "Observações específicas", example = "Audiobook com estimulos para pessoas autistas")
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
