package it.nextre.academy.Pippopedia.repositories;

import it.nextre.academy.Pippopedia.models.Professione;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfessioneRepository extends CrudRepository<Professione, Long> {
    @Override
    <S extends Professione> S save(S s);

    @Override
    Optional<Professione> findById(Long aLong);

    @Override
    Iterable<Professione> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();

    Optional<Professione> findByNome(String nome);
}//end interface
