package cinema.dao;

import cinema.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    public CinemaHall add(CinemaHall cinemaHall);

    public List<CinemaHall> getAll();

    public CinemaHall getById(Long id);
}
