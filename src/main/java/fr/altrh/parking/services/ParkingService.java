package fr.altrh.parking.services;

import fr.altrh.parking.domain.Parking;
import fr.altrh.parking.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    public Parking createOrUpdateParkingService(Parking parking){
        return parkingRepository.save(parking);
    }

    public Parking getParkingById(int id){
        return parkingRepository.findById(id).orElse(null);
    }

    public void deleteParkingById(int id){
        parkingRepository.deleteById(id);
    }
}
