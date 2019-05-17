package it.nextre.academy.Pippopedia.services;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.PippoArticolo;
import java.util.Optional;

public interface PippoArticoloService {

    <S extends PippoArticolo> S save(S entity);
    Optional<PippoArticolo> findById(Long aLong);
    Iterable<PippoArticolo> findAll();
    void deleteById(Long aLong);
    void deleteAll();

    Iterable<PippoArticolo> findByTitolo(String titolo);
    Iterable<PippoArticolo> findByAutore(Autore autore);
    //Optional<PippoArticolo> findByAutoreId(Long autoreId);


}//end interface
