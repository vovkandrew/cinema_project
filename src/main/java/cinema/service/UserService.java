package cinema.service;

import cinema.model.User;
import java.util.Optional;

public interface UserService {
    public User add(User user);

    public Optional<User> findByEmail(String email);
}
