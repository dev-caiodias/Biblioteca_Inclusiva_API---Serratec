package com.biblioteca.inclusiva.Repository;

import com.biblioteca.inclusiva.Domain.PerfilAcessibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository <PerfilAcessibilidade, Long> {
}
