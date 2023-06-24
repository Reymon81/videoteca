package com.videoteca.service.impl;

import com.videoteca.model.Anime;
import com.videoteca.model.front.AnimeFront;
import com.videoteca.repository.AnimeRepository;
import com.videoteca.service.AnimeService;
import com.videoteca.util.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;
    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public Anime createAnime(AnimeFront anime) {
        return animeRepository.save(Utilidades.mapear(anime));
    }

    @Override
    public List<Anime> buscarAnime(String anime) {
        return animeRepository.findByTitulo(anime);
    }

    @Override
    public List<Anime> buscarTodos() {
        return animeRepository.findAll();
    }

    @Override
    public List<Anime> buscarAnimePorTipo(String tipo) {
        return animeRepository.findByDetallesTipo(tipo);
    }
}
