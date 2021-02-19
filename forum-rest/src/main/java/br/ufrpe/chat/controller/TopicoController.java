package br.ufrpe.chat.controller;

import br.ufrpe.chat.beans.Topico;
import br.ufrpe.chat.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/topico")
public class TopicoController {

    @GetMapping(value="")
    public List<Topico> getTopicos(){
        return topicoService.listarTopicos();
    }


    private TopicoService topicoService;

    @Autowired
    public TopicoController(TopicoService service){
        this.topicoService = service;
    }

    @PostMapping(value="")
    public void addTopico(@RequestBody Topico topico){
                topicoService.addTopico(topico);
    }



}
