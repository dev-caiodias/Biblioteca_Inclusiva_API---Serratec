package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.UsuarioDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.UsuarioDtoResponse;
import com.biblioteca.inclusiva.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDtoResponse>>listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity <UsuarioDtoResponse> buscar (@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity <UsuarioDtoResponse> inserir(@Valid @RequestBody UsuarioDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity <UsuarioDtoResponse> atualizar (@PathVariable Long id, @Valid @RequestBody UsuarioDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
