package cinema.dao;

import cinema.model.User;
import java.util.Optional;

public interface UserDao {
    public User add(User user);

    public Optional<User> findByEmail(String email);
}
