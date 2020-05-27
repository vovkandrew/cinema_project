package cinema.service.impl;

import cinema.exceptions.AuthenticationException;
import cinema.library.Inject;
import cinema.library.Service;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import cinema.until.PasswordUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Wrong email or password provided"));
        if (PasswordUtil.hashPassword(password, user.getSalt()).equals(user.getPassword())) {
            return user;
        }
        throw new AuthenticationException("Wrong email or password provided");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        byte[] salt = PasswordUtil.getSalt();
        user.setSalt(salt);
        user.setPassword(PasswordUtil.hashPassword(password, salt));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
