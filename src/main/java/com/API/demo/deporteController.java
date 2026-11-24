package com.API.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/deportes")
public class deporteController {

    private List<deporte> deportes = new ArrayList<>(List.of(
            new deporte(1L, "Fútbol"),
            new deporte(2L, "Baloncesto")
    ));

    @GetMapping
    public List<deporte> listar() {
        return deportes;
    }

    @PostMapping
    public deporte crear(@RequestBody deporte nuevo) {
        deportes.add(nuevo);
        return nuevo;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        deportes.removeIf(d -> d.id.equals(id));
        return "Borrado";
    }
}