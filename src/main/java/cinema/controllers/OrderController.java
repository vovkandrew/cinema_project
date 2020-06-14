package cinema.controllers;

import cinema.model.ShoppingCart;
import cinema.model.Ticket;
import cinema.model.User;
import cinema.model.dto.OrderResponseDto;
import cinema.model.dto.UserRequestDto;
import cinema.model.mapper.OrderMapper;
import cinema.model.mapper.TicketMapper;
import cinema.model.mapper.UserMapper;
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/complete")
    public void completeOrder(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.findByEmail(userRequestDto.getEmail());
        ShoppingCart cart = shoppingCartService.getByUser(user);
        List<Ticket> tickets = cart.getTickets();
        orderService.completeOrder(tickets, user);
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrdersByUserId(@RequestParam Long userId) {
        return orderService.getOrderHistory(
                userService.getById(userId))
                .stream()
                .map(o -> orderMapper.getOrderResponseDtoFromOrder(o))
                .collect(Collectors.toList());
    }
}
