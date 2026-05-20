package com.biblioteca.inclusiva.Service;
import com.biblioteca.inclusiva.DTO.Request.UsuarioDtoRequest;
import com.biblioteca.inclusiva.DTO.Response.UsuarioDtoResponse;
import com.biblioteca.inclusiva.Domain.Usuario;
import com.biblioteca.inclusiva.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public  Usuario toUsuario (UsuarioDtoRequest request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setTelefone(request.getTelefone());

        return usuario;
    }

    public UsuarioDtoResponse toUsuarioResponse(Usuario usuario){
        UsuarioDtoResponse response = new UsuarioDtoResponse();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setTelefone(usuario.getTelefone());

        return response;
    }

    public List <UsuarioDtoResponse> listarTodos(){
        List <Usuario> usuario = usuarioRepository.findAll();
        return usuario.stream().map(this :: toUsuarioResponse).toList();
    }

    public UsuarioDtoResponse buscarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Usuario não encontrado."));

        return toUsuarioResponse(usuario);
    }
    

    public UsuarioDtoResponse criar(UsuarioDtoRequest request){
        if(!usuarioRepository.existsByEmail(request.getEmail())){
            throw new DuplicateEntryException("Email já cadastrado.");
        }

        return toUsuarioResponse(usuarioRepository.save(toUsuario(request)));
    }

    public UsuarioDtoResponse atualizar(Long id, UsuarioDtoRequest request){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));

        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setTelefone(request.getTelefone());

        return toUsuarioResponse(usuarioRepository.save(usuario));
    }

    public void deletar(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado."));

        usuarioRepository.deleteById(id);
    }

}
