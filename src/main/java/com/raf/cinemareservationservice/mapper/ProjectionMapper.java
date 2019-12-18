package com.raf.cinemareservationservice.mapper;

import com.raf.cinemareservationservice.domain.Projection;
import com.raf.cinemareservationservice.dto.ProjectionDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectionMapper {

    private MovieMapper movieMapper;
    private ScreenMapper screenMapper;

    public ProjectionMapper(MovieMapper movieMapper, ScreenMapper screenMapper) {
        this.movieMapper = movieMapper;
        this.screenMapper = screenMapper;
    }

    public ProjectionDto projectionToProjectionDto(Projection projection) {
        ProjectionDto projectionDto = new ProjectionDto();
        projectionDto.setId(projection.getId());
        projectionDto.setMovieDto(movieMapper.movieToMovieDto(projection.getMovie()));
        projectionDto.setScreenDto(screenMapper.screenToScreenDto(projection.getScreen()));
        projectionDto.setPrice(projection.getPrice());
        return projectionDto;
    }

    public Projection projectionDtoToProjection(ProjectionDto projectionDto) {
        Projection projection = new Projection();
        projection.setId(projection.getId());
        projection.setPrice(projectionDto.getPrice());
        projection.setMovie(movieMapper.movieDtoToMovie(projectionDto.getMovieDto()));
        projection.setScreen(screenMapper.screenDtoToScreen(projectionDto.getScreenDto()));
        return projection;
    }
}
