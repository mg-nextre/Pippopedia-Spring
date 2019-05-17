package it.nextre.academy.Pippopedia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "PROFESSIONE", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "autori")


public class Professione {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome")
    private String nome;
    @JsonIgnore
    @NotNull
    @OneToMany(mappedBy = "professione", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Autore> autori= new HashSet<>();

    public Professione(String nome){
        this.nome=nome;
    }
}//end class
