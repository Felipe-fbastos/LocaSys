package com.LocaSys.LocaSys.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "CARRO")
@Getter
@Setter

public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Carro")
    private int id;

    @NotNull
    @Size(min = 5, message = "O nome deve ter mais que 5 caracteres")
    @Column(name = "Nome")
    private String nome;

    @NotNull
    @Size(min = 3, message = "Modelo inválido")
    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "Ano_Fabricacao")
    private LocalDate anoFabricacao;

    @NotNull
    @Column(name = "Cor")
    private String cor;

    @NotNull
    @Size(min = 7, max = 7, message = "Placa inválida")
    @Column(name = "Placa")
    private String placa;

    //Size é para Strings e coleções
    //Min é para valores genéricos
    @Positive
    @NotNull
    @Min(value = 50, message = "Não pode cadastrar carro com valor abaixo de R$50")
    @Column(name = "Valor_Aluguel")
    private double valorAluguel;

    @OneToMany(mappedBy = "carro")
    private List<Locacao> locacao;

    @ManyToOne
    @JoinColumn(name = "Status", referencedColumnName = "id_Status_Veiculo")
    private StatusVeiculo statusVeiculo;

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public List<Locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Locacao> locacao) {
        this.locacao = locacao;
    }

    public StatusVeiculo getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
}
