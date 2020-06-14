package cinema.model.mapper;

import cinema.model.CinemaHall;
import cinema.model.dto.CinemaHallRequestDto;
import cinema.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHall getCinemaHallFromCinemaHallRequestDto(
            CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall hall = new CinemaHall();
        hall.setCapacity(cinemaHallRequestDto.getCapacity());
        hall.setDescription(cinemaHallRequestDto.getDescription());
        return hall;
    }

    public CinemaHallResponseDto getCinemaHallResponseDtoFromCinemaHall(
            CinemaHall cinemaHall) {
        CinemaHallResponseDto hallDto = new CinemaHallResponseDto();
        hallDto.setCapacity(cinemaHall.getCapacity());
        hallDto.setDescription(cinemaHall.getDescription());
        return hallDto;
    }
}
