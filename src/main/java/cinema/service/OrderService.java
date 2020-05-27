package cinema.service;

import cinema.model.Order;
import cinema.model.Ticket;
import cinema.model.User;
import java.util.List;

public interface OrderService {
    public Order completeOrder(List<Ticket> tickets, User user);

    public List<Order> getOrderHistory(User user);
}
