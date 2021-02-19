package br.ufrpe.chat.repository;

import br.ufrpe.chat.beans.Mensagem;
import br.ufrpe.chat.beans.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RepositorioMensagem extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findAllByTopico(Topico topico);
}
