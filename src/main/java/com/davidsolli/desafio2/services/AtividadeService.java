package com.davidsolli.desafio2.services;

import com.davidsolli.desafio2.DTO.AtividadeDTO;
import com.davidsolli.desafio2.entities.Atividade;
import com.davidsolli.desafio2.repositories.AtividadeRepository;
import com.davidsolli.desafio2.services.exceptions.DatabaseException;
import com.davidsolli.desafio2.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository repository;

    @Transactional(readOnly = true)
    public AtividadeDTO findById(Integer id) {
        Atividade atividade = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
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
        try {
            Atividade entity = repository.getReferenceById(id);
            saveEntity(entity, dto);
            entity = repository.save(entity);
            return new AtividadeDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Atividade não encontrada!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha na integridade referencial!");
        }
    }

    public void saveEntity(Atividade entity, AtividadeDTO dto) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
    }
}
