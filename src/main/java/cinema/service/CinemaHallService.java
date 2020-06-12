package cinema.service;

import cinema.model.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    public CinemaHall add(CinemaHall cinemaHall);

    public List<CinemaHall> getAll();

    public CinemaHall getById(Long id);
}
