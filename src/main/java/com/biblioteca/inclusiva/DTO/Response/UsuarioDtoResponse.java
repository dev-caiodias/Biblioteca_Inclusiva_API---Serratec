package com.biblioteca.inclusiva.DTO.Response;
import com.biblioteca.inclusiva.Domain.Entidades.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class UsuarioDtoResponse {
    @Schema(description = "ID do usuário")
    private Long id;
    @Schema(description = "Nome do usuario")
    private String nome;
    @Schema(description = "Telefone do usuario")
    private String telefone;
    @Schema(description = "Email do usuario")
    private String email;
    @Schema(description = "Qual tipo de perfil de acessibilidade o usuario se encaixa")
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
