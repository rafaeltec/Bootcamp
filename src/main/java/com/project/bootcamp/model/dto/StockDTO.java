package com.project.bootcamp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**classe que vai recever e trabalahr com os dados*/

public class StockDTO {
    /**
     * declarando todas as variáveis de acordo com os dados a serem recebidos
     */

    private Long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value = "0.00")
    /**  desabilitei temp . notation de validação de preenchimento, testas valom minímo*/
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    /** notation de validação de preenchimento, data no formato Brasileiro*/
    private LocalDate date;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    /** notation de validação de preenchimento, limita em 3 casa antes da virgula e 2 casa depois da virgula*/
    private Double variation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}


/** alt+insert - selection gets and sets depois marca tudo e adiciona. seguindo a orientação a objetos*/

