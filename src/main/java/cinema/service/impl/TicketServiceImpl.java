package cinema.service.impl;

import cinema.dao.TicketDao;
import cinema.model.Ticket;
import cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao ticketDao;

    @Override
    public Ticket getById(Long id) {
        return ticketDao.getById(id);
    }
}
