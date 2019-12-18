package com.raf.cinemareservationservice.mapper;

import com.raf.cinemareservationservice.domain.Reservation;
import com.raf.cinemareservationservice.dto.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    private UserMapper userMapper;
    private ProjectionMapper projectionMapper;

    public ReservationMapper(UserMapper userMapper, ProjectionMapper projectionMapper) {
        this.userMapper = userMapper;
        this.projectionMapper = projectionMapper;
    }

    public ReservationDto reservationToReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setUser(userMapper.userToUserDto(reservation.getUser()));
        reservationDto.setProjection(projectionMapper.projectionToProjectionDto(reservation.getProjection()));
        reservationDto.setPrice(reservation.getPrice());
        return reservationDto;
    }
}
