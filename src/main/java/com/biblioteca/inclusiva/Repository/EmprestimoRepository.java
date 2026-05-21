package com.biblioteca.inclusiva.Repository;

import com.biblioteca.inclusiva.Domain.Emprestimo;
import com.biblioteca.inclusiva.Domain.Enums.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository <Emprestimo, Long> {
    int countByUsuarioIdAndStatus (Long id, StatusEmprestimo status); // conta quantos emprestimos ativos tem
}
