package br.ufrpe.chat.repository;

import br.ufrpe.chat.beans.Topico;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositorioTopico extends JpaRepository<Topico, Long>{

}
