package com.senai.infoa.rentaleventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rentaleventos.models.Movimentacao;
import com.senai.infoa.rentaleventos.models.Usuario;
import com.senai.infoa.rentaleventos.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService us;

    //@GetMapping("/listar-movimentacoes")
    //public List<Movimentacao> listarMovimentacao() {
       // return movimentacaoService.listarMovimentacao();
   // }

   
    @PostMapping("/cadastrar")
    public Movimentacao salvar(@RequestBody Movimentacao movimentacao) {
        return us.salvar(movimentacao);
    }


    @PutMapping("/atualizar/{id}")
    public Movimentacao atualizar(@PathVariable Integer id, @RequestBody Movimentacao movimentacao) {
        return us.atualizar(movimentacao, id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Movimentacao> buscarPorId(@PathVariable Integer id) {
        Movimentacao movimentacao = us.buscarPorId(id);
        return ResponseEntity.ok(movimentacao);
    }


    @GetMapping("/listar-movimentacoes")
    public List<Movimentacao> listarMovimentacao(){
        return us.listarMovimentacao();
    }

    @DeleteMapping("/delete/{id}")
    public String apagar(@PathVariable Integer id) {
        boolean apagou = us.apagar(id);
        if (apagou) {
            return "Movimentação removida com sucesso";
        }
        return "Falha ao remover a movimentacão";
    }



}

