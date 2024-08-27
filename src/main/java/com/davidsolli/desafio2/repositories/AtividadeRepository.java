package com.davidsolli.desafio2.repositories;

import com.davidsolli.desafio2.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

}
