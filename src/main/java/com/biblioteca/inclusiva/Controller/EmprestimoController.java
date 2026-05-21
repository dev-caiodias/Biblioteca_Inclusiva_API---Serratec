package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.EmprestimoDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.EmprestimoDtoResponse;
import com.biblioteca.inclusiva.Service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping
    @Operation(summary = "Listar todos os emprestimos", description = "Retorna uma lista com todos os emprestimos")
    public ResponseEntity <List<EmprestimoDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Inserir emprestimo", description = "Insere um emprestimo no banco de dados")
    @ApiResponse(responseCode = "400", description = "Requisição não foi concluida com sucesso")
    @ApiResponse(responseCode = "409", description = "Lança uma exceção quando é identificado um")
    public ResponseEntity <EmprestimoDtoResponse> criar(@Valid @RequestBody EmprestimoDtoRequest request){
        return ResponseEntity.ok(service.criar(request));
    }

    @PutMapping ("/{id}/devolver")
    @Operation(summary = "Atualizar emprestimo", description = "Atualiza um emprestimo no banco de dados")
    @ApiResponse(responseCode = "404", description = "Item não encontrado")
    public ResponseEntity <EmprestimoDtoResponse> devolver (@PathVariable Long id){
        return ResponseEntity.ok(service.devolver(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar emprestimo", description = "Deleta um emprestimo do banco de dados")
    @ApiResponse(responseCode = "400", description = "Requisição não foi concluida com sucesso")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
