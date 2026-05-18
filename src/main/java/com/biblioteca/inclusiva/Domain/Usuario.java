package com.biblioteca.inclusiva.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "perfil_acessibilidade_id")
    private PerfilAcessibilidade perfilAcessibilidade;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Emprestimo> emprestimos = new ArrayList<>();

}
