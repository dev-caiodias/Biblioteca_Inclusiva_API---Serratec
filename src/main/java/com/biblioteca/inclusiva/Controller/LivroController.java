package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.LivroDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.LivroDtoResponse;
import com.biblioteca.inclusiva.Service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @GetMapping
    @Operation(summary = "Listar todos os livros", description = "Retorna uma lista com todos os livros cadastradas")
    public ResponseEntity<List<LivroDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro", description = "Retorna um livro com o determinado id")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <LivroDtoResponse> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/disponiveis")
    @Operation(summary = "Listar livros disponíveis", description = "Retorna uma lista de livros com estoques disponíveis")
    public ResponseEntity <List<LivroDtoResponse>> listarDisponiveis(){
        return ResponseEntity.ok(service.buscarDisponiveis());
    }

    @GetMapping("/categoria")
    @Operation(summary = "Buscar por categoria", description = "Retorna uma lista de livros de determinada categoria")
    public ResponseEntity <List<LivroDtoResponse>> buscarPorCategoria(@PathVariable Long categoriaId){
        return ResponseEntity.ok(service.buscarPorCategoria(categoriaId));
    }

    @PostMapping
    @Operation(summary = "Inserir livros", description = "Insere um livro no banco de dados")

    public ResponseEntity <LivroDtoResponse> criar (@Valid @RequestBody LivroDtoRequest request){
        return ResponseEntity.ok(service.criar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um livro", description = "Atualiza um livro dentro do banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity<LivroDtoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody LivroDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um livro", description = "Deleta um livro do banco de dados")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

