package com.biblioteca.inclusiva.DTO.Response;
import com.biblioteca.inclusiva.Domain.Entidades.Usuario;

import java.time.LocalDateTime;

public class UsuarioDtoResponse {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private PerfilDtoResponse perfilAcessibilidade;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UsuarioDtoResponse() {
    }

    public UsuarioDtoResponse( Usuario u){
        this.id = u.getId();
        this.nome = u.getNome();
        this.telefone = u.getTelefone();
        this.createdAt = u.getCreatedAt();
        this.updatedAt = u.getUpdatedAt();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilDtoResponse getPerfilAcessibilidade() {
        return perfilAcessibilidade;
    }

    public void setPerfilAcessibilidade(PerfilDtoResponse perfilAcessibilidade) {
        this.perfilAcessibilidade = perfilAcessibilidade;
    }
}
