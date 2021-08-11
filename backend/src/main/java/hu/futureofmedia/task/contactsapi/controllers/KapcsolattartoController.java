package hu.futureofmedia.task.contactsapi.controllers;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Kapcsolattarto;
import hu.futureofmedia.task.contactsapi.enums.StatusEnum;
import hu.futureofmedia.task.contactsapi.repositories.CompanyRepository;
import hu.futureofmedia.task.contactsapi.repositories.KapcsolattartoRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class KapcsolattartoController {
    KapcsolattartoRepository kapcsolattartoRepository;
    CompanyRepository companyRepository;

    public KapcsolattartoController(KapcsolattartoRepository kapcsolattartoRepository, CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.kapcsolattartoRepository = kapcsolattartoRepository;
        this.companyRepository.save(new Company(1L, "Future of Media"));
        this.kapcsolattartoRepository.save(new Kapcsolattarto(1L, "Zoltán", "Munkás", "zmunkas@gmail.com", "+36204130048", companyRepository.findById(1L).get(), "comment", StatusEnum.ACTIVE, LocalDateTime.now()));
    }

    @GetMapping("/kapcsolattartok")
    public List<Kapcsolattarto> getKapcsolattartok() {
        return (List<Kapcsolattarto>) kapcsolattartoRepository.findAll();
    }

    @GetMapping("/kapcsolattartok/{id}")
    public Kapcsolattarto getKapcsolattarto(@PathVariable("id") Long id){
        return kapcsolattartoRepository.findById(id).get();
    }

    @PutMapping("/kapcsolattartok")
    public Kapcsolattarto saveKapcsolattartok(@RequestBody Kapcsolattarto kapcsolattarto){
        kapcsolattarto.setModifiedTime(LocalDateTime.now());
        kapcsolattartoRepository.save(kapcsolattarto);
        return kapcsolattarto;
    }

    @PostMapping("/kapcsolattartok")
    public Kapcsolattarto addKapcsolattarto(@RequestBody Kapcsolattarto kapcsolattarto) {
        kapcsolattarto.setCreationTime(LocalDateTime.now());
        kapcsolattartoRepository.save(kapcsolattarto);
        return kapcsolattarto;
    }

    @DeleteMapping("/kapcsolattartok/{id}")
    public void deleteKapcsolattarto(@PathVariable long id){
        if(kapcsolattartoRepository.findById(id).isPresent()){
            Kapcsolattarto deleted = kapcsolattartoRepository.findById(id).get();
            deleted.setStatus(StatusEnum.ARCHIVED);
            kapcsolattartoRepository.save(deleted);
        }
    }

}
