package cinema.service;

import cinema.model.MovieSession;
import cinema.model.ShoppingCart;
import cinema.model.User;

public interface ShoppingCartService {
    public void addSession(MovieSession session, User user);

    public ShoppingCart getByUser(User user);

    public void registerNewShoppingCart(User user);

    public void clear(ShoppingCart cart);
}
