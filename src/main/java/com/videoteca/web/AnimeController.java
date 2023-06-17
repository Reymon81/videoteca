package com.videoteca.web;

import com.videoteca.model.Anime;
import com.videoteca.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/videoteca/anime")
public class AnimeController {
    @Autowired
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/guardar")
    public Anime guardarAnime(@RequestBody Anime anime) throws IOException {
        return animeService.crearAnime(anime);
    }

    @GetMapping("/buscar")
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
}

