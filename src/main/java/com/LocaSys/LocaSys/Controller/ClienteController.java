package com.LocaSys.LocaSys.Controller;

import com.LocaSys.LocaSys.Entity.Cliente;
import com.LocaSys.LocaSys.Service.ClienteService;
import com.LocaSys.LocaSys.exceptions.CadastroClienteFoundException;
import com.LocaSys.LocaSys.exceptions.ClienteFoundException;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteService service;

    @GetMapping("/get-all")
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable("id") int id) {

        try {
            return ResponseEntity.ok(service.getId(id));
        } catch (ClienteFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getName(@PathVariable("nome") String nome) {

        try {
            return ResponseEntity.ok(service.getName(nome));
        } catch (ClienteFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> getCpf(@PathVariable("cpf") String cpf) {

        try {
            return ResponseEntity.ok(service.getCpf(cpf));
        } catch (ClienteFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("cnh/{cnh}")
    public ResponseEntity<?> getCnh(@PathVariable("cnh") String cnh) {

        try{
            return ResponseEntity.ok(service.getCnh(cnh));
        }
        catch (ClienteFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @ExceptionHandler(CadastroClienteFoundException.class)
    public ResponseEntity<String> handleClienteJaCadastrado(CadastroClienteFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }



    @PostMapping("/cadastrar")
    public ResponseEntity<?> addCliente(@Valid @RequestBody Cliente cliente){

    try {
        return ResponseEntity.ok(service.addCliente(cliente));
    }
    catch (CadastroClienteFoundException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


    }

}


