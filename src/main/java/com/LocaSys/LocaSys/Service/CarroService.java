package com.LocaSys.LocaSys.Service;

import com.LocaSys.LocaSys.Repository.CarroRepository;
import com.LocaSys.LocaSys.Entity.Carro;
import com.LocaSys.LocaSys.exceptions.CarroFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> getAll() {
        return repository.findAll();
    }

    public Carro getId(int id) {

        return repository.findById(id)
                .orElseThrow( () -> new CarroFoundException("id", id));
//        if (existe.isPresent()) {
//            return ResponseEntity.ok(existe);
//        } else {
//            return ResponseEntity.badRequest().body("Carro com id " + id + " não encontrado");
//        }
    }

    public Carro getName(String nome) {

        return repository.findByNome(nome)
                .orElseThrow(() -> new CarroFoundException("nome", nome));

    }

    public Carro getModelo(String modelo) {
        return repository.findByModelo(modelo)
                .orElseThrow(() ->  new CarroFoundException("modelo", modelo));
    }

    public Carro getPlaca(String placa) {
        return repository.findByPlaca(placa)
                .orElseThrow(() -> new CarroFoundException("placa", placa));
    }
}