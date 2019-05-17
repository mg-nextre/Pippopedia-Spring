package it.nextre.academy.Pippopedia.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "PIPPO_ARTICOLO")
public class PippoArticolo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;
    private String corpo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn//(name="autore_id", nullable = false)
    @NotNull
    private Autore autore;

    //private Long autoreId;

    /*public PippoArticolo(String titolo, String corpo, Long autoreId) {
        this.titolo = titolo;
        this.corpo = corpo;
        this.autoreId = autoreId;
    }*/

    public PippoArticolo(String titolo, String corpo, Autore autore) {
        this.titolo = titolo;
        this.corpo = corpo;
        this.autore = autore;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PippoArticolo)) return false;
        PippoArticolo that = (PippoArticolo) o;
        return Objects.equals(getTitolo(), that.getTitolo()) &&
                Objects.equals(getAutoreId(), that.getAutoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitolo(), getAutoreId());
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PippoArticolo)) return false;
        PippoArticolo that = (PippoArticolo) o;
        return Objects.equals(getTitolo(), that.getTitolo()) &&
                Objects.equals(getAutore(), that.getAutore());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getTitolo(), getAutore());
    }*/
}//end class
