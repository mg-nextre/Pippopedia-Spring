package it.nextre.academy.Pippopedia.services;

import it.nextre.academy.Pippopedia.models.Professione;

import java.util.Optional;

public interface ProfessioneService {
    <S extends Professione> S save(S s);
    Optional<Professione> findById(Long aLong);
    Iterable<Professione> findAll();
    void deleteById(Long aLong);
    void deleteAll();
    Optional<Professione> findByNome(String nome);
}//end interface
