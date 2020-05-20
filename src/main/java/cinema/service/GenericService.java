package cinema.service;

import java.util.List;

public interface GenericService<O> {
    O add(O object);

    List<O> getAll();
}
