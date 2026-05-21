package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.PerfilDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.PerfilDtoResponse;
import com.biblioteca.inclusiva.Service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfilAcessibilidade")
public class PerfilController {

    @Autowired
    private PerfilService service;

    @GetMapping
    @Operation(summary = "Listar todos os perfis de acessibilidade", description = "Retorna uma lista com todos os  cadastrados")
    public ResponseEntity <List<PerfilDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por id", description = "Retorna um perfil de acessibilidade por um id")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <PerfilDtoResponse> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Inserir perfil de acessibilidade", description = "Insere um perfil de acessibilidade no banco de dados")

    public ResponseEntity <PerfilDtoResponse> inserir (@Valid @RequestBody PerfilDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um perfil de acessibilidade", description = "Atualiza um perfil no banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <PerfilDtoResponse> atualizar (@PathVariable Long id, @Valid @RequestBody PerfilDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar perfil de acessibilidade", description = "Deleta um perfil de acessibilidade do banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
