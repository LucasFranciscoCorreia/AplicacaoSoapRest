package br.ufrpe.chat.service;

import br.ufrpe.chat.beans.Mensagem;
import br.ufrpe.chat.beans.Topico;
import br.ufrpe.chat.repository.RepositorioMensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    private final RepositorioMensagem repositorioMensagem;

    @Autowired
    public MensagemService(RepositorioMensagem repositorioMensagem) {
        this.repositorioMensagem = repositorioMensagem;
    }

    public void addMensagem(Mensagem m){
        this.repositorioMensagem.save(m);
    }

    public List<Mensagem> findAllMensagens(){
        return this.repositorioMensagem.findAll();
    }

    public List<Mensagem> findByTopico(Topico topico){
        return this.repositorioMensagem.findAllByTopico(topico);
    }

}
