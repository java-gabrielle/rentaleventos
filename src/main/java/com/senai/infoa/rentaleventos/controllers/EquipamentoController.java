package com.senai.infoa.rentaleventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infoa.rentaleventos.models.Equipamento;

import com.senai.infoa.rentaleventos.services.EquipamentoService;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService us;

    @PostMapping("/cadastrar")
    public Equipamento salvar(@RequestBody Equipamento equipamento) {
        return us.salvar(equipamento);
    }  

    @PutMapping("/atualizar/{id}")
    public Equipamento atualizar(@PathVariable Integer id, @RequestBody Equipamento equipamento) {
        return us.atualizar(equipamento, id);
    }


    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable Integer id) {
        Equipamento equipamento = us.buscarPorId(id);
        return ResponseEntity.ok(equipamento);
    }



    @DeleteMapping("/delete/{id}")
    public String apagar(@PathVariable Integer id) {
        boolean apagou = us.apagar(id);
        if (apagou) {
            return "Equipamento removido com sucesso";
        }
        return "Falha ao remover o equipamento";
    }


}
