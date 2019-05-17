package it.nextre.academy.Pippopedia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "pippoArticoli")
@Table(name = "AUTORE", uniqueConstraints = @UniqueConstraint(columnNames = "uniqueId"))
public class Autore implements Serializable {

    //@Entity
    //@Table(name = "PROFESSIONE")
    //@NoArgsConstructor
    //@AllArgsConstructor
    //public enum Professione {
    //    MEDICO("MEDICO"), PROFESSORE, SCIENZIATO("SCIENZIATO"), RICERCATORE, PSICOLOGO, GIORNALISTA("GIORNALISTA"),STORICO, FILOSOFO, PILOTA, MILITARE, POLIZIOTTO, POLITICO, ARCHITETTO, ALTRO;

        //Professione(String nome) {
        //    this.nome = nome;
        //}

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    private Long id;
    //    private String nome;
    //    @OneToMany(mappedBy = "professione", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //    @NotNull
    //    private Set<Autore> autori = new HashSet<>();
    //}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uniqueId;
    private String nome;
    private String cognome;
    //@Column(name = "professione", columnDefinition = "varchar")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn
    @NotNull
    private Professione professione;

    @OneToMany(mappedBy = "autore", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @NotNull
    @JsonIgnore
    private Set<PippoArticolo> pippoArticoli = new HashSet<>();

    public Autore(String nome, String cognome, Professione professione) {
        this.nome = nome;
        this.cognome = cognome;
        this.professione = professione;
        this.uniqueId= UUID.randomUUID().toString();
    }


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autore)) return false;
        Autore autore = (Autore) o;
        return Objects.equals(getNome(), autore.getNome()) &&
                Objects.equals(getCognome(), autore.getCognome()) &&
                getProfessione() == autore.getProfessione();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCognome(), getProfessione());
    }*/
}//end class
