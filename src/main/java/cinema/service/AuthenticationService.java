package cinema.service;

import cinema.exceptions.AuthenticationException;
import cinema.model.User;

public interface AuthenticationService {
    public User login(String email, String password) throws AuthenticationException;

    public User register(String email, String password);
}
