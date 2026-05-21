package com.biblioteca.inclusiva.Controller;

import com.biblioteca.inclusiva.DTO.Request.EmprestimoDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.EmprestimoDtoResponse;
import com.biblioteca.inclusiva.Service.EmprestimoService;
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
    public ResponseEntity <List<EmprestimoDtoResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity <EmprestimoDtoResponse> criar(@Valid @RequestBody EmprestimoDtoRequest request){
        return ResponseEntity.ok(service.criar(request));
    }

    @PutMapping ("/{id}/devolver")
    public ResponseEntity <EmprestimoDtoResponse> devolver (@PathVariable Long id){
        return ResponseEntity.ok(service.devolver(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
