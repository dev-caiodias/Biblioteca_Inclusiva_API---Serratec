package com.biblioteca.inclusiva.DTO.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UsuarioDtoRequest {

    @NotBlank(message = "Preencha um nome.")
    @Schema(description = "Nome do usuario", example = "Michiko Aoyama")
    private String nome;

    @Email @NotBlank(message = "Preencha o email.")
    @Schema(description = "Email do usuario", example = "fulano@email.com")
    private String email;

    @Pattern(regexp = "\\d{10,11}")
    @Schema(description = "Telefone de contado do usuário", example = "(ddd) 00000-0000")
    private String telefone;
    @Schema(description = "ID perfil acessibilidade", example = "1")
    private Long perfilId;

    public UsuarioDtoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }
}
