package fr.altrh.parking.services;

import fr.altrh.parking.domain.Parking;
import fr.altrh.parking.domain.Place;
import fr.altrh.parking.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place createOrUpdatePlaceService(Place place){
        return placeRepository.save(place);
    }

    public Place getPlaceById(int id){
        return placeRepository.findById(id).orElse(null);
    }

    public void deletePlaceService(int id){
        placeRepository.deleteById(id);
    }
}
