package com.cexposito.notepad.controller;

import com.cexposito.notepad.model.Nota;
import com.cexposito.notepad.service.NotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {
    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public List<Nota> obtenerTodas() {
        return notaService.getNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerPorId(@PathVariable int id){
        return notaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota agregarNota(@RequestParam String titulo, @RequestParam String contenido){
        return notaService.agregarNota(titulo, contenido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable int id, @RequestParam String titulo, @RequestParam String contenido){
        return notaService.actualizarNota(id, titulo, contenido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable int id){
        return notaService.eliminarNota(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
