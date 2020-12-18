1.Thread类和Runnable接口的关系
 1). Thread类是Runnable的子类
 2). Thread类和用户自定义Runnable子类是典型的代理设计模式，Thread类负责操作系统资源调度工作，用户自定义子类负责真实业务处理
 3). Thread类在调用start方法时最终调用的是用户自定义子类的run方法;


2.Runnable和Callable的区别？
 1). Runnable是JDK1.0时提供的多线程实现接口，而Callable是JDK1.5之后提出的多线程实现接口
 2). java.lang.Runnable接口中只提供run()方法，没有返回值
 3). java.util.concurrent.Callable提供call()方法，有返回值


3.Callable如何实现线程启动即Callable接口和Thread类的联系
在java.util.concurrent包中有FutureTask类，该类实现了RunnableFuture接口， RunnableFuture接口继承了Runnable和Future接口，
FutureTask类的构造方法可以接收一个Callable对象。因此可传递一个FutureTask类对象到Thread类并生成Thread类对象后，即可调用start()
方法

4. Thread类中已经弃用的几个方法
 1) 停止线程 .stop()
 2) 销毁线程 .destroy()
 3) 挂起线程 .suspend()
 4) 恢复线程 .resume()
 废除这些方法的主要原因是这些方法容易引起线程的死锁, 所以从jdk1.2开始就不建议使用了

5. volatile与synchronized有什么区别联系吗?
 1) volatile与synchronized无任何联系, volatile关键字用在定义属性的时候，而synchronized在同步代码块和同步方法上使用
 2) volatile不能实现线程同步，通过强制将当前线程修改后的值写回主存保障内存可见性，通过禁止指令重排的的方式保障有序性。但没有保障原子性。所以被volatile关键字
    修饰的变量也不是线程安全的。
 3) synchronized关键字使得同一时刻只能有一个线程获得当前变量，方法，类的锁，其他线程无法访问，也就无法同步并发执行。synchronized关键字还会创建一个内存屏障，
    内存屏障指令保证了当前线程所有CPU操作结果都会直接刷到主存中，从而保证了操作的内存可见性，同时也使得先获得这个锁的线程的所有操作，都发生在随后获得这个锁的线
    程之前。保障有序性，可见性，原子性；
 3) 但volatile的使用通常不会离开synchronized， 只是用来描述一种更快的变量操作
