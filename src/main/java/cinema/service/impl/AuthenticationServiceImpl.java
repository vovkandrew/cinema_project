package cinema.service.impl;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        Role adminRole = roleService.findRoleByName("ADMIN");
        Role userRole = roleService.findRoleByName("USER");
        user.setRoles(Set.of(adminRole, userRole));
        user.setPassword(passwordEncoder.encode(password));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
