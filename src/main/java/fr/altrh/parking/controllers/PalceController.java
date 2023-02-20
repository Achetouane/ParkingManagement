package fr.altrh.parking.controllers;

import fr.altrh.parking.domain.Parking;
import fr.altrh.parking.domain.Place;
import fr.altrh.parking.dtos.PlaceDto;
import fr.altrh.parking.services.ParkingService;
import fr.altrh.parking.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PalceController {
    @Autowired
    private PlaceService placeService;
    @Autowired
    private ParkingService parkingService;

    // recuprer l'id du client apres son authentification
    @PostMapping("/parkings/{id}/places")
    public ResponseEntity<Place> createPlace(@PathVariable("id") int id, @RequestBody PlaceDto placeDto){
        Parking parking = parkingService.getParkingById(id);
        Place place = new Place();
        place.setNumero(placeDto.getNumero());
        place.setType(placeDto.getType());
        place.setParking(parking);

        Place  createPlace = placeService.createOrUpdatePlaceService(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPlace);
    }

    @PutMapping("/places/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable("id") int id, @RequestBody PlaceDto placeDto){
        Place place = placeService.getPlaceById(id);
        place.setParking(place.getParking());
        place.setNumero(placeDto.getNumero());
        place.setType(placeDto.getType());
        Place  updatePlace = placeService.createOrUpdatePlaceService(place);
        return ResponseEntity.status(HttpStatus.OK).body(updatePlace);
    }

    @DeleteMapping("/places/{id}")
    public ResponseEntity<Place> deletePlace(@PathVariable("id") int id, @RequestBody PlaceDto placeDto){
        Place place = placeService.getPlaceById(id);
        placeService.deletePlaceService(id);
        return ResponseEntity.status(HttpStatus.OK).body(place);
    }


}
