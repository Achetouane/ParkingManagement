package fr.altrh.parking.repository;

import fr.altrh.parking.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    public Client findClientByName(String name);
}
