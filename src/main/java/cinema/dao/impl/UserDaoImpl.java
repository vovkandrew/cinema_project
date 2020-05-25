package cinema.dao.impl;

import cinema.dao.UserDao;
import cinema.exceptions.DataProcessingException;
import cinema.library.Dao;
import cinema.model.User;
import cinema.until.HibernateUtil;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User add(User user) {
        Transaction t = null;
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            t = s.beginTransaction();
            s.save(user);
            t.commit();
            LOGGER.info("New user " + user.getId() + " has been added to the database");
            return user;
        } catch (HibernateException e) {
            if (t != null) {
                t.rollback();
            }
            throw new DataProcessingException("Can't add new user to the database", e);
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query q = s.createQuery("from User where email = :email");
            q.setParameter("email", email);
            return Optional.of((User) q.uniqueResult());
        } catch (HibernateException e) {
            throw new DataProcessingException("Can't find a user by email in the database", e);
        }
    }
}
