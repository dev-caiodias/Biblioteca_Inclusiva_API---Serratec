package com.biblioteca.inclusiva.Service;

import com.biblioteca.inclusiva.DTO.Request.CategoriaDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.CategoriaDtoResponse;
import com.biblioteca.inclusiva.Domain.Categoria;
import com.biblioteca.inclusiva.Exception.ResourceNotFoundException;
import com.biblioteca.inclusiva.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static Categoria toCategoria(CategoriaDtoRequest request){
        Categoria categoria = new Categoria();
        categoria.setNome(request.getNome());
        categoria.setDescricao(request.getDescricao());

        return categoria;
    }

    public static CategoriaDtoResponse toCategoriaResponse(Categoria categoria){
        CategoriaDtoResponse response = new CategoriaDtoResponse();
        response.setId(categoria.getId());
        response.setNome(categoria.getNome());
        response.setDescricao(categoria.getDescricao());

        return response;
    }

    public List <CategoriaDtoResponse> listarTodos(){

        List<Categoria> categorias = categoriaRepository.findAll();

        return categorias.stream().map(CategoriaService :: toCategoriaResponse).toList();
    }


    public CategoriaDtoResponse buscarPorId (Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + id));

        return toCategoriaResponse(categoria);
    }

    public CategoriaDtoResponse criar(CategoriaDtoRequest request){
         return toCategoriaResponse(categoriaRepository.save(toCategoria(request)));
    }

    public CategoriaDtoResponse atualizar(Long id, CategoriaDtoRequest request){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        categoria.setNome(request.getNome());
        categoria.setDescricao(request.getDescricao());

        return toCategoriaResponse(categoriaRepository.save(categoria));
    }

    public void deletar(Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        categoriaRepository.deleteById(id);
    }

}
