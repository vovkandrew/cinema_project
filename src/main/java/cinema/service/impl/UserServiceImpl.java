package cinema.service.impl;

import cinema.dao.UserDao;
import cinema.library.Inject;
import cinema.library.Service;
import cinema.model.User;
import cinema.service.UserService;
import cinema.until.PasswordUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    UserDao userDao;

    @Override
    public User add(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        byte[] salt = PasswordUtil.getSalt();
        newUser.setSalt(salt);
        newUser.setPassword(PasswordUtil.hashPassword(user.getPassword(), salt));
        return userDao.add(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
