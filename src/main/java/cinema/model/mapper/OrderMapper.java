package cinema.model.mapper;

import cinema.model.Order;
import cinema.model.dto.OrderResponseDto;
import cinema.model.dto.TicketResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    private TicketMapper ticketMapper;

    public OrderResponseDto getOrderResponseDtoFromOrder(Order order) {
        List<TicketResponseDto> ticketResponseDtoList =
                order.getTickets()
                        .stream()
                        .map(t -> ticketMapper.getTicketResponseDtoFromTicket(t))
                        .collect(Collectors.toList());
        String orderDate = order.getOrderDate().toString();
        String userEmail = order.getUser().getEmail();
        return new OrderResponseDto(ticketResponseDtoList, orderDate, userEmail);
    }
}
