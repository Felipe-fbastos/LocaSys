package com.LocaSys.LocaSys.Service;


import com.LocaSys.LocaSys.Entity.Carro;
import com.LocaSys.LocaSys.Entity.Cliente;
import com.LocaSys.LocaSys.Entity.Locacao;
import com.LocaSys.LocaSys.Entity.StatusVeiculo;
import com.LocaSys.LocaSys.Repository.CarroRepository;
import com.LocaSys.LocaSys.Repository.ClienteRepository;
import com.LocaSys.LocaSys.Repository.LocacaoRepository;
import com.LocaSys.LocaSys.Repository.StatusVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository repositoryLocacao;

    @Autowired
    private ClienteRepository repositoryCliente;

    @Autowired
    private StatusVeiculoRepository repositoryStatus;

    @Autowired
    private CarroRepository repositoryCarro;

    public Locacao alugarCarro(int carroId, int clienteID, LocalDate dtIncio, LocalDate dtFim){

        //Localiza o carro
       Carro carro = repositoryCarro.findById(carroId)
                .orElseThrow(() -> new NoSuchElementException("Carro não encontrado"));

        //pega o ID do carro

        if (carro.getStatusVeiculo().getId() == 3){
            throw new IllegalArgumentException("O Carro já está alugado e não pode ser alugado");
        }

        else if (carro.getStatusVeiculo().getId() == 2){
            throw new IllegalArgumentException("O carro está em manutenção");
        }

       Cliente cliente = repositoryCliente.findById(clienteID)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));

        /*Incio = 2025-02-10 (10 de fevereiro de 2025)

        dtFim = 2025-02-05 (5 de fevereiro de 2025)

        O método isAfter verifica: "A data de início é depois da data de fim?"
        Nesse caso, sim, 10 de fevereiro é depois de 5 de fevereiro.*/

        if(dtIncio.isAfter(dtFim)){
            throw new IllegalArgumentException("A data de inicio posterior a data de entrega do veiculo");
        }

        //Calcula os dias de Alugel
        long diasDeAluguel = ChronoUnit.DAYS.between(dtIncio,dtFim);
        //Calcula o valor total da locação
        double valorTotal = diasDeAluguel * carro.getValorAluguel();

        Locacao locacao = new Locacao();

        locacao.setCarro(carro);
        locacao.setCliente(cliente);
        locacao.setDtIncio(dtIncio);
        locacao.setDtFim(dtFim);
        locacao.setValorLocacao(valorTotal);

        Optional<StatusVeiculo> novoStatus = Optional.ofNullable(repositoryStatus.findById(1)
                .orElseThrow(() -> new NoSuchElementException("Erro na alteração de Status")));

        // Desembrulhando o Optional e passando o StatusVeiculo diretamente
        carro.setStatusVeiculo(novoStatus.orElseThrow(() -> new NoSuchElementException("Status não encontrado")));

        repositoryCarro.save(carro);

        return repositoryLocacao.save(locacao);
    }

}
