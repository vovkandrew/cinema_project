package cinema.dao.impl;

import cinema.dao.MovieDao;
import cinema.exceptions.DataProcessingException;
import cinema.model.Movie;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl implements MovieDao {
    private static final Logger LOGGER = Logger.getLogger(MovieDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Movie add(Movie movie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Long movieId = (Long) session.save(movie);
            transaction.commit();
            movie.setId(movieId);
            LOGGER.info("New movie " + movie.getTitle() + " "
                    + movie.getId() + " has been added to the database");
            return movie;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add new movie to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Movie> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Movie.class);
            criteriaQuery.from(Movie.class);
            LOGGER.info("All movies retrieved from the database");
            return session.createQuery(criteriaQuery).getResultList();
        } catch (HibernateException e) {
            throw new DataProcessingException("Can't retrieve movies from the database", e);
        }
    }

    @Override
    public Movie getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            LOGGER.info("Movie with id " + id + " retrieved from the database");
            return session.get(Movie.class, id);
        } catch (HibernateException e) {
            throw new DataProcessingException("Can't retrieve movie from the database", e);
        }
    }
}
