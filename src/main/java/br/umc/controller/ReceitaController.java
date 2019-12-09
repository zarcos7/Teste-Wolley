/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.controller;

import br.umc.model.Receita;
import br.umc.service.ReceitaService;
import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.umc.service.ReceitaService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author Leandro
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class ReceitaController{

    @Autowired
    ReceitaService service;

    @PostMapping("/save")
    public Receita sabe(@RequestBody Receita receitas){
        service.saveOrUpdate(receitas);
        return receitas;
    }

    @GetMapping("/list")
    public List<Receita> list(){
        return service.getAllReceita();

    }

    @GetMapping("/list/(id)")
    public Receita getById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/delete/(id)")
    public String deleteReceita(@PathVariable(value = "id")  Long id){
        service.deleteReceita(id);
        return "Deletado com sucesso id = "+id;
    }
    




}
