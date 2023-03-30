package br.com.alura.fotosapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FotoRepository extends MongoRepository<Foto, String> {
    
}
