package br.com.cwi.reset.exemploreset.exercicio02.service;

import br.com.cwi.reset.exemploreset.exercicio02.domain.Usuario;
import br.com.cwi.reset.exemploreset.exercicio02.exception.BadRequestException;
import br.com.cwi.reset.exemploreset.exercicio02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarUsuarios(){
        return repository.listarUsuarios();
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        if(usuario == null ){
            throw new BadRequestException();
        }
        if(usuario.getId() != null){
            throw new BadRequestException();
        }
        return repository.cadastrarUsuario(usuario);
    }

    public void deletarUsuario(Integer id){
        repository.deletarUsuario(id);
    }
}
