List集合简介：
List的三个子类: 1. ArrayList 2.LinkedList 3.Vector

ArrayList和LinkedList的区别?
1. ArrayList是数组实现的集合操作，LinkedList是链表实现的集合操作
2. 当使用List.get()方法根据索引获取数据时ArrayList的时间复杂度为O(1), LinkedList的时间复杂度为O(n)。
3. 当ArrayList默认初始化长度为10，当长度不足时会采用倍数增长方式扩充长度，如果保存大数据量很可能造成产生垃圾和性能下降，此时可以使用LinkedList子类保存

Vector和ArrayList的区别?
1.Vector类的无参构造默认开辟一个长度为10的数组。
2.Vector的操作多线程情况下是线程安全的，但是性能不如ArrayList