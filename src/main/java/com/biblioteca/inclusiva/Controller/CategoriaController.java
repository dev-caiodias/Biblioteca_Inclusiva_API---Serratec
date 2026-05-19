package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.CategoriaDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.CategoriaDtoResponse;
import com.biblioteca.inclusiva.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity <List<CategoriaDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDtoResponse> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDtoResponse> inserir (@Valid @RequestBody CategoriaDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity <CategoriaDtoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id ,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
