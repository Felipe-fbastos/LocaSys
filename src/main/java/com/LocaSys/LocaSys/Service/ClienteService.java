package com.LocaSys.LocaSys.Service;

import com.LocaSys.LocaSys.Entity.Cliente;
import com.LocaSys.LocaSys.Repository.ClienteRepository;
import com.LocaSys.LocaSys.exceptions.CadastroClienteFoundException;
import com.LocaSys.LocaSys.exceptions.ClienteFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAll(){
        return repository.findAll();
    }

    public Cliente getId(int id){

        return repository.findById(id)
                .orElseThrow(() -> new ClienteFoundException("id", id));

    }

    public Cliente getName(String nome){
        return repository.findByNome(nome)
                .orElseThrow(() -> new ClienteFoundException("nome",nome));
    }

    public Cliente getCpf(String cpf){
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteFoundException("cpf" , cpf));
    }

    public Cliente getCnh(String cnh){
        return repository.findByNroCNH(cnh)
                .orElseThrow(() -> new ClienteFoundException("CNH", cnh));
    }

    public Cliente addCliente(Cliente cliente){
        //repository.findByCpf(cliente.getCpf()).orElseThrow(() -> new CadastroClienteFoundException(cliente.getCpf()));

        // Verifica se já existe um cliente com o mesmo CPF
        if (repository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new CadastroClienteFoundException(cliente.getCpf());
        }
        return repository.save(cliente);

    }

}
