package cinema.exceptions;

import org.hibernate.HibernateException;

public class DataExecutionException extends HibernateException {
    public DataExecutionException(String message, HibernateException e) {
        super(message);
    }
}
