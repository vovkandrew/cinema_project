package cinema.controllers;

import cinema.model.CinemaHall;
import cinema.model.dto.CinemaHallRequestDto;
import cinema.model.dto.CinemaHallResponseDto;
import cinema.model.mapper.CinemaHallMapper;
import cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    @Autowired
    private CinemaHallService cinemaHallService;

    @Autowired
    private CinemaHallMapper cinemaHallMapper;

    @PostMapping
    public void addCinemaHall(@RequestBody @Valid CinemaHallRequestDto cinemaHallRequestDto) {
        CinemaHall hall =
                cinemaHallMapper.getCinemaHallFromCinemaHallRequestDto(
                        cinemaHallRequestDto);
        cinemaHallService.add(hall);
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(hall -> cinemaHallMapper.getCinemaHallResponseDtoFromCinemaHall(hall))
                .collect(Collectors.toList());
    }
}
