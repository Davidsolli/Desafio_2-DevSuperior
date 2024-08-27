package com.davidsolli.desafio2.DTO;


import com.davidsolli.desafio2.entities.Atividade;
import com.davidsolli.desafio2.entities.Categoria;

public class AtividadeDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;

    public AtividadeDTO(Integer id, String nome, String descricao, Double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public AtividadeDTO(Atividade atividade) {
        id = atividade.getId();
        nome = atividade.getNome();
        descricao = atividade.getDescricao();
        preco = atividade.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }
}
