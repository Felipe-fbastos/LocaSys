package com.LocaSys.LocaSys.Repository;

import com.LocaSys.LocaSys.Entity.Cliente;
import org.hibernate.engine.jdbc.batch.JdbcBatchLogging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //Gets

    Optional <Cliente> findByNome(String nome);
    Optional <Cliente> findByCpf(String cpf);
    Optional <Cliente> findByNroCNH(String Nrocnh);



}
