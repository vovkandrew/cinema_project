package cinema.dao;

import cinema.model.Ticket;

public interface TicketDao {
    public Ticket add(Ticket ticket);

    public Ticket getById(Long id);
}
