package cinema.service;

import cinema.model.User;

public interface UserService {
    public User add(User user);

    public User findByEmail(String email);

    public User getById(Long id);
}
