package fr.altrh.parking.controllers;

import fr.altrh.parking.domain.Client;
import fr.altrh.parking.domain.Parking;
import fr.altrh.parking.dtos.ClientDto;
import fr.altrh.parking.dtos.ParkingDto;
import fr.altrh.parking.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());

        Client createClient = clientService.createOrUpdateClientService(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(createClient);

    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> createParking(@PathVariable("id") int id, @RequestBody ClientDto clientDto){
        Client client = clientService.getClientById(id);
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());

        Client updateClient = clientService.createOrUpdateClientService(client);

        return ResponseEntity.status(HttpStatus.OK).body(updateClient);

    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteparking(@PathVariable("id") int id){
        Client client = clientService.getClientById(id);
        clientService.deleteClientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping("/clients")
    public ResponseEntity<Client> searchClientByName(@RequestParam("name") String name){
        Client client = clientService.getClientByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
}
