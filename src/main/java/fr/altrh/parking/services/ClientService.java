package fr.altrh.parking.services;

import fr.altrh.parking.domain.Client;
import fr.altrh.parking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createOrUpdateClientService(Client client){
        return clientRepository.save(client);
    }

    public Client getClientById(int id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client deleteClientById(int id){
        return clientRepository.findById(id).orElse(null);
    }

    public Client getClientByName(String name){
        return clientRepository.findClientByName(name);
    }
}
