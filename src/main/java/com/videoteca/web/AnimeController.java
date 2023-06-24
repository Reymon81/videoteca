package com.videoteca.web;

import com.videoteca.model.Anime;
import com.videoteca.model.front.AnimeFront;
import com.videoteca.service.impl.AnimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/videoteca/anime")
public class AnimeController {
    @Autowired
    private final AnimeServiceImpl animeService;

    public AnimeController(AnimeServiceImpl animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/guardar")
    public Anime guardarAnime(@RequestBody AnimeFront anime) {
        return animeService.createAnime(anime);
    }

    @GetMapping("/buscar/titulo")
    public ResponseEntity<List<Anime>> obtainAnimeBuscar(@RequestParam("titulo") String titulo) {
        List<Anime> animes = animeService.buscarAnime(titulo);
        if (!animes.isEmpty()) {
            return ResponseEntity.ok(animes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Anime>> obtenerTodosLosAnimes() {
        List<Anime> animes = animeService.buscarTodos();
        if (!animes.isEmpty()) {
            return ResponseEntity.ok(animes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/tipo")
    public ResponseEntity<List<Anime>> obtenerPorTitulo(@RequestParam("tipo") String tipo){
        List<Anime> animes = animeService.buscarAnimePorTipo(tipo);
        if (!animes.isEmpty()) {
            return ResponseEntity.ok(animes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

