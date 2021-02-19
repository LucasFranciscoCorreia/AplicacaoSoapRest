package br.ufrpe.chat.service;

import br.ufrpe.chat.beans.Topico;
import br.ufrpe.chat.repository.RepositorioTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TopicoService {

    private RepositorioTopico repositorioTopico;

    @Autowired
    public TopicoService(RepositorioTopico repositorioTopico){
        this.repositorioTopico = repositorioTopico;
    }

    public List<Topico> listarTopicos() {
        return this.repositorioTopico.findAll();
    }

    public void addTopico(@RequestBody Topico topico) {
        this.repositorioTopico.save(topico);
    }
}
