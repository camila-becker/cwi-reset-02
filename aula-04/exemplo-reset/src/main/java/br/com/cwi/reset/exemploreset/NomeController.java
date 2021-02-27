package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
public class NomeController {
    public static String nome = "Camila";

    @GetMapping("/nome")
    public String nome(){
        return nome;
    }

    @PutMapping("/nome/{nome}")
    public String mudarNome(@PathVariable("nome") String nome){
        this.nome = nome;
        return this.nome;
    }

    @DeleteMapping("/nome")
    public void deletarNome(){
        this.nome = null;
    }
}
