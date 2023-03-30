package br.com.alura.linguagensapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.alura.linguagensapi.model.Linguagem;
import br.com.alura.linguagensapi.repository.LinguagemRepository;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        return repositorio.findAll();
    }
    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem){
        return new ResponseEntity<>(repositorio.save(linguagem), HttpStatus.CREATED);
    }
    @GetMapping(value = "/linguagens/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id){
        return repositorio.findById(id)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/linguagens/{id}")
    public Linguagem atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem){
        if(!repositorio.existsById(id)){
            new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        linguagem.setId(id);
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }
    @DeleteMapping("/linguagens/{id}")
    public void deletarLinguagem(@PathVariable String id){
        repositorio.deleteById(id);
    }
}
