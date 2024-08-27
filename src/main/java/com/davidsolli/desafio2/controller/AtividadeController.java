package com.davidsolli.desafio2.controller;

import com.davidsolli.desafio2.DTO.AtividadeDTO;
import com.davidsolli.desafio2.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
