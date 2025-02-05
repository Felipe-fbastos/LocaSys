package com.LocaSys.LocaSys.Controller;

import com.LocaSys.LocaSys.Entity.Carro;
import com.LocaSys.LocaSys.Service.CarroService;
import com.LocaSys.LocaSys.exceptions.CarroFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping("/get-all")
    public List<Carro> GetAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getId(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(service.getId(id));
        } catch (CarroFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getName(@PathVariable("nome") String nome) {
        try {
            return ResponseEntity.ok(service.getName(nome));
        } catch (CarroFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<?> getModel(@PathVariable("modelo") String modelo) {
        try {
            return ResponseEntity.ok(service.getModelo(modelo));
        } catch (CarroFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<?> getPlaca(@PathVariable("placa") String placa) {

        try {
            return ResponseEntity.ok(service.getPlaca(placa));

        } catch (CarroFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

//    @PostMapping("/cadastrar")
//    public ResponseEntity<?> addCarro(@Valid @RequestBody Carro carro){
//
//        return ResponseEntity.ok(service.addCarro(carro));
//    }
}



