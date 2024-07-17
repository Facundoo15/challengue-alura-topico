package com.alura.forochallenguealura.service;


import com.alura.forochallenguealura.entity.Topico;
import com.alura.forochallenguealura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> findById(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico save(Topico topico) {
        return topicoRepository.save(topico);
    }

    public void deleteById(Long id) {
        topicoRepository.deleteById(id);
    }
}