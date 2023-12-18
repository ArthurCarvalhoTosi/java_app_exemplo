
package controle;

import java.util.ArrayList;

public interface IController <T>{
    
    String save(T obj);
    String delete(T obj);
    ArrayList<T> findAll();
    T findById(int id);
}
