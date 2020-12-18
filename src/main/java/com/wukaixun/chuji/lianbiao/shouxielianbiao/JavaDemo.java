//package learning.lianbiao.shouxielianbiao;
//
///**
// * 手写链表
// *
// * @author wukaixun
// * @date 2020.09.29
// */
//interface ILink<E> {
//    public void add(E e);  // 添加节点元素
//
//    public int size();  // 计算链表长度
//
//    public boolean isEmpty(); // 判断是否为空
//
//    public Object[] toArray();  // 转链表为Object对象数组
//
//    public E get(int index); // 根据下标查找数据
//
//    public void update(int index, E data); // 修改指定下标元素数据
//
//    public boolean contains(E data); // 判断数据是否存在
//}
//
//
//class LinkImpl<E> implements ILink<E> {
//    private class Node {
//        private E data;
//        private Node next;
//
//        public Node(E data) {
//            this.data = data;
//        }
//
//        public void addNode(Node newNode) {
//            if (this.next == null) { // 当前节点的下一个节点为空
//                this.next = newNode;  // 直接保存到当前节点
//            } else { // 如果当前节点下一个节点不为空
//                this.next.addNode(newNode);  // 继续判断下一个节点的下一个节点是否为空，直到找到下一个节点为空的节点后添加
//            }
//        }
//
//        public void toArrayNode() {
//            LinkImpl.this.returnArray[LinkImpl.this.foot++] = this.data;
//            if (this.next != null) { // 递归下一个节点
//                this.next.toArrayNode();
//            }
//        }
//
//        public E getNode(int index){
//            if(LinkImpl.this.foot ++ == index){
//                return this.data;
//            } else{
//                return this.next.getNode(index);
//            }
//        }
//
//        public void updateNode(int index, E data){
//            if(LinkImpl.this.foot ++ == index){
//                this.data = data;
//            } else{
//                this.next.updateNode(index, data);
//            }
//        }
//
//        public boolean containsNode(E data){
//            if(this.data.equals(data)){
//                return true;
//            } else {  // 递归下一个节点
//                if(this.next == null){  // 下一个节点为空
//                    return false;  // 没找到对应数据节点
//                } else {
//                    return this.next.containsNode(data);
//                }
//            }
//        }
//    }
//
//    // -----以下为Link类中定义的成员
//    private Node root;  // 根元素
//    private int count;  // 链表长度
//    private int foot; // 节点角标
//    private Object[] returnArray;  // toArray方法返回数据
//
//    //------以下为Link类中定义的方法
//    public void add(E e) {
//        if (e == null) {  // 如果要保存的数据为空，直接返回
//            return;
//        }
//        // 数据本身不具有关联特性，Node类才有，所以需要创建一个新的Node对象
//        Node newNode = new Node(e);
//        if (this.root == null) { // 没有根节点，第一个节点作为根节点
//            this.root = newNode;
//        } else {  // 如果有根节点
//            this.root.addNode(newNode);
//        }
//        this.count++;
//    }
//
//    public int size() {
//        return this.count;
//    }
//
//    public boolean isEmpty() {
//        return this.root == null;
//    }
//
//    public Object[] toArray() {
//        if (this.isEmpty()) {  // 链表为空直接返回空
//            return null;
//        }
//        this.foot = 0; // 角标清零
//        this.returnArray = new Object[this.count];
//        this.root.toArrayNode();
//        return this.returnArray;
//    }
//
//    public E get(int index) {
//        if (index >= this.count) {  // 如果下标超过链表长度，抛出异常
//            throw new ArrayIndexOutOfBoundsException();
//        }
//        this.foot = 0;
//        return this.root.getNode(index);
//    }
//
//    public void update(int index, E data){
//        if (index >= this.count) {  // 如果下标超过链表长度，抛出异常
//            throw new ArrayIndexOutOfBoundsException();
//        }
//        this.foot = 0;
//        this.root.updateNode(index, data);
//    }
//
//    public boolean contains(E data){
//        return this.root.containsNode(data);
//    }
//}
//
//
//public class JavaDemo {
//    public static void main(String[] args) {
//        ILink<String> all = new LinkImpl<String>();
//        System.out.println("添加前长度:" + all.size());
//        System.out.println("是否为空:" + all.isEmpty());
//        all.add("吴凯勋");
//        all.add("宋鑫龙");
//        all.add("朱玉");
//        System.out.println("添加后长度:" + all.size());
//        System.out.println("是否为空:" + all.isEmpty());
//        Object[] res = all.toArray();
//        for (Object i : res) {
//            System.out.println(i);
//        }
//        System.out.println("-----根据下标获取数据分割线-------");
//        System.out.println("下标0 :" + all.get(0));
////        System.out.println(all.get(3));
//
//        System.out.println("------更新元素分割线-------");
//        System.out.println("更新前数据:" + all.get(0));
//        all.update(0, "陈琪");
//        System.out.println("更新后数据:" + all.get(0));
//
//        System.out.println("------判断数据是否存在分割线-----");
//        System.out.println("陈琪是否存在:" + all.contains("陈琪"));
//        System.out.println("呵呵是否存在:" + all.contains("呵呵"));
//    }
//}
