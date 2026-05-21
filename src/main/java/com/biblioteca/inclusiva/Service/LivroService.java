package com.biblioteca.inclusiva.Service;

import com.biblioteca.inclusiva.DTO.Request.LivroDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.LivroDtoResponse;
import com.biblioteca.inclusiva.Domain.Categoria;
import com.biblioteca.inclusiva.Domain.Livro;
import com.biblioteca.inclusiva.Exception.ResourceNotFoundException;
import com.biblioteca.inclusiva.Repository.CategoriaRepository;
import com.biblioteca.inclusiva.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Livro toLivro (LivroDtoRequest request){
        Livro livro = new Livro();
        livro.setTitulo(request.getTitulo());
        livro.setAutor(request.getAutor());
        livro.setFormato(request.getFormato());
        livro.setIsbn(request.getIsbn());
        livro.setQtdExemplares(request.getQtdExemplares());

        List <Categoria> categoria = request.getCategoriaIds()
                .stream().map(id -> categoriaRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."))).toList();
        livro.setCategorias(categoria);

        return livro;
    }

    public LivroDtoResponse toLivroResponse (Livro livro){
        return new LivroDtoResponse(livro);
    }

    public List<LivroDtoResponse> listarTodos(){
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(this :: toLivroResponse).toList();
    }

    public LivroDtoResponse buscarPorId(Long id){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado."));
        return toLivroResponse(livro);
    }

    public List<LivroDtoResponse> buscarPorCategoria(Long categoriaId){
        List<Livro> livroCategoria = livroRepository.findByCategorias_Id(categoriaId);
        return livroCategoria.stream().map(this :: toLivroResponse).toList();
    }

    public List<LivroDtoResponse> buscarDisponiveis (){
        List <Livro> livrosDisponiveis = livroRepository.findByQtdExemplaresGreaterThan(0); // retorna os livros com estoque maiores do que zero
        return livrosDisponiveis.stream().map(this :: toLivroResponse).toList();
    }

    public LivroDtoResponse criar (LivroDtoRequest request){
        Livro livro = toLivro(request);
        Livro salvo = livroRepository.save(livro);
        return toLivroResponse(salvo);
    }

    public LivroDtoResponse atualizar(Long id, LivroDtoRequest request){
        Livro livro = livroRepository .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));

        livro.setTitulo(request.getTitulo());
        livro.setAutor(request.getAutor());
        livro.setIsbn(request.getIsbn());
        livro.setFormato(request.getFormato());
        livro.setQtdExemplares(request.getQtdExemplares());

        List<Categoria> categorias = request.getCategoriaIds()
                .stream()
                .map(catId -> categoriaRepository.findById(catId)
                        .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada.")))
                .collect(Collectors.toList()); // estava dando um erro interno pois o hibernate não conseguia fazer alterações. Só o toList() retornava uma lista imutável
        livro.setCategorias(categorias);

        return toLivroResponse(livroRepository.save(livro));
    }

    public void deletar(Long id){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado."));
        livroRepository.deleteById(id);
    }
}
