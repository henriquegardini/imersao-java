package br.com.alura.linguagens.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class LinguagemController {
    
    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagem")
    public String processaLinguagem() {
        return "Olá, java!!!";
    }

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        return repositorio.save(linguagem);
    }

    @PatchMapping("/linguagens")
    public Linguagem atualizarLinguagem(@RequestBody Linguagem linguagem) {
        return repositorio.save(linguagem);
    }

    @DeleteMapping("/linguagens")
    public void apagarLinguagem(@RequestBody Linguagem linguagem) {
        repositorio.delete(linguagem);
    }

}
