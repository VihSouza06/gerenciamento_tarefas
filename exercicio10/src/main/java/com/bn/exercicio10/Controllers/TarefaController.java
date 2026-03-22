package com.bn.exercicio10.Controllers;

import com.bn.exercicio10.Models.TarefaModel;
import com.bn.exercicio10.Services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll(){
        List<TarefaModel> tarefas = tarefaService.findAll();
        return ResponseEntity.ok().body(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarTarefaPorId(@PathVariable Long id){
        TarefaModel tarefa =  tarefaService.buscarTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel tarefaCriada = tarefaService.criarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(tarefaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefaCriada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa
            (@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        TarefaModel tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaModel);
        return ResponseEntity.ok(tarefaAtualizada);
    }
}
