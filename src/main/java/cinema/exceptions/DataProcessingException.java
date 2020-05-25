package cinema.exceptions;

import org.hibernate.HibernateException;

public class DataProcessingException extends HibernateException {
    public DataProcessingException(String message, HibernateException e) {
        super(message);
    }
}
