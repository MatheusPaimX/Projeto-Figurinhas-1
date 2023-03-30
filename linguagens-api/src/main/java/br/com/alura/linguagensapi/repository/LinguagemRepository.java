package br.com.alura.linguagensapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.linguagensapi.model.Linguagem;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    
}
