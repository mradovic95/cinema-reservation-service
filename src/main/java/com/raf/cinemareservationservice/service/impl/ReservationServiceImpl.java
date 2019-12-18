package com.raf.cinemareservationservice.service.impl;

import com.raf.cinemareservationservice.domain.Reservation;
import com.raf.cinemareservationservice.dto.ProjectionDto;
import com.raf.cinemareservationservice.dto.UserDto;
import com.raf.cinemareservationservice.mapper.ProjectionMapper;
import com.raf.cinemareservationservice.mapper.UserMapper;
import com.raf.cinemareservationservice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class ReservationServiceImpl {

    private ReservationRepository reservationRepository;
    private RestTemplate userServiceApiClient;
    private RestTemplate movieServiceApiClient;
    private ProjectionMapper projectionMapper;
    private UserMapper userMapper;

    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            @Qualifier("userServiceApiClient") RestTemplate userServiceApiClient,
            @Qualifier("movieService") RestTemplate movieServiceApiClient,
            ProjectionMapper projectionMapper,
            UserMapper userMapper) {

        this.reservationRepository = reservationRepository;
        this.userServiceApiClient = userServiceApiClient;
        this.movieServiceApiClient = movieServiceApiClient;
        this.projectionMapper = projectionMapper;
        this.userMapper = userMapper;
    }

    public void createOrder(Long userId, Long projectionId) {
        ResponseEntity<ProjectionDto> projectionDto = movieServiceApiClient.exchange("/projection/" + projectionId, HttpMethod.GET,
                null, ProjectionDto.class);
        ResponseEntity<UserDto> userDto = userServiceApiClient.exchange("/user/" + projectionId, HttpMethod.GET,
                null, UserDto.class);
        //get projection price
        BigDecimal price = projectionDto.getBody().getPrice();
        price = price.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(userDto.getBody().getDiscount()));

        Reservation reservation = new Reservation();
        reservation.setPrice(price);
        reservation.setUser(userMapper.userDtoToUser(userDto.getBody()));
        reservation.setProjection(projectionMapper.projectionDtoToProjection(projectionDto.getBody()));
        reservationRepository.save(reservation);
    }
}
