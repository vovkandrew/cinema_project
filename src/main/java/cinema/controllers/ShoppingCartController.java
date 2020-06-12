package cinema.controllers;

import cinema.model.dto.ShoppingCartResponseDto;
import cinema.model.mapper.ShoppingCartMapper;
import cinema.service.MovieSessionService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private MovieSessionService movieSessionService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @PostMapping("/addmoviesession")
    public void addMovieSession(@RequestParam Long sessionId, @RequestParam Long userId) {
        shoppingCartService.addSession(
                movieSessionService.getById(sessionId),
                userService.getById(userId));
    }

    @GetMapping("/byuser")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartMapper.getShoppingCartResponseDtoFromShoppingCart(
                shoppingCartService.getByUser(
                        userService.getById(userId)));
    }
}
