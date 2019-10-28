package homework;

public class StackCustom<E> extends ArrayListCustom<E> {

    public StackCustom() {};

    public void push(E item) {
        add(item);
    }

    public synchronized E pop() {
        E e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    public int size(E item) {
        return size();
    }
}
