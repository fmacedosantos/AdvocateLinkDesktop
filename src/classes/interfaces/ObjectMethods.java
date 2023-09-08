package classes.interfaces;

public interface ObjectMethods<T> extends Comparable<T>{
    T search(T t);
    T delete(T t);
    T alter(T t);
}
