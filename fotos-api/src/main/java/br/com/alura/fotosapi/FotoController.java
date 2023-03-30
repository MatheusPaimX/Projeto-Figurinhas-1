package br.com.alura.fotosapi;

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

@RestController
public class FotoController {
    @Autowired
    private FotoRepository repositorio;

    @GetMapping("/fotos")
    public List<Foto> obterFotos(){
        return repositorio.findAll();
    }
    @PostMapping("/fotos")
    public ResponseEntity<Foto> cadastrarFoto(@RequestBody Foto foto){
        return new ResponseEntity<>(repositorio.save(foto), HttpStatus.CREATED);
    }
    @GetMapping(value = "/fotos/{id}")
    public Foto obterFotoPorId(@PathVariable String id){
        return repositorio.findById(id)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/fotos/{id}")
    public Foto atualizarFoto(@PathVariable String id, @RequestBody Foto foto){
        if(!repositorio.existsById(id)){
            new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        foto.setId(id);
        Foto fotoSalva = repositorio.save(foto);
        return fotoSalva;
    }
    @DeleteMapping("/fotos/{id}")
    public void deletarFoto(@PathVariable String id){
        repositorio.deleteById(id);
    }
}
