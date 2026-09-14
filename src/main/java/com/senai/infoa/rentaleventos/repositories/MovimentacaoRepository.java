package com.senai.infoa.rentaleventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infoa.rentaleventos.models.Movimentacao;



@Repository 
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

    
}