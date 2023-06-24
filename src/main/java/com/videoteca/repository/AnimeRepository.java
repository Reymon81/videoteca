package com.videoteca.repository;

import com.videoteca.model.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends MongoRepository<Anime, String> {
    List<Anime> findByTitulo(String nombre);
    List<Anime> findByDetallesTipo(String tipo);

}
