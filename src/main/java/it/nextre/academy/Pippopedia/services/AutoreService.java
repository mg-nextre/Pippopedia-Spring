package it.nextre.academy.Pippopedia.services;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.Professione;

import java.util.Optional;

public interface AutoreService {

    <S extends Autore> S save(S entity);
    Optional<Autore> findById(Long aLong);
    Iterable<Autore> findAll();
    void deleteById(Long aLong);
    void deleteAll();

    Iterable<Autore> findByNome(String nome);
    Iterable<Autore> findByCognome(String nome);
    Iterable<Autore> findByProfessione(Professione professione);
    Iterable<Autore> findByNomeAndCognomeAndProfessioneOrderById(String nome, String cognome, Professione professione);
    Optional<Autore> findByUniqueId(String uniqueId);
}//end interface
