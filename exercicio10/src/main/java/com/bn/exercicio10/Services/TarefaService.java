package com.bn.exercicio10.Services;

import com.bn.exercicio10.Models.TarefaModel;
import com.bn.exercicio10.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> findAll(){
        return tarefaRepository.findAll();
    }

    public TarefaModel criarTarefa(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public TarefaModel buscarTarefaPorId(Long id){
        return tarefaRepository.findById(id).get();
    }

    public TarefaModel atualizarTarefa(Long id, TarefaModel tarefaModel){
        TarefaModel novoTarefa = tarefaRepository.findById(id).get();
        novoTarefa.setDescricao(tarefaModel.getDescricao());
        novoTarefa.setDataVencimento(tarefaModel.getDataVencimento());
        novoTarefa.setConcluida(tarefaModel.getConcluida());
        return tarefaRepository.save(novoTarefa);
    }

}
