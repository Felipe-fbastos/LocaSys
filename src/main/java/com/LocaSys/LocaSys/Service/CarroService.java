package com.LocaSys.LocaSys.Service;

import com.LocaSys.LocaSys.Repository.CarroRepository;
import com.LocaSys.LocaSys.Entity.Carro;
import com.LocaSys.LocaSys.Repository.StatusVeiculoRepository;
import com.LocaSys.LocaSys.exceptions.CarroFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private StatusVeiculoRepository repositoryStatus;

    public List<Carro> getAll() {
        return repository.findAll();
    }

    public Carro getId(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new CarroFoundException("id", id));

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
                .orElseThrow(() -> new CarroFoundException("modelo", modelo));
    }

    public Carro getPlaca(String placa) {
        return repository.findByPlaca(placa)
                .orElseThrow(() -> new CarroFoundException("placa", placa));
    }

    public Carro addCarro(Carro carro) {

        if (carro.getStatusVeiculo() != null && carro.getStatusVeiculo().getId() == 0) {
           repositoryStatus.save(carro.getStatusVeiculo());
        } else if (repository.existsByPlaca(carro.getPlaca())) {
            throw new IllegalArgumentException("Já existe um carro cadastrado com esta placa.");
        }
            return repository.save(carro);
   }



    public Carro updateCarro(Carro carroAtulizado, int id){

        Carro carroExistente = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Carro não encontrado"));

        if (repository.existsByPlacaAndIdNot(carroAtulizado.getPlaca(), id)){
            throw new IllegalArgumentException("Já existe um carro cadastrado com essa placa");
        }

        carroExistente.setNome(carroAtulizado.getNome());
        carroExistente.setModelo(carroAtulizado.getModelo());
        carroExistente.setAnoFabricacao(carroAtulizado.getAnoFabricacao());
        carroExistente.setCor(carroAtulizado.getCor());
        carroExistente.setPlaca(carroAtulizado.getPlaca());
        carroExistente.setValorAluguel(carroAtulizado.getValorAluguel());
        carroExistente.setStatusVeiculo(carroAtulizado.getStatusVeiculo());

        return repository.save(carroExistente);
    }



}
