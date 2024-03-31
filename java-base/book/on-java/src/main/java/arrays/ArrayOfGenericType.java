package arrays;

/**
 * @author lh
 */
public class ArrayOfGenericType<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //error: generic array creation:
        //- array = new T[size];
//        array = new T[size];
        array= (T[]) new Object[size]; //Unchecked cast

    }

    // error: generic array creation:
//    public <U> U[] makeArray() {
//        return new U[10];
////        return (U[])new Object[10];
//    }
}
