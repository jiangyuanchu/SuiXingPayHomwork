package homework;


import java.util.*;
import java.util.function.Consumer;

public class ArrayListCustom<E> implements SelfList<E>, Iterable<E>{

    //默认容量为10
    private static final int DEFAULT_CAPACITY = 10;

    //空缓冲区
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认容量空缓冲区
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //数据缓冲区
    transient Object[] elementData;

    //集合大小
    private int size;

    //无参构造方法
    public ArrayListCustom(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    //有参构造方法——传递集合
    public ArrayListCustom(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    //有参构造方法——指定大小
    public ArrayListCustom(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    //添加元素
    @Override
    public boolean add(E e) {
        //容量校验
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    //移除元素
    @Override
    public E remove(int index) {
        //索引检查
        rangeCheck(index);
        //保存数据
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            //数组复制：源数组，源数组要复制的起始位置，目标数组，目标数组复制的起始位置，要复制的长度
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    //获取指定位置的元素
    @Override
    public E get(int index) {
        //索引检查
        rangeCheck(index);

        return elementData(index);
    }

    //设置指定位置的元素
    @Override
    public E set(int index, E element) {
        //索引检查
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    //获取集合大小
    @Override
    public int size() {
        return size;
    }

    //判断是否包含某个元素
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    //最大集合容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //集合自动扩容
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        //位移运算，扩容为原来的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    //最大集合容量判断
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    //容量校验
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    //扩容条件检验
    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    //索引检查
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    //异常信息处理
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    //获取集合缓冲区数据
    E elementData(int index) {
        return (E) elementData[index];
    }

    //遍历数组查找元素
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    //迭代功能
    @Override
    public Iterator<E> iterator() {

        //内部类——迭代器
        class Itr implements Iterator<E> {
            int cursor;       // index of next element to return
            int lastRet = -1; // index of last element returned; -1 if no such
            int expectedModCount = size;

            public boolean hasNext() {
                return cursor != size;
            }

            @SuppressWarnings("unchecked")
            public E next() {
                checkForComodification();
                int i = cursor;
                if (i >= size)
                    throw new NoSuchElementException();
                Object[] elementData = ArrayListCustom.this.elementData;
                if (i >= elementData.length)
                    throw new ConcurrentModificationException();
                cursor = i + 1;
                return (E) elementData[lastRet = i];
            }

            public void remove() {
                if (lastRet < 0)
                    throw new IllegalStateException();
                checkForComodification();

                try {
                    ArrayListCustom.this.remove(lastRet);
                    cursor = lastRet;
                    lastRet = -1;
                    expectedModCount = size;
                } catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }

            final void checkForComodification() {
                if (size != expectedModCount)
                    throw new ConcurrentModificationException();
            }
        }
        //返回迭代器
        return new Itr();
    }
}
