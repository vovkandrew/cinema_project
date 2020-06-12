package cinema.model.mapper;

import cinema.model.CinemaHall;
import cinema.model.dto.CinemaHallRequestDto;
import cinema.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHall getCinemaHallFromCinemaHallRequestDto(
            CinemaHallRequestDto cinemaHallRequestDto) {
        return new CinemaHall(cinemaHallRequestDto.getCapacity(),
                cinemaHallRequestDto.getDescription());
    }

    public CinemaHallResponseDto getCinemaHallResponseDtoFromCinemaHall(
            CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(
                cinemaHall.getCapacity(), cinemaHall.getDescription());
    }
}
