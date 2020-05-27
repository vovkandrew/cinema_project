package cinema;

import cinema.dao.TicketDao;
import cinema.exceptions.AuthenticationException;
import cinema.library.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.Ticket;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static final Injector injector = Injector.getInstance("cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie lotr = new Movie();
        lotr.setTitle("Lord of the rings");
        lotr.setDescription("This is awesome adventure movie!");
        lotr = movieService.add(lotr);
        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDescription("Keanu Reaves is starring here!");
        matrix = movieService.add(matrix);
        Movie starWars = new Movie();
        starWars.setTitle("The Empire strikes back");
        starWars.setDescription("May the 4th be with you!");
        starWars = movieService.add(starWars);
        movieService.getAll().forEach(System.out::println);

        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        CinemaHall cinemaHall1 = new CinemaHall();
        cinemaHall1.setCapacity(100);
        cinemaHall1.setDescription("Big hall");
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
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
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
        AuthenticationService as =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);
        System.out.println(as.register(user.getEmail(),user.getPassword()));
        System.out.println(as.register(user1.getEmail(),user1.getPassword()));
        try {
            System.out.println(as.login("111@gmail.com", "12345"));
            System.out.println(as.login("222@gmail.com", "78910"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        UserService userService = (UserService) injector.getInstance(UserService.class);
        Ticket t1 = new Ticket();
        t1.setUser(user);
        t1.setSession(movieSession1);
        TicketDao ticketDao = (TicketDao) injector.getInstance(TicketDao.class);
        ticketDao.add(t1);
        Ticket t2 = new Ticket();
        t1.setUser(user1);
        t1.setSession(movieSession2);
        ticketDao.add(t2);
        ShoppingCartService scdi =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        System.out.println(scdi.getByUser(user).toString());
        scdi.addSession(movieSession1, user);
        System.out.println(scdi.getByUser(user));
    }
}
