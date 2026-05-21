package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.CategoriaDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.CategoriaDtoResponse;
import com.biblioteca.inclusiva.Service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Listar todas as categorias", description = "Retorna uma lista com todas as categorias cadastradas")
    public ResponseEntity <List<CategoriaDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria", description = "Retorna uma categoria ao digitar o ID")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity<CategoriaDtoResponse> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Postar categoria", description = "Insere uma categoria no banco de dados")
    public ResponseEntity<CategoriaDtoResponse> inserir (@Valid @RequestBody CategoriaDtoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria", description = "Atualiza uma categoria no banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <CategoriaDtoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaDtoRequest request){
        return ResponseEntity.ok(service.atualizar(id ,request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar categoria", description = "Deleta uma categoria no banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
