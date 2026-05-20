package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.LivroDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.LivroDtoResponse;
import com.biblioteca.inclusiva.Service.LivroService;
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
    public ResponseEntity<List<LivroDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity <LivroDtoResponse> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity <List<LivroDtoResponse>> listarDisponiveis(){
        return ResponseEntity.ok(service.buscarDisponiveis());
    }

    @GetMapping("/categoria")
    public ResponseEntity <List<LivroDtoResponse>> buscarPorCategoria(@PathVariable Long categoriaId){
        return ResponseEntity.ok(service.buscarPorCategoria(categoriaId));
    }

    @PostMapping
    public ResponseEntity <LivroDtoResponse> criar (@Valid @RequestBody LivroDtoRequest request){
        return ResponseEntity.ok(service.criar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDtoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody LivroDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

