如果在实例化ArrayList类对象时没有传入初始化长度，则默认情况下会使用一个空数组。当增加数据时候发现数组长度不够了。则会判断当前增长的容量与默认容量的大小，使用较大的一个数值进行增长。
由此得出结论：
jdk1.9之后: ArrayList默认的构造只会使用默认的空数组，使用的时候才会开辟数组，默认的开辟长度为10
jdk1.9之前: ArrayList默认的构造会直接开辟一个长度为10的数组
当ArrayList中保存的容量不足的时候采用成倍增长的方式，原始长度为10，那么下次增长长度就是20。所以在使用ArrayList子类的时候一定要估算数据量，如果长度超过10，尽量传递初始化长度，
以此避免产生垃圾数组空间(数组扩容是开辟一个新长度的数组，再把原数组拷贝到新数组, 拷贝和再指向是要浪费性能的)