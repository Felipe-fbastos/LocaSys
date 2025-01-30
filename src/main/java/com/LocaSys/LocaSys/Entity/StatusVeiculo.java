package com.LocaSys.LocaSys.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "StatusVeiculo")
@Getter
@Setter
public class StatusVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Status_Veiculo")
    private int id;

    @Column(name = "Descricao")
    private String descricao;
}
