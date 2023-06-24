package com.videoteca.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "anime")
public class Anime {

    @Id
    private String id;
    private String titulo;
    private Detalle detalles;
}
