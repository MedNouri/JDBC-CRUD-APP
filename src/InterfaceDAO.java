import java.util.List;

/**
 * Created by moham on 05/03/2019.
 */
public interface InterfaceDAO<T> {
    public List<T> getAll () ;
    public int insert(T c);
    public int delete(int id);
    public int update(T c);
    public T findById(int numero);
    public T findByName(String name);
}
