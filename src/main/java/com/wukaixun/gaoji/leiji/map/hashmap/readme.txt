HashMap在进行put()操作的时候是如何进行扩容的?
在HashMap类中提供有一个"DEFAULT_INITIAL_CAPACITY"常量作为初始化的容量配置，常量的默认大小为16，也就是说默认保存的最大长度是16。当保存的内容容量超过某个
阈值(DEFAULT_LOAD_FACTOR(0.75))，相当于"容量 * 阈值" 16 * 0.75 = 12, 也就是说当保存容量超过12的时候就会进行容量的扩充，扩充容量采取倍数增长方式(2倍)

HashMap的工作原理?
HashMap中数据的存储依旧是通过Node类完成的，这种情况下HashMap可使用的数据结构只有两种: 链表(时间复杂度O(n))和二叉树(时间复杂度O(logn))
从JDK1.8开始, HashMap的实现发生了改变，因为其要适应大数据时代的海量数据存储。在HashMap的内部提供了一个TREEIFY_THRESHOLD常量, 默认为8
当存储数据量小于8时，HashMap采用链表结构，当数据量超过8时，HashMap则会将链表转为红黑树以保证数据的查询性能

HashMap在进行数据操作时，遇到Hash冲突，HashMap是如何解决的？
hash值冲突产生在map.put()时，从源码可以看出，hash值时通过hash(key.hashCode())来获取的，当put的元素越来越多时，难免会产生相同的hash值，听过indexFor(hash, table.length)获取
数组下标，先查询是否存在该hash值，如不存在，则直接以Map.Entry<V, V>的方式存放在数组中。若存在，则在对比key是否相同，若key和hash值都相同，则替换value。若key不相同，则形成一个单链表
将hash值相同，key不同的元素以Map.Entry<V, V>的方式存放在链表中，这样就解决了hash冲突，这种方法叫分离链表法。与之类似的还有开放定址法，开放定址法采用线性探测(从相同hash值开始，继续
寻找下一个可用的槽位)，hashMap是数组，长度虽可扩大，但用线性探测法去探测槽位可能会查找不到，因此采用了分离链表法

