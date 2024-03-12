package com.Java.TrabalhoFinal.controller;

import com.Java.TrabalhoFinal.model.passageiro;
import com.Java.TrabalhoFinal.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    private final PassageiroService passageiroService;

    @Autowired
    public PassageiroController(PassageiroService passageiroService) {
        this.passageiroService = passageiroService;
    }

    @GetMapping
    public List<passageiro> getAllPassageiros() {
        return passageiroService.findAll();
    }

    @GetMapping("/{id}")
    public passageiro getPassageiroById(@PathVariable Long id) {
        return passageiroService.findById(id)
                .orElseThrow(() -> new RuntimeException("Passageiro não encontrado com ID: " + id));
    }

    @PostMapping
    public passageiro createPassageiro(@RequestBody passageiro passageiro) {
        return passageiroService.save(passageiro);
    }

    @DeleteMapping("/{id}")
    public void deletePassageiro(@PathVariable Long id) {
        passageiroService.deleteById(id);
    }
}
