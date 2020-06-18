package cinema.service;

import cinema.model.User;

public interface AuthenticationService {

    public User register(String email, String password);
}
