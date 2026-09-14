package com.senai.infoa.rentaleventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rentaleventos.models.Equipamento;
import com.senai.infoa.rentaleventos.repositories.EquipamentoRepository;

@Service 
public class EquipamentoService {

    @Autowired
     private EquipamentoRepository ur;

   
       public Equipamento salvar(Equipamento equipamento){
        if(equipamento != null) {
        return ur.save(equipamento);
        }
        return null;
    }


        public Equipamento atualizar(Equipamento equipamento, Integer id) {
    // 1. Busca no banco pelo ID (Integer)
    Equipamento equipamentoBanco = ur.findById(id).orElse(null);

    // 2. Se encontrar, atualiza os dados e salva no banco usando o 'ur'
    if (equipamentoBanco != null) {
        equipamentoBanco.setMarca(equipamento.getMarca());
        equipamentoBanco.setModelo(equipamento.getModelo());
        equipamentoBanco.setQuantidadeDisponivel(equipamento.getQuantidadeDisponivel());
        equipamentoBanco.setCategoria(equipamento.getCategoria());
        equipamentoBanco.setPotencia(equipamento.getPotencia());
        equipamentoBanco.setMaterial(equipamento.getMaterial());
        equipamentoBanco.setPeso(equipamento.getPeso());
        equipamentoBanco.setDimensao(equipamento.getDimensao());
        equipamentoBanco.setCor(equipamento.getCor());
        return ur.save(equipamentoBanco);
    }
    return null;
     }


     public Equipamento buscarPorId(Integer id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado: " + id));
    }


    
    public boolean apagar(Integer id) {
        Equipamento equipamento = ur.findById(id).get();
        if(equipamento != null){
            ur.deleteById(id);
            return true;
        }
        return false;
    }
        
    
}
