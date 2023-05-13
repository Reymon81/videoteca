package com.videoteca.web;

import com.videoteca.model.Anime;
import com.videoteca.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videoteca")
public class AnimeController {
    @Autowired
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/guardar")
    public Anime guardarAnime(@RequestBody Anime anime){
        return animeService.crearAnime(anime);
    }
}
