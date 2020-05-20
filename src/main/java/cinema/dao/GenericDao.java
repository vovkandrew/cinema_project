package cinema.dao;

import java.util.List;

public interface GenericDao<O> {
    O add(O object);

    List<O> getAll();
}
