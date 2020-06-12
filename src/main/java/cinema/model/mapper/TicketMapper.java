package cinema.model.mapper;

import cinema.model.Ticket;
import cinema.model.dto.TicketResponseDto;
import cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    @Autowired
    private TicketService ticketService;

    public TicketResponseDto getTicketResponseDtoFromTicket(Ticket ticket) {
        TicketResponseDto ticketDto = new TicketResponseDto();
        ticketDto.setMovieTitle(ticket.getSession().getMovie().getTitle());
        ticketDto.setHallId(ticket.getSession().getCinemaHall().getId());
        ticketDto.setShowTime(ticket.getSession().getTime().toString());
        return ticketDto;
    }
}
