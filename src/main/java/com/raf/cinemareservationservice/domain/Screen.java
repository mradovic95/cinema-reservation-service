package com.raf.cinemareservationservice.domain;

public class Screen {

    private Long id;
    private Integer numberOfSeats;

    public Screen() {

    }

    public Screen(Long id, Integer numberOfSeats) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
