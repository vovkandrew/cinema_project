package cinema.dao;

import cinema.model.User;

public interface UserDao {
    public User add(User user);

    public User findByEmail(String email);

    public User getById(Long id);
}
