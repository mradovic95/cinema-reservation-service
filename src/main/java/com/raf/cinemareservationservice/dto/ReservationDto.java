package com.raf.cinemareservationservice.dto;

import java.math.BigDecimal;

public class ReservationDto {

    private String id;
    private ProjectionDto projection;
    private UserDto user;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectionDto getProjection() {
        return projection;
    }

    public void setProjection(ProjectionDto projection) {
        this.projection = projection;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
