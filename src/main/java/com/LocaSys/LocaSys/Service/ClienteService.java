package com.LocaSys.LocaSys.Service;

import com.LocaSys.LocaSys.Entity.Cliente;
import com.LocaSys.LocaSys.Repository.ClienteRepository;
import com.LocaSys.LocaSys.exceptions.CadastroClienteFoundException;
import com.LocaSys.LocaSys.exceptions.ClienteFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

        if (repository.existsByCpf(cliente.getCpf())) {
            throw new CadastroClienteFoundException(cliente.getCpf());
        }
        return repository.save(cliente);

    }

    public Cliente updateCliente(Cliente clienteAtualizado, int id){
            Cliente clienteExistente = repository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

            if (repository.existsByCpfAndIdNot(clienteAtualizado.getCpf(),id)){
                throw new IllegalArgumentException("Cliente já cadastrado no sistema");
            }

            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setSobrenome(clienteAtualizado.getSobrenome());
            clienteExistente.setCpf(clienteAtualizado.getCpf());
            clienteExistente.setDtNascimento(clienteAtualizado.getDtNascimento());
            clienteExistente.setNroCNH(clienteAtualizado.getNroCNH());
            clienteExistente.setDtvalidadeCNH(clienteAtualizado.getDtvalidadeCNH());
            clienteExistente.setDtEmissaoCNH(clienteAtualizado.getDtEmissaoCNH());
            clienteExistente.setEmail(clienteAtualizado.getEmail());
            clienteExistente.setTelefone(clienteAtualizado.getTelefone());

            return repository.save(clienteExistente);

    }

}
