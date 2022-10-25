package hibernate.dao;

import java.util.List;

public interface FindDAO<T> {
    List<T> findAll();

    List<T> findAll(String email);
}
