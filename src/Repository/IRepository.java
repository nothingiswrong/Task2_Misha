package Repository;

import java.util.List;

public interface IRepository<T> {
    public void add(T t);

    public List<T> getAll();
}