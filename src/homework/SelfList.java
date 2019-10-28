package homework;

import java.util.Iterator;

public interface SelfList<E> {

    /**
     * 向集合中添加元素
     * @param e 元素内容
     * @return 是否添加成功
     */
    public boolean add(E e);

    /**
     * 移除指定位置的元素
     * @param index 元素位置
     * @return 被移除的元素
     */
    public E remove(int index);

    /**
     * 得到指定位置的元素
     * @param index 元素位置
     * @return 指定位置的元素
     */
    public E get(int index);

    /**
     * 设置指定位置的元素
     * @param index 指定位置
     * @param element 设置的值
     * @return 修改后元素的值
     */
    public E set(int index, E element);

    /**
     * 获取元素大小
     * @return 元素大小
     */
    public int size();

    /**
     * 判断是否包含某个元素
     * @param o 需要判断的值
     * @return 是否包含 ? true : false
     */
    boolean contains(Object o);

}
