package com.bn.exercicio10.Repositories;

import com.bn.exercicio10.Models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
