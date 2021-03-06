package cinema.service.impl;

import cinema.dao.ShoppingCartDao;
import cinema.dao.TicketDao;
import cinema.model.MovieSession;
import cinema.model.ShoppingCart;
import cinema.model.Ticket;
import cinema.model.User;
import cinema.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public void addSession(MovieSession session, User user) {
        Ticket ticket = new Ticket();
        ticket.setSession(session);
        ticket.setUser(user);
        ShoppingCart cart = getByUser(user);
        cart.getTickets().add(ticket);
        ticketDao.add(ticket);
        shoppingCartDao.update(cart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(user);
        shoppingCartDao.add(cart);
    }

    @Override
    public void clear(ShoppingCart cart) {
        cart.getTickets().clear();
        shoppingCartDao.update(cart);
    }
}
