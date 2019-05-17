package it.nextre.academy.Pippopedia.controllers;

import it.nextre.academy.Pippopedia.models.Autore;
import it.nextre.academy.Pippopedia.models.PippoArticolo;
import it.nextre.academy.Pippopedia.models.Professione;
import it.nextre.academy.Pippopedia.services.AutoreService;
import it.nextre.academy.Pippopedia.services.PippoArticoloService;
import it.nextre.academy.Pippopedia.services.ProfessioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@RequestMapping({"/","/index","/main"})
public class PippoArticoloController {

    private PippoArticoloService pippoArticoloService;
    private AutoreService autoreService;
    private ProfessioneService professioneService;

    @Autowired
    public PippoArticoloController(PippoArticoloService pippoArticoloService, AutoreService autoreService, ProfessioneService professioneService){
        this.pippoArticoloService = pippoArticoloService;
        this.autoreService = autoreService;
        this.professioneService = professioneService;
    }
    @GetMapping("articoli/{id}")
    @ResponseBody
    public Optional<PippoArticolo> findArticoloById(@PathVariable Long id){
        return this.pippoArticoloService.findById(id);
    }

    @GetMapping("articoli")
    public @ResponseBody
    Iterable<PippoArticolo> findAllArticoli(){
        //model.addAttribute("pippoArticoli", pippoArticoloService.findAll());
        return pippoArticoloService.findAll();
    }
    @GetMapping("/autori")
    public @ResponseBody Iterable<Autore> findAllAutori(){
        //model.addAttribute("autori", autoreService.findAll());
        return autoreService.findAll();
    }
    @GetMapping("/professioni")
    public @ResponseBody Iterable<Professione> findAllProfessioni(){
        //model.addAttribute("professioni", professioneService.findAll());
        return professioneService.findAll();
    }

    @PostMapping("articoli/new")
    public @ResponseBody PippoArticolo addPippoAricolo(@RequestBody PippoArticolo pippoArticolo){
        String nomeProfessione= pippoArticolo.getAutore().getProfessione().getNome();

        Autore autoreRicevuto= pippoArticolo.getAutore();
        System.out.println(autoreRicevuto.getUniqueId());
        if(autoreRicevuto.getUniqueId() == null || autoreRicevuto.getUniqueId().equals("")){
            System.out.println("---------------Entrato----------------");
            autoreRicevuto.setUniqueId(UUID.randomUUID().toString());
        }
        try {
            Autore autore= this.autoreService.findByUniqueId(autoreRicevuto.getUniqueId()).get();
            pippoArticolo.setAutore(autore);
        }catch (Exception p){
            try{
                Professione professione = this.professioneService.findByNome(nomeProfessione).get();
                pippoArticolo.getAutore().setProfessione(professione);

            } catch (Exception e){

            }
        }finally {
            return pippoArticoloService.save(pippoArticolo);
        }


    }

    @PutMapping("articoli")
    public @ResponseBody PippoArticolo updatePippoArticolo(@RequestBody PippoArticolo pippoArticolo){
        return pippoArticoloService.save(pippoArticolo);
    }

    @DeleteMapping("articoli/{id}")
    public @ResponseBody void deletePippoArticolo(@PathVariable @NotNull Long id){
        pippoArticoloService.deleteById(id);
    }
}//end class
