package classes.interfaces;

import java.util.List;

public interface ObjectMethods<T>{
    T search(String t);
    T delete(T t);
    T alter(T t);
    T register(T t);
    List<T> show();
}
