package com.wukaixun.chuji.lianbiao.shouxielianbiao;

/**
 * 手写链表 复习 2020.10.10
 *
 * @author wukaixun
 */


public class LinkImpl<E> implements ILink<E> {
    public class Node {
        private E data; // 数据域
        private Node next; // 后续节点

        public Node(E data) {
            this.data = data;
        }

        /**
         * 添加节点
         *
         * @param newNode
         */
        public void addNode(Node newNode) {
            if (this.next == null) {  // 判断当前节点后续节点是否为空
                this.next = newNode;
            } else {  // 递归直到找到后续节点为空的节点
                this.next.addNode(newNode);
            }
        }

        /**
         * 根据索引获取节点数据
         */
        public E getNode(int index) {
            if (LinkImpl.this.foot++ == index) {
                return this.data;
            } else {
                return this.next.getNode(index);
            }
        }

        public void removeNode(Node preNode, E e) {
            if (this.data.equals(e)) {
                preNode.next = this.next;
            } else {
                if (this.next != null) {
                    this.next.removeNode(this, e);
                }
            }
        }

        public void updateNode(int index, E e) {
            if (LinkImpl.this.foot++ == index) {
                this.data = e;
            } else {
                this.next.updateNode(index, e);
            }
        }

        public boolean containsNode(E e) {
            if (this.data.equals(e)) {
                return true;
            } else {
                if (this.next == null) {
                    return false;
                } else {
                    return this.next.containsNode(e);
                }
            }
        }

        public void toNodeArray() {
            LinkImpl.this.returnArray[LinkImpl.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toNodeArray();
            }
        }
    }

    private Node root; // 根节点
    private int count;
    private int foot;
    private Object[] returnArray;

    public void add(E data) {
        if (data == null) {  // 如果要保存的数据为空，直接返回
            return;
        }
        // 数据本身不具有关联特性，Node类才有，所以需要创建一个新的Node对象
        Node newNode = new Node(data);
        if (this.root == null) { // 没有根节点，第一个节点作为根节点
            this.root = newNode;
        } else {  // 如果有根节点
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size() {
        return this.count;
    }

    public E get(int index) {
        if (index >= this.count) {// 索引超出链表长度， 抛出异常
            throw new IndexOutOfBoundsException();
        }
        this.foot = 0; // 重置脚标
        return this.root.getNode(index);
    }

    public void remove(E e) {
        if (!this.contains(e)) {
            throw new NullPointerException();
        }
        if (this.root.data.equals(e)) {  // 删除节点是根节点
            this.root = this.root.next;
        } else {  // 删除节点非根节点，需要Node类来处理
            this.root.next.removeNode(this.root, e);
        }
        this.count--;
    }

    public void update(int index, E e) {
        if (index >= this.count) {
            throw new IndexOutOfBoundsException();
        }
        this.foot = 0;
        this.root.updateNode(index, e);
    }

    public boolean contains(E e) {
        return this.root.containsNode(e);
    }

    public Object[] toArray() {
        if (this.count == 0) {
            return null;
        }
        this.foot = 0;
        this.returnArray = new Object[this.count];
        this.root.toNodeArray();
        return this.returnArray;
    }


}


//public class JavaDemo2 {
//    public static void main(String[] args) {
//        ILink<String> link = new LinkImpl<>();
//        System.out.println("添加前长度:" + link.size());
//        System.out.println("是否为空:" + link.isEmpty());
//        link.add("吴凯勋");
//        link.add("陈琪");
//        link.add("王培培");
//        System.out.println("添加后长度:" + link.size());
//        System.out.println("是否为空:" + link.isEmpty());
//
//        System.out.println("------根据下标获取数据-------");
//        System.out.println("下标2:" + link.get(2));
//        System.out.println("------根据下标更新数据-------");
//        link.update(2, "朱玉");
//        System.out.println("下标2:" + link.get(2));
//
//        System.out.println("------是否包含数据--------");
//        System.out.println("朱玉:" + link.contains("朱玉"));
//
//        System.out.println("------转普通对象数据-------");
//        Object[] res = link.toArray();
//        for (Object obj : res) {
//            System.out.println("obj:" + obj);
//        }
//
//        System.out.println("-------删除节点------");
//        System.out.println("删除前链表长度:" + link.size());
//        link.remove("朱玉");
//        System.out.println("删除后链表长度:" + link.size());
//        Object[] res1 = link.toArray();
//        for(Object obj: res1){
//            System.out.println("obj:" + obj);
//        }
//    }
//}
