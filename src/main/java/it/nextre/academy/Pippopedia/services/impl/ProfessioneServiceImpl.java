package it.nextre.academy.Pippopedia.services.impl;

import it.nextre.academy.Pippopedia.models.Professione;
import it.nextre.academy.Pippopedia.repositories.ProfessioneRepository;
import it.nextre.academy.Pippopedia.services.ProfessioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProfessioneServiceImpl implements ProfessioneService {
    ProfessioneRepository professioneRepository;
    @Autowired
    public ProfessioneServiceImpl(ProfessioneRepository professioneRepository) {
        this.professioneRepository = professioneRepository;
    }

    @Override
    public <S extends Professione> S save(S s) {
        return this.professioneRepository.save(s);
    }

    @Override
    public Optional<Professione> findById(Long aLong) {
        return this.professioneRepository.findById(aLong);
    }

    @Override
    public Iterable<Professione> findAll() {
        return this.professioneRepository.findAll();
    }

    @Override
    public void deleteById(Long aLong) {
        this.professioneRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        this.professioneRepository.deleteAll();
    }

    @Override
    public Optional<Professione> findByNome(String nome) {
        return this.professioneRepository.findByNome(nome);
    }
}//end class
