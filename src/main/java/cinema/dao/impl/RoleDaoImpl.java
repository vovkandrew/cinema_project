package cinema.dao.impl;

import cinema.dao.RoleDao;
import cinema.exceptions.DataProcessingException;
import cinema.model.Role;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            LOGGER.info("New role " + role.getRoleName() + " has been added to the database");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add new role to the database", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role findByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query =
                    session.createQuery(
                            "from Role where roleName = :roleName", Role.class);
            query.setParameter("roleName", Role.RoleName.valueOf(roleName));
            LOGGER.info("Role has been found by role name " + roleName);
            return query.uniqueResult();
        } catch (HibernateException e) {
            throw new DataProcessingException("Can't find a role by name in the database", e);
        }
    }
}
