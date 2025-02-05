package com.LocaSys.LocaSys.Repository;

import com.LocaSys.LocaSys.Entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Integer>  {


    Optional<Carro>  findById(int id);
    Optional<Carro>  findByNome(String nome);
    Optional<Carro>  findByModelo(String modelo);
    Optional<Carro>  findByPlaca(String placa);
    Optional<Carro>  findByStatusVeiculo_Id(int status);

    boolean existsByPlaca(String placa);
    boolean existsByPlacaAndIdNot(String placa, int id);

}
