package br.ufrpe.chat.controller;

import br.ufrpe.chat.beans.Mensagem;
import br.ufrpe.chat.beans.Topico;
import br.ufrpe.chat.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/mensagem")
public class MensagemController {

    private final MensagemService mensagemService;

    @Autowired
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping(value = "")
    public List<Mensagem> getAllMensagens(){
        return mensagemService.findAllMensagens();
    }

    @PostMapping(value = "")
    public void addMensagem(@RequestBody  Mensagem m){
        mensagemService.addMensagem(m);
    }

    @GetMapping(value = "/{topicoId}")
    public List<Mensagem> getAllByTopico(@PathVariable Long topicoId){

        Topico topico = new Topico();
        topico.id = topicoId;
        var mensagens =  mensagemService.findByTopico(topico);
        return mensagens;
    }
}
