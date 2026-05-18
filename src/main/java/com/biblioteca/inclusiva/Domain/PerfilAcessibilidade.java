package com.biblioteca.inclusiva.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "perfis_acessibilidade")
public class PerfilAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoDeficiencia;

    @Column(nullable = false)
    private String formatoPreferido;

    @Column
    private String observacoes;

    @OneToOne(mappedBy = "perfilAcessibilidade")
    @JsonIgnore
    private Usuario usuario;

    public PerfilAcessibilidade() {
    }

    public PerfilAcessibilidade(Long id, String tipoDeficiencia, String formatoPreferido, String observacoes, Usuario usuario) {
        this.id = id;
        this.tipoDeficiencia = tipoDeficiencia;
        this.formatoPreferido = formatoPreferido;
        this.observacoes = observacoes;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
