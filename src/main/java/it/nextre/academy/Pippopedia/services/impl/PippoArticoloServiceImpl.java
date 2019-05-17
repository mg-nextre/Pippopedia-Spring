package it.nextre.academy.Pippopedia.services.impl;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.PippoArticolo;
import it.nextre.academy.Pippopedia.models.Professione;
import it.nextre.academy.Pippopedia.repositories.PippoArticoloRepository;
import it.nextre.academy.Pippopedia.services.PippoArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PippoArticoloServiceImpl implements PippoArticoloService {

    private PippoArticoloRepository pippoArticoloRepository;

    @Autowired
    public PippoArticoloServiceImpl(PippoArticoloRepository pippoArticoloRepository){
        this.pippoArticoloRepository = pippoArticoloRepository;
        PippoArticolo p1 = new PippoArticolo("Pippo regna sovrano", "I Pippidi stanno conquistando il mondo con il loro grido di battaglia", new Autore("Pippo", "Goofy", new Professione("Storico")));
        PippoArticolo p2 = new PippoArticolo("Pluto regna sovrano", "I Plutidi stanno conquistando il mondo con il loro grido di battaglia", new Autore("Pluto", "Goofy", new Professione("Architetto")));
        PippoArticolo p3 = new PippoArticolo("Topolino regna sovrano", "I Topolinidi stanno conquistando il mondo con il loro grido di battaglia", new Autore("Topolino", "Goofy", new Professione("Giornalista")));
        PippoArticolo p4 = new PippoArticolo("Paperino regna sovrano", "I Paperinidi stanno conquistando il mondo con il loro grido di battaglia", new Autore("Paperino", "Goofy", new Professione("Scienziato")));
        PippoArticolo p5 = new PippoArticolo("Gastone regna sovrano", "I Gastonidi stanno conquistando il mondo con il loro grido di battaglia", new Autore("Gastone", "Goofy", new Professione("Politico")));

        this.pippoArticoloRepository.save(p1);
        this.pippoArticoloRepository.save(p2);
        this.pippoArticoloRepository.save(p3);
        this.pippoArticoloRepository.save(p4);
        this.pippoArticoloRepository.save(p5);
    }

    @Override
    public <S extends PippoArticolo> S save(S entity) {
        return this.pippoArticoloRepository.save(entity);
    }
    @Override
    public Optional<PippoArticolo> findById(Long aLong) {
        return this.pippoArticoloRepository.findById(aLong);
    }
    @Override
    public Iterable<PippoArticolo> findAll() {
        return this.pippoArticoloRepository.findAll();
    }
    @Override
    public void deleteById(Long aLong) {
        this.pippoArticoloRepository.deleteById(aLong);
    }
    @Override
    public void deleteAll() {
        this.pippoArticoloRepository.deleteAll();
    }
    @Override
    public Iterable<PippoArticolo> findByTitolo(String titolo) {
        return this.pippoArticoloRepository.findByTitolo(titolo);
    }
    @Override
    public Iterable<PippoArticolo> findByAutore(Autore autore) {
        return this.pippoArticoloRepository.findByAutore(autore);
    }
    /*@Override
    public Optional<PippoArticolo> findByAutoreId(Long autoreId) {
        return this.pippoArticoloRepository.findByAutoreId(autoreId);
    }*/
}//end class
