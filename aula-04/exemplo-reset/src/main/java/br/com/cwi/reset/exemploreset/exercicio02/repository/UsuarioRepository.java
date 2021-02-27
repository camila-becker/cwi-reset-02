package br.com.cwi.reset.exemploreset.exercicio02.repository;

import br.com.cwi.reset.exemploreset.exercicio02.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UsuarioRepository {
    static List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarUsuarios(){
        return usuarios;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        usuario.setId(new Random().nextInt(10));
        usuarios.add(usuario);
        return usuario;
    }

    public void deletarUsuario(Integer id){
        Usuario deletar = null;
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                deletar = usuario;
            }
        }
        usuarios.remove(deletar);
    }

}
