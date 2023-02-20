package fr.altrh.parking.repository;

import fr.altrh.parking.domain.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Integer> {
}
