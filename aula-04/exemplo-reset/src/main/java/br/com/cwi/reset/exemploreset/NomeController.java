package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class NomeController {
    public static String nome = "Camila";

    @GetMapping()
    public String nome(){
        return nome;
    }

    @PutMapping("/{nome}")
    public String mudarNome(@PathVariable("nome") String nome){
        this.nome = nome;
        return this.nome;
    }

    @DeleteMapping()
    public void deletarNome(){
        this.nome = null;
    }
}
