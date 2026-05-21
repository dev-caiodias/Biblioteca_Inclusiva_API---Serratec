package com.biblioteca.inclusiva.Service;

import com.biblioteca.inclusiva.DTO.Request.PerfilDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.PerfilDtoResponse;
import com.biblioteca.inclusiva.Domain.Entidades.PerfilAcessibilidade;
import com.biblioteca.inclusiva.Exception.ResourceNotFoundException;
import com.biblioteca.inclusiva.Repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public PerfilAcessibilidade toPerfil (PerfilDtoRequest request){
        PerfilAcessibilidade perfilAcessibilidade = new PerfilAcessibilidade();
        perfilAcessibilidade.setTipoDeficiencia(request.getTipoDeficiencia());
        perfilAcessibilidade.setFormatoPreferido(request.getFormatoPreferido());
        perfilAcessibilidade.setObservacoes(request.getObservacoes());

        return perfilAcessibilidade;
    }

    public PerfilDtoResponse toPerfilResponse(PerfilAcessibilidade perfilAcessibilidade){
        PerfilDtoResponse response = new PerfilDtoResponse();
        response.setId(perfilAcessibilidade.getId());
        response.setTipoDeficiencia(perfilAcessibilidade.getTipoDeficiencia());
        response.setFormatoPreferido(perfilAcessibilidade.getFormatoPreferido());
        response.setObservacoes(perfilAcessibilidade.getObservacoes());

        return response;
    }

    public List <PerfilDtoResponse> listarTodos(){
        List <PerfilAcessibilidade> perfil = perfilRepository.findAll();
        return perfil.stream().map(this :: toPerfilResponse).toList();
    }

    public PerfilDtoResponse buscarPorId (Long id){
        PerfilAcessibilidade perfilAcessibilidade = perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil acessibilidade não encontrado"));

        return toPerfilResponse(perfilAcessibilidade);
    }

    public PerfilDtoResponse criar (PerfilDtoRequest request){
        return toPerfilResponse(perfilRepository.save(toPerfil(request)));
    }

    public PerfilDtoResponse atualizar(Long id, PerfilDtoRequest request){
        PerfilAcessibilidade perfilAcessibilidade = perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Perfil acessibilidade não encontrado"));

        perfilAcessibilidade.setFormatoPreferido(request.getFormatoPreferido());
        perfilAcessibilidade.setTipoDeficiencia(request.getTipoDeficiencia());
        perfilAcessibilidade.setObservacoes(request.getObservacoes());

        return toPerfilResponse(perfilRepository.save(perfilAcessibilidade));
    }

    public void deletar(Long id){
        PerfilAcessibilidade perfilAcessibilidade = perfilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));

        perfilRepository.deleteById(id);
    }

}
