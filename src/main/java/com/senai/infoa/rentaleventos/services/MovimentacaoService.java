package com.senai.infoa.rentaleventos.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infoa.rentaleventos.models.Movimentacao;
import com.senai.infoa.rentaleventos.repositories.MovimentacaoRepository;
@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository ur;

    public Movimentacao salvar(Movimentacao movimentacao){
        if(movimentacao != null) {
        return ur.save(movimentacao);
        }
        return null;
    }

    public Movimentacao atualizar(Movimentacao movimentacao, Integer id) {
    // 1. Busca no banco pelo ID (Integer)
    Movimentacao movimentacaoBanco = ur.findById(id).orElse(null);

    // 2. Se encontrar, atualiza os dados e salva no banco usando o 'ur'
    if (movimentacaoBanco != null) {
        movimentacaoBanco.setDataMovimento(movimentacao.getDataMovimento());
        movimentacaoBanco.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
        movimentacaoBanco.setQuantidade(movimentacao.getQuantidade());
        return ur.save(movimentacaoBanco);
    }
    return null;
}

    
    public Movimentacao buscarPorId(Integer id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado: " + id));
    }


    public List<Movimentacao> listarMovimentacao(){
        return ur.findAll();
    }


    public boolean apagar(Integer id) {
        Movimentacao movimentacao = ur.findById(id).get();
        if(movimentacao != null){
            ur.deleteById(id);
            return true;
        }
        return false;
    }
        




    
}
