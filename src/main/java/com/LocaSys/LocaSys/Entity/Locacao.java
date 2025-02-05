package com.LocaSys.LocaSys.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Locacao")
@Getter
@Setter
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Locacao")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_Carro") //Faz o relacionamento entre Locacao e Carro. Nomeia o nome da coluna.
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;

    @Column(name = "Dtinicio")
    private LocalDate dtIncio;

    @Column(name = "dt_Fim")
    private  LocalDate dtFim;

    @Column(name = "ValorLocacao")
    private double valorLocacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDtIncio() {
        return dtIncio;
    }

    public void setDtIncio(LocalDate dtIncio) {
        this.dtIncio = dtIncio;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }
}
