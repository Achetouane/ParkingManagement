package fr.altrh.parking.repository;

import fr.altrh.parking.domain.Annonce;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends CrudRepository<Annonce, Integer> {
}
