package cinema.dao;

import cinema.model.ShoppingCart;
import cinema.model.User;

public interface ShoppingCartDao {
    public ShoppingCart add(ShoppingCart cart);

    public ShoppingCart getByUser(User user);

    public void update(ShoppingCart shoppingCart);
}
