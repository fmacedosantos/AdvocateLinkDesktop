package classes.interfaces;

import java.util.List;

public interface ObjectMethods<T> extends Comparable<T>{
    T search(String t);
    T delete(T t);
    T alter(T t);
    T register(T t);
    List<T> show();
}
