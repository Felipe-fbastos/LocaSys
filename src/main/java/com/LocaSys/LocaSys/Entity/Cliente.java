package com.LocaSys.LocaSys.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cliente")
    private int id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "Dt_Nascimento")
    private LocalDate dtNascimento;

    @Column(name = "NroCNH")
    private String nroCNH;

    @Column(name = "DtValidadeCNH")
    private LocalDate dtvalidadeCNH;

    @Column(name = "DtEmissaoCNH")
    private LocalDate dtEmissaoCNH;

    @Column(name = "Email")
    private String email;

    @Column(name = "Telefone")
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacao;


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNroCNH() {
        return nroCNH;
    }

    public void setNroCNH(String nroCNH) {
        this.nroCNH = nroCNH;
    }

    public LocalDate getDtvalidadeCNH() {
        return dtvalidadeCNH;
    }

    public void setDtvalidadeCNH(LocalDate dtvalidadeCNH) {
        this.dtvalidadeCNH = dtvalidadeCNH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Locacao> locacao) {
        this.locacao = locacao;
    }






}
