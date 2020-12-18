package com.wukaixun.chuji.lianbiao.shouxielianbiao;

public interface ILink<E> {
    public void add(E e); // 添加节点

    public boolean isEmpty(); // 判断是否为空

    public int size(); // 返回链表长度

    public void remove(E e); // 删除数据

    public E get(int index); // 根据索引获取数据

    public void update(int index, E e); // 更新节点数据

    public Object[] toArray(); // 转普通对象数组

    public boolean contains(E e); // 是否包含某数据
}
