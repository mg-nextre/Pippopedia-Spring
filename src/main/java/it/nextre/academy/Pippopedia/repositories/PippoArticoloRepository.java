package it.nextre.academy.Pippopedia.repositories;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.PippoArticolo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PippoArticoloRepository extends CrudRepository<PippoArticolo, Long> {

    @Override
    <S extends PippoArticolo> S save(S entity);

    @Override
    Optional<PippoArticolo> findById(Long aLong);

    @Override
    Iterable<PippoArticolo> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();

    Iterable<PippoArticolo> findByTitolo(String titolo);
    Iterable<PippoArticolo> findByAutore(Autore autore);
    Optional<PippoArticolo> findByAutoreId(Long autoreId);

}//end class
