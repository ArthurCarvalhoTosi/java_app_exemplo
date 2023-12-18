
package modelo;

import java.util.List;


public interface IDAO <T>{
    
    boolean insert(T obj);
    boolean update(T obj);
    boolean delete(T obj);
    List<T> findAll();
    T findById(int id);
}
