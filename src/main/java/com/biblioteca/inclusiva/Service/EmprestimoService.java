
package com.biblioteca.inclusiva.Service;

import com.biblioteca.inclusiva.DTO.Request.EmprestimoDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.EmprestimoDtoResponse;
import com.biblioteca.inclusiva.Domain.Emprestimo;
import com.biblioteca.inclusiva.Domain.Enums.StatusEmprestimo;
import com.biblioteca.inclusiva.Domain.Livro;
import com.biblioteca.inclusiva.Domain.Usuario;
import com.biblioteca.inclusiva.Exception.ResourceNotFoundException;
import com.biblioteca.inclusiva.Repository.EmprestimoRepository;
import com.biblioteca.inclusiva.Repository.LivroRepository;
import com.biblioteca.inclusiva.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LivroRepository livroRepository;

    public Emprestimo toEmprestimo(EmprestimoDtoRequest request){
        Emprestimo emprestimo = new Emprestimo();

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(request.getLivroId())
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));

        emprestimo.setDataPrevistaDevolucao(request.getDataPrevistaDevolucao());
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataPrevistaDevolucao(request.getDataPrevistaDevolucao());
        emprestimo.setStatus(StatusEmprestimo.ATIVO);
        emprestimo.setDataEmprestimo(LocalDate.now());

        return emprestimo;
    }

    public EmprestimoDtoResponse toEmprestimoResponse (Emprestimo emprestimo){
        return new EmprestimoDtoResponse(emprestimo);
    }

    public List<EmprestimoDtoResponse> listarTodos(){
        List<Emprestimo> emprestimo = emprestimoRepository.findAll();
        return emprestimo.stream().map(this :: toEmprestimoResponse).toList();
    }

    public EmprestimoDtoResponse criar (EmprestimoDtoRequest request){
        Emprestimo emprestimo = toEmprestimo(request);
        int ativos = emprestimoRepository.countByUsuarioIdAndStatus(request.getUsuarioId(), StatusEmprestimo.ATIVO);

        if(emprestimo.getLivro().getQtdExemplares() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro sem exemplares disponíveis.");
        }

        if (ativos >= 3){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuário já possui 3 empréstimos ativos.");
        }

        Livro livro = emprestimo.getLivro();
        livro.setQtdExemplares(livro.getQtdExemplares() - 1);
        livroRepository.save(livro);

        return toEmprestimoResponse(emprestimoRepository.save(emprestimo));
    }

    public EmprestimoDtoResponse atualizar(Long id, EmprestimoDtoRequest request){
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));

        emprestimo.setDataDevolucao(request.get);
    }

}
