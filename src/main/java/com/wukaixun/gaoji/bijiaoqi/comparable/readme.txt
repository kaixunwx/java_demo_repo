Comparable接口:
任意的一个类默认情况下是无法使用系统内部类实现的数组比较或排序功能的，是因为没有定义比较规则。所以java为了同一比较规则的定义，提供了Comparable接口
Comparator接口:
Comparator接口是一种挽救型的比较器支持接口，用于解决一些没有实现Comparable接口的类对象的比较或排序功能