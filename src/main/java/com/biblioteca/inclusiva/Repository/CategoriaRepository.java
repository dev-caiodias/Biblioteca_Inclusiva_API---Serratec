package com.biblioteca.inclusiva.Repository;

import com.biblioteca.inclusiva.Domain.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
}
