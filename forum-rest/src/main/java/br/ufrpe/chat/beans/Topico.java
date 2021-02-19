package br.ufrpe.chat.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="topico")
public class Topico implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(unique = true, nullable = false)
    public Long id;

    @Column(nullable = false)
    public String titulo;

    @Lob
    @Column
    public String comentario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    public List<Mensagem> mensagens;
}
