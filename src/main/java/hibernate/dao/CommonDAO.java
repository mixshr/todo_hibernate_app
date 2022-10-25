package hibernate.dao;

public interface CommonDAO<T> {

    T get(long id);

    void update(T obd);

    void delete(long id);

    void add(T obj);
}