package com.senai.infoa.rentaleventos.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Equipamento")
public class Equipamento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name= "marca")
    private String marca;

    @Column(name= "modelo")
    private String modelo;

    @Column(name= "quantidade_disponivel")
    private int quantidadeDisponivel;

    @Column(name= "categoria")
    private String categoria;

    @Column(name= "potencia")
    private  String potencia;

    @Column(name= "material")
    private  String material;

    @Column(name="peso")
    private  BigDecimal peso;

    @Column(name="dimensao")
    private  String dimensao;

    @Column(name="cor")
    private  String cor;


    @JsonIgnore
     @ManyToMany
    @JoinTable(
        name = "equipamento_movimentacao",
        joinColumns = @JoinColumn(name = "equipamento_id"),
        inverseJoinColumns = @JoinColumn(name= "movimentacao_id")
    )
    private Set<Movimentacao> movimentacoes = new HashSet<>();
    

    

 public  Equipamento(){
 }


 public Equipamento(Integer id, String marca, String modelo, int quantidadeDisponivel, String categoria, String potencia,
      String material, BigDecimal peso, String dimensao, String cor, Set<Movimentacao> movimentacoes) {
   this.id = id;
   this.marca = marca;
   this.modelo = modelo;
   this.quantidadeDisponivel = quantidadeDisponivel;
   this.categoria = categoria;
   this.potencia = potencia;
   this.material = material;
   this.peso = peso;
   this.dimensao = dimensao;
   this.cor = cor;
   this.movimentacoes = movimentacoes;
}

 public Integer getId() {
    return id;
 }

 public void setId(Integer id) {
    this.id = id;
 }

 public String getMarca() {
    return marca;
 }

 public void setMarca(String marca) {
    this.marca = marca;
 }

 public String getModelo() {
    return modelo;
 }

 public void setModelo(String modelo) {
    this.modelo = modelo;
 }

 

 public int getQuantidadeDisponivel() {
   return quantidadeDisponivel;
}






 public void setQuantidadeDisponivel(int quantidadeDisponivel) {
   this.quantidadeDisponivel = quantidadeDisponivel;
 }






 public Set<Movimentacao> getMovimentacoes() {
   return movimentacoes;
 }






 public void setMovimentacoes(Set<Movimentacao> movimentacoes) {
   this.movimentacoes = movimentacoes;
 }






 public String getCategoria() {
    return categoria;
 }

 public void setCategoria(String categoria) {
    this.categoria = categoria;
 }

 public String getPotencia() {
    return potencia;
 }

 public void setPotencia(String potencia) {
    this.potencia = potencia;
 }

 public String getMaterial() {
    return material;
 }

 public void setMaterial(String material) {
    this.material = material;
 }

 public BigDecimal getPeso() {
    return peso;
 }

 public void setPeso(BigDecimal peso) {
    this.peso = peso;
 }

 public String getDimensao() {
    return dimensao;
 }

 public void setDimensao(String dimensao) {
    this.dimensao = dimensao;
 }

 public String getCor() {
    return cor;
 }

 public void setCor(String cor) {
    this.cor = cor;
 }



  
}
