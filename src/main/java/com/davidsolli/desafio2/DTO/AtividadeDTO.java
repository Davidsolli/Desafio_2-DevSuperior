package com.davidsolli.desafio2.DTO;


import com.davidsolli.desafio2.entities.Atividade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AtividadeDTO {

    private Integer id;
    @NotBlank(message = "Campo requerido!")
    private String nome;
    @NotBlank(message = "Campo requerido!")
    private String descricao;
    @Positive(message = "O preço deve ser positivo!")
    private Double preco;

    public AtividadeDTO(Integer id, String nome, String descricao, Double preco) {
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
