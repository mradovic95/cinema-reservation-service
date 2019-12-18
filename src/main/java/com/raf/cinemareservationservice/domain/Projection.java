package com.raf.cinemareservationservice.domain;

import java.math.BigDecimal;

public class Projection {

    private Long id;
    private Movie movie;
    private Screen screen;
    private BigDecimal price;

    public Projection() {

    }

    public Projection(Long id, Movie movie, Screen screen, BigDecimal price) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
