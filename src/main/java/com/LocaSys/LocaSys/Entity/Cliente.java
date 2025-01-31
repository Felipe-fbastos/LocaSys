package com.LocaSys.LocaSys.Entity;

import com.LocaSys.LocaSys.validations.EmissaoCNH;
import com.LocaSys.LocaSys.validations.MaiorDeIdade;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.beans.XMLEncoder;
import java.net.http.HttpClient;
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

    @NotNull
    @Size(min = 3, message = "Nome muito pequeno")
    @Column(name = "Nome")
    private String nome;

    @NotNull
    @Size(min = 3, message = "Sobrenome muito pequeno")
    private String sobrenome;

    @NotNull
    @Size(min = 11, max = 11, message = "CPF inválido")
    @Column(name = "CPF")
    private String cpf;

    @NotNull
    @MaiorDeIdade
    @Column(name = "Dt_Nascimento")
    private LocalDate dtNascimento;

    @NotNull
    @Size(min = 9, max = 9, message = "CNH inválida")
    @Column(name = "NroCNH")
    private String nroCNH;

    @NotNull
    @Column(name = "DtValidadeCNH")
    private LocalDate dtvalidadeCNH;

    @NotNull
    @EmissaoCNH
    @Column(name = "DtEmissaoCNH")
    private LocalDate dtEmissaoCNH;

    @NotNull
    @Email
    @Column(name = "Email")
    private String email;

    @NotNull
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDtEmissaoCNH() {
        return dtEmissaoCNH;
    }

    public void setDtEmissaoCNH(LocalDate dtEmissaoCNH) {
        this.dtEmissaoCNH = dtEmissaoCNH;
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
