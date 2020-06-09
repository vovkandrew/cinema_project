package cinema.dao.impl;

import cinema.dao.ShoppingCartDao;
import cinema.exceptions.DataProcessingException;
import cinema.library.Service;
import cinema.model.ShoppingCart;
import cinema.model.User;
import cinema.until.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Service
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private static final Logger LOGGER = Logger.getLogger(ShoppingCartDaoImpl.class);

    @Override
    public ShoppingCart add(ShoppingCart cart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(cart);
            transaction.commit();
            LOGGER.info("New shopping cart " + cart.getId() + " has been added to the database");
            return cart;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add new cart to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ShoppingCart> query = session.createQuery("from ShoppingCart cart "
                    + "left join fetch cart.tickets Ticket "
                    + "where cart.user = :user", ShoppingCart.class);
            query.setParameter("user", user);
            LOGGER.info("Shopping cart has been found in the database");
            return query.uniqueResult();
        } catch (HibernateException e) {
            throw new DataProcessingException(
                    "Can't find this user shopping cart in the database", e);
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(shoppingCart);
            transaction.commit();
            LOGGER.info("Shopping cart " + shoppingCart.getId()
                    + " has been updated in the database");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add new cart to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
