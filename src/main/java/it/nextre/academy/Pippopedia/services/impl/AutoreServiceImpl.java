package it.nextre.academy.Pippopedia.services.impl;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.Professione;
import it.nextre.academy.Pippopedia.repositories.AutoreRepository;
import it.nextre.academy.Pippopedia.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutoreServiceImpl implements AutoreService {

    private AutoreRepository autoreRepository;

    @Autowired
    public AutoreServiceImpl(AutoreRepository autoreRepository){
        this.autoreRepository = autoreRepository;
        /*Autore a1 = new Autore("Pippo", "Goofy", Autore.Professione.FILOSOFO);
        Autore a2 = new Autore("Pluto", "Goofy", Autore.Professione.ARCHITETTO);
        Autore a3 = new Autore("Topolino", "Goofy", Autore.Professione.GIORNALISTA);
        Autore a4 = new Autore("Paperino", "Goofy", Autore.Professione.SCIENZIATO);
        Autore a5 = new Autore("Gastone", "Goofy", Autore.Professione.POLITICO);

        this.autoreRepository.save(a1);
        this.autoreRepository.save(a2);
        this.autoreRepository.save(a3);
        this.autoreRepository.save(a4);
        this.autoreRepository.save(a5);*/

    }

    @Override
    public <S extends Autore> S save(S entity) {
        return this.autoreRepository.save(entity);
    }
    @Override
    public Optional<Autore> findById(Long aLong) {
        return this.autoreRepository.findById(aLong);
    }
    @Override
    public Iterable<Autore> findAll() {
        return this.autoreRepository.findAll();
    }
    @Override
    public void deleteById(Long aLong) {
        this.autoreRepository.deleteById(aLong);
    }
    @Override
    public void deleteAll() {
        this.autoreRepository.deleteAll();
    }
    @Override
    public Iterable<Autore> findByNome(String nome) {
        return this.autoreRepository.findByNome(nome);
    }
    @Override
    public Iterable<Autore> findByCognome(String nome) {
        return this.autoreRepository.findByCognome(nome);
    }
    @Override
    public Iterable<Autore> findByProfessione(Professione professione) {
        return this.autoreRepository.findByProfessione(professione);
    }

    @Override
    public Iterable<Autore> findByNomeAndCognomeAndProfessioneOrderById(String nome, String cognome, Professione professione) {
        return this.autoreRepository.findByNomeAndCognomeAndProfessioneOrderById(nome, cognome, professione);
    }

    @Override
    public Optional<Autore> findByUniqueId(String uniqueId) {
        return this.autoreRepository.findByUniqueId(uniqueId);
    }
}//end class
