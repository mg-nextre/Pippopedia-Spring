package it.nextre.academy.Pippopedia.repositories;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.Professione;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutoreRepository extends CrudRepository<Autore, Long> {

    @Override
    <S extends Autore> S save(S entity);
    @Override
    Optional<Autore> findById(Long aLong);
    @Override
    Iterable<Autore> findAll();
    @Override
    void deleteById(Long aLong);
    @Override
    void deleteAll();

    Iterable<Autore> findByNome(String nome);
    Iterable<Autore> findByCognome(String nome);
    Iterable<Autore> findByProfessione(Professione professione);
    Iterable<Autore> findByNomeAndCognomeAndProfessioneOrderById(String nome, String cognome, Professione professione);
    Optional<Autore> findByUniqueId(String uniqueId);

}//end interface
