package com.davidsolli.desafio2.services;

import com.davidsolli.desafio2.DTO.AtividadeDTO;
import com.davidsolli.desafio2.entities.Atividade;
import com.davidsolli.desafio2.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Transactional(readOnly = true)
    public AtividadeDTO findById(Integer id) {
        Atividade atividade = repository.findById(id).get();
        return new AtividadeDTO(atividade);
    }
}
