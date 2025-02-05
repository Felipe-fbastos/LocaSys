package com.LocaSys.LocaSys.Controller;

import com.LocaSys.LocaSys.Entity.Locacao;
import com.LocaSys.LocaSys.Service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping("/alugar")
    public ResponseEntity<?> alugarCarro(@RequestBody Locacao locacao){
        try {

            Locacao novaLocacao = locacaoService.alugarCarro(
                    locacao.getCarro().getId(),  // Pegando o ID do carro
                    locacao.getCliente().getId(),  // Pegando o ID do cliente
                    locacao.getDtIncio(),  // Data de início
                    locacao.getDtFim()  // Data de fim
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(novaLocacao);
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR" + ex.getMessage());
        }
    }


}
