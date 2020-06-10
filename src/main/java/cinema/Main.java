package cinema;

import cinema.config.AppConfig;
import cinema.dao.TicketDao;
import cinema.exceptions.AuthenticationException;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.Ticket;
import cinema.model.User;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws AuthenticationException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Movie lotr = new Movie();
        lotr.setTitle("Lord of the rings");
        lotr.setDescription("This is awesome adventure movie!");
        MovieService movieService = context.getBean(MovieService.class);
        lotr = movieService.add(lotr);
        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDescription("Keanu Reaves is starring here!");
        matrix = movieService.add(matrix);
        Movie starWars = new Movie();
        starWars.setTitle("The Empire strikes back");
        starWars.setDescription("May the 4th be with you!");
        movieService.add(starWars);
        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall1 = new CinemaHall();
        cinemaHall1.setCapacity(100);
        cinemaHall1.setDescription("Big hall");
        CinemaHallService cinemaHallService = context.getBean(CinemaHallService.class);
        cinemaHall1 = cinemaHallService.add(cinemaHall1);
        CinemaHall cinemaHall2 = new CinemaHall();
        cinemaHall2.setCapacity(40);
        cinemaHall2.setDescription("Small cozy hall");
        cinemaHall2 = cinemaHallService.add(cinemaHall2);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession movieSession1 = new MovieSession();
        movieSession1.setCinemaHall(cinemaHall1);
        movieSession1.setMovie(lotr);
        LocalDateTime movieSession1time = LocalDateTime.parse("2020-05-30T10:00:00");
        movieSession1.setTime(movieSession1time);
        MovieSessionService movieSessionService = context.getBean(MovieSessionService.class);
        movieSessionService.add(movieSession1);
        MovieSession movieSession2 = new MovieSession();
        movieSession2.setCinemaHall(cinemaHall2);
        movieSession2.setMovie(lotr);
        LocalDateTime movieSession2time = LocalDateTime.parse("2020-05-25T19:00:00");
        movieSession2.setTime(movieSession2time);
        movieSessionService.add(movieSession2);
        MovieSession movieSession3 = new MovieSession();
        movieSession3.setMovie(lotr);
        movieSession3.setCinemaHall(cinemaHall1);
        LocalDateTime movieSession3time = LocalDateTime.parse("2020-05-20T19:00:00");
        movieSession3.setTime(movieSession3time);
        movieSessionService.add(movieSession3);
        MovieSession movieSession4 = new MovieSession();
        movieSession4.setMovie(matrix);
        movieSession4.setCinemaHall(cinemaHall2);
        movieSession4.setTime(movieSession1time);
        movieSessionService.add(movieSession4);
        movieSessionService
                .findAvailableSessions(lotr.getId(),
                        LocalDate.of(2020, 05, 22))
                .forEach(System.out::println);
        User user = new User();
        user.setEmail("111@gmail.com");
        user.setPassword("12345");
        User user1 = new User();
        user1.setEmail("222@gmail.com");
        user1.setPassword("78910");
        UserService userService = context.getBean(UserService.class);
        userService.add(user1);
        userService.add(user);
        Ticket t1 = new Ticket();
        t1.setUser(user);
        t1.setSession(movieSession1);
        TicketDao ticketDao = context.getBean(TicketDao.class);
        ticketDao.add(t1);
        Ticket t2 = new Ticket();
        t1.setUser(user1);
        t1.setSession(movieSession2);
        ticketDao.add(t2);
    }
}
