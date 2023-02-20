package fr.altrh.parking.services;

import fr.altrh.parking.domain.Annonce;
import fr.altrh.parking.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;

    public Annonce getAnnonceById(int id){
        return annonceRepository.findById(id).orElse(null);
    }

    public Annonce createOrUpdateAnnonceService(Annonce annonce){
        return annonceRepository.save(annonce);
    }
}
