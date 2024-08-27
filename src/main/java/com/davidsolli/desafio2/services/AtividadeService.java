package com.davidsolli.desafio2.services;

import com.davidsolli.desafio2.DTO.AtividadeDTO;
import com.davidsolli.desafio2.entities.Atividade;
import com.davidsolli.desafio2.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<AtividadeDTO> findAll(Pageable pageable) {
        Page<Atividade> result = repository.findAll(pageable);
        return result.map(x -> new AtividadeDTO(x));
    }

    @Transactional
    public AtividadeDTO insert(AtividadeDTO dto) {
        Atividade entity = new Atividade();
        saveEntity(entity, dto);
        entity = repository.save(entity);
        return new AtividadeDTO(entity);
    }

    @Transactional
    public AtividadeDTO update(Integer id, AtividadeDTO dto) {
        Atividade entity = repository.getReferenceById(id);
        saveEntity(entity, dto);
        entity = repository.save(entity);
        return new AtividadeDTO(entity);
    }

    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void saveEntity(Atividade entity, AtividadeDTO dto) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
    }
}
