package com.videoteca.util;

import com.videoteca.model.Anime;
import com.videoteca.model.Detalle;
import com.videoteca.model.front.AnimeFront;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utilidades {

    public Anime mapear(AnimeFront valores){

        var detalle = new Detalle();
        detalle.setTipo(valores.getTipo());
        detalle.setTemporada(valores.getTemporada());

        var anime = new Anime();
        anime.setTitulo(valores.getTitulo());
        anime.setDetalles(detalle);

        return anime;
    }
}
