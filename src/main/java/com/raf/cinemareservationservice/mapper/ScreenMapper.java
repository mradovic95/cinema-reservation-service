package com.raf.cinemareservationservice.mapper;

import com.raf.cinemareservationservice.domain.Screen;
import com.raf.cinemareservationservice.dto.ScreenDto;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {

    public ScreenDto screenToScreenDto(Screen screen) {
        ScreenDto screenDto = new ScreenDto();
        screenDto.setId(screen.getId());
        screenDto.setNumberOfSeats(screen.getNumberOfSeats());
        return screenDto;
    }

    public Screen screenDtoToScreen(ScreenDto screenDto) {
        Screen screen = new Screen();
        screen.setId(screenDto.getId());
        screen.setNumberOfSeats(screenDto.getNumberOfSeats());
        return screen;
    }
}

