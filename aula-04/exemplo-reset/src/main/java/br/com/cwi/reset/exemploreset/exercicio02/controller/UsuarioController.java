package br.com.cwi.reset.exemploreset.exercicio02.controller;

import br.com.cwi.reset.exemploreset.exercicio02.domain.Usuario;
import br.com.cwi.reset.exemploreset.exercicio02.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable("id") Integer id){
        usuarioService.deletarUsuario(id);
    }
}
