package com.example.imcmatheus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imc {

    private float peso;
    private float altura;

    private float imc;
    private String classificacao;
    private String risco;

    public Imc(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public void imcCalculate() {
        this.imc = (float) (this.peso / (Math.pow(this.altura, 2)));

        if (imc < 18.5) {
            this.classificacao = "Abaixo do Peso";
            this.risco = "Elevado";
        } else if (imc < 25) {
            this.classificacao = "Peso Ideal";
            this.risco = "Inexistente";
        } else if (imc < 30) {
            this.classificacao = "Excesso de Peso";
            this.risco = "Elevado";
        } else if (imc < 35) {
            this.classificacao = "Obesidade Grau 1";
            this.risco = "Muito Elevado";
        } else if (imc < 40) {
            this.classificacao = "Obesidade Grau 2";
            this.risco = "Muitíssimo Elevado";
        } else {
            this.classificacao = "Obesidade Grau 3";
            this.risco = "Obesidade Mórbida";
        }
    }
}
