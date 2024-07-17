package com.alura.forochallenguealura.controller;


import com.alura.forochallenguealura.entity.Topico;
import com.alura.forochallenguealura.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> getAllTopicos() {
        return topicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicoById(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Topico createTopico(@RequestBody Topico topico) {
        return topicoService.save(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody Topico topicoDetails) {
        Optional<Topico> topico = topicoService.findById(id);
        if (topico.isPresent()) {
            Topico topicoToUpdate = topico.get();
            topicoToUpdate.setMensaje(topicoDetails.getMensaje());
            topicoToUpdate.setNombreCurso(topicoDetails.getNombreCurso());
            topicoToUpdate.setTitulo(topicoDetails.getTitulo());
            return ResponseEntity.ok(topicoService.save(topicoToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) {
        if (topicoService.findById(id).isPresent()) {
            topicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
