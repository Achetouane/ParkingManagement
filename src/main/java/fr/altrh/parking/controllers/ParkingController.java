package fr.altrh.parking.controllers;

import fr.altrh.parking.domain.Parking;
import fr.altrh.parking.dtos.ParkingDto;
import fr.altrh.parking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/parkings")
    public ResponseEntity<Parking>  createParking(@RequestBody ParkingDto parkingDto){
        Parking parking = new Parking();
        parking.setName(parkingDto.getName());
        parking.setNbrePlaces(parkingDto.getNbrePlaces());
        parking.setAdresse(parkingDto.getAdresse());
        Parking createParking = parkingService.createOrUpdateParkingService(parking);

        return ResponseEntity.status(HttpStatus.CREATED).body(createParking);

    }

    @PutMapping("/parkings/{id}")
    public ResponseEntity<Parking> updateParking(@PathVariable("id") int id, @RequestBody ParkingDto parkingDto){
        Parking parking = parkingService.getParkingById(id);
        parking.setName(parkingDto.getName());
        parking.setNbrePlaces(parkingDto.getNbrePlaces());
        parking.setAdresse(parkingDto.getAdresse());
        Parking updateParking = parkingService.createOrUpdateParkingService(parking);
        return ResponseEntity.status(HttpStatus.OK).body(updateParking);
    }

    @DeleteMapping("/parkings/{id}")
    public ResponseEntity<Parking> deleteparking(@PathVariable("id") int id){
        Parking parking = parkingService.getParkingById(id);
        parkingService.deleteParkingById(id);
        return ResponseEntity.status(HttpStatus.OK).body(parking);
    }
}

