package com.raf.cinemareservationservice.repository;

import com.raf.cinemareservationservice.domain.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}
