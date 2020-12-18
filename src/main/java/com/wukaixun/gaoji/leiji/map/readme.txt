Map的几个子类：HashMap, HashTable, TreeMap, LinkedHashMap

HashMap和Hashtable的区别?
1. HashMap的方法都属于异步操作，非线程安全。HashTable方法都属于同步操作，线程安全
2. HashMap允许保存null，HashTable不允许保存null
3. HashMap继承AbstractMap， HashTable继承Dictionary
4. HashMap没有提供contains方法，只提供containsKey和containsValue方法。HashTable保留contains方法，但效果和containsValue相同
5. HashMap初始化默认长度为16，扩容方式为 16*2^n(n为扩容次数), HashTable初始化默认长度为11, 扩容方式为 原长度*2+1

