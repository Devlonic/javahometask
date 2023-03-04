package collections.generic;

public interface List<T> {
    void add(T item);
    T elementAt(int index) throws IndexOutOfBoundsException;
    void delete(T item) throws Exception;
    boolean tryDelete(T item) throws Exception;
    boolean exist(T item) throws Exception;
}
