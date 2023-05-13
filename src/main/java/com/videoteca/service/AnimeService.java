package com.videoteca.service;

import com.videoteca.model.Anime;
import com.videoteca.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime crearAnime(Anime anime){
        return animeRepository.save(anime);
    }
}
