package com.videoteca.repository;

import com.videoteca.model.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AnimeRepository extends MongoRepository<Anime, String> {
    List<Anime> findByTitulo(String nombre);
}
