package cinema.model.mapper;

import cinema.model.ShoppingCart;
import cinema.model.dto.ShoppingCartResponseDto;
import cinema.model.dto.TicketResponseDto;
import cinema.model.dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private UserMapper userMapper;

    public ShoppingCartResponseDto getShoppingCartResponseDtoFromShoppingCart(
            ShoppingCart shoppingCart) {
        List<TicketResponseDto> ticketResponseDtoList =
                shoppingCart.getTickets()
                        .stream()
                        .map(t -> ticketMapper.getTicketResponseDtoFromTicket(t))
                        .collect(Collectors.toList());
        UserResponseDto userResponseDto =
                userMapper.getUserResponseDtoFromUser(
                        shoppingCart.getUser());
        return new ShoppingCartResponseDto(ticketResponseDtoList, userResponseDto);
    }
}
