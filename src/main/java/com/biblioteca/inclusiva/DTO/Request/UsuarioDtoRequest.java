package com.biblioteca.inclusiva.DTO.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UsuarioDtoRequest {

    @NotBlank(message = "Preencha um nome.")
    private String nome;

    @Email @NotBlank(message = "Preencha o email.")
    private String email;

    @Pattern(regexp = "\\d{10,11}")
    private String telefone;

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
}
