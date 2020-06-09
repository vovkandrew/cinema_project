package cinema.dao.impl;

import cinema.dao.OrderDao;
import cinema.exceptions.DataProcessingException;
import cinema.library.Dao;
import cinema.model.Order;
import cinema.model.User;
import cinema.until.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrderDaoImpl implements OrderDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            LOGGER.info("New order " + order.getOrderId() + " has been added to the database");
            return order;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add new order to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getAll(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery(
                    "from Order order join fetch order.tickets Ticket "
                            + "where order.user = :user", Order.class);
            query.setParameter("user", user);
            LOGGER.info("All orders has been retrieved from the database");
            return query.list();
        } catch (HibernateException e) {
            throw new DataProcessingException("Can't find all orders at the database", e);
        }
    }
}
