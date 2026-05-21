package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.UsuarioDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.UsuarioDtoResponse;
import com.biblioteca.inclusiva.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Listar todos os usuarios", description = "Retorna uma lista com todos os usuários cadastrados")
    public ResponseEntity<List<UsuarioDtoResponse>>listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario", description = "Retorna um usuario com o id requisitado")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <UsuarioDtoResponse> buscar (@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar usuario", description = "Insere um novo usuario no banco de dados")
    @ApiResponse(responseCode = "409", description = "Lança uma exceção quando é identificado um")
    public ResponseEntity <UsuarioDtoResponse> inserir(@Valid @RequestBody UsuarioDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuario", description = "Atualiza um usuário dentro do banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <UsuarioDtoResponse> atualizar (@PathVariable Long id, @Valid @RequestBody UsuarioDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuario", description = "Deleta um usuário do banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
