package cinema.dao.impl;

import cinema.dao.TicketDao;
import cinema.exceptions.DataProcessingException;
import cinema.library.Dao;
import cinema.model.Ticket;
import cinema.until.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    private static final Logger LOGGER = Logger.getLogger(TicketDaoImpl.class);

    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            LOGGER.info("New ticket " + ticket.getId() + " added to the database");
            return ticket;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add new ticket to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
