package com.biblioteca.inclusiva.Repository;

import com.biblioteca.inclusiva.Domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByCategorias_Id(Long categoriaId); //retorna o livro com o respectivo id

    List<Livro> findByQtdExemplaresGreaterThan(int quantidade); // retorna só os livros com estoque
}
