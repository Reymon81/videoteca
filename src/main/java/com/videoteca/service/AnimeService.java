package com.videoteca.service;

import com.videoteca.model.Anime;
import com.videoteca.repository.AnimeRepository;
import org.apache.commons.io.FileUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;
    @Autowired
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime crearAnime(Anime anime){ return animeRepository.save(anime);  }

    public List<Anime> buscarAnime(String anime){
        return animeRepository.findByTitulo(anime);
    }

    public List<Anime> buscarTodos(){
        return animeRepository.findAll();
    }

}
