package com.videoteca.service;

import com.videoteca.model.Anime;
import com.videoteca.model.front.AnimeFront;

import java.util.List;

public interface AnimeService {

    Anime createAnime(AnimeFront anime);

    List<Anime> buscarAnime(String anime);

    List<Anime> buscarTodos();

    List<Anime> buscarAnimePorTipo(String tipo);
}
