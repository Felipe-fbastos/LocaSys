package com.LocaSys.LocaSys.Repository;

import com.LocaSys.LocaSys.Entity.StatusVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusVeiculoRepository extends JpaRepository<StatusVeiculo, Integer > {

    Optional<StatusVeiculo> findById(int id);
}
