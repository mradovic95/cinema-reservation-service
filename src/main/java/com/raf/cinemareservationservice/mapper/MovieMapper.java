package com.raf.cinemareservationservice.mapper;

import com.raf.cinemareservationservice.domain.Movie;
import com.raf.cinemareservationservice.dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDto movieToMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        return movieDto;
    }

    public Movie movieDtoToMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        return movie;
    }
}
