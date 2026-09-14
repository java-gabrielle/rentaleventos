package com.senai.infoa.rentaleventos.models;

import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="data_movimento")
    private LocalDateTime dataMovimento;

    @Column(name="tipo_movimentacao")
    private String tipoMovimentacao;

    @Column(name="quantidade")
    private String quantidade;


    
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    

    public Movimentacao(){
    }


    public Movimentacao(Integer id, LocalDateTime dataMovimento, String tipoMovimentacao, String quantidade,
            Usuario usuario) {
        this.id = id;
        this.dataMovimento = dataMovimento;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.usuario = usuario;
    }





    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    


    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }





    public void setDataMovimento(LocalDateTime dataMovimento) {
        this.dataMovimento = dataMovimento;
    }





    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }





    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }





    public String getQuantidade() {
        return quantidade;
    }



    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }



    public Usuario getUsuario() {
        return usuario;
    }



    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    






    
}
