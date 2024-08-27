package com.davidsolli.desafio2.controller;

import com.davidsolli.desafio2.DTO.AtividadeDTO;
import com.davidsolli.desafio2.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AtividadeDTO> findById(@PathVariable Integer id) {
        AtividadeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<AtividadeDTO>> findAll(Pageable pageable) {
        Page<AtividadeDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<AtividadeDTO> insert(@RequestBody AtividadeDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
