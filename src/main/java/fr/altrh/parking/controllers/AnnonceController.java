package fr.altrh.parking.controllers;

import fr.altrh.parking.domain.Annonce;
import fr.altrh.parking.domain.Client;
import fr.altrh.parking.dtos.AnnonceDto;
import fr.altrh.parking.services.AnnonceService;
import fr.altrh.parking.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients/{id}/Annonces")
    public ResponseEntity<Annonce> createAnnonce(@PathVariable("id") int id, @RequestBody AnnonceDto annonceDto){
        Client client = clientService.getClientById(id);
        Annonce annonce = new Annonce();
        annonce.setDateCreation(annonceDto.getDateCreation());
        annonce.setDateDebut(annonceDto.getDateDebut());
        annonce.setDateFin(annonceDto.getDateFin());

        Annonce createAnnonce = annonceService.createOrUpdateAnnonceService(annonce);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAnnonce);
    }
}
