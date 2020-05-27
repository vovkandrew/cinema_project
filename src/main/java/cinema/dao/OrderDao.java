package cinema.dao;

import cinema.model.Order;
import cinema.model.User;
import java.util.List;

public interface OrderDao {
    public Order add(Order order);

    public List<Order> getAll(User user);
}
