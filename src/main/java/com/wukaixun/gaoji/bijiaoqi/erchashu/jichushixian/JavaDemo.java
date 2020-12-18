package com.wukaixun.gaoji.bijiaoqi.erchashu.jichushixian;

import java.util.Arrays;

/**
 * 二叉树基础实现
 *
 * @author wukaixun
 * @date 2020.10.20
 */
public class JavaDemo {
    public static void main(String[] args) {
        BinaryTree<Person> binaryTree = new BinaryTree<>();
        binaryTree.add(new Person("Person80", 80));
        binaryTree.add(new Person("Person50", 50));
        binaryTree.add(new Person("Person60", 60));
        binaryTree.add(new Person("Person30", 30));
        binaryTree.add(new Person("Person90", 90));
        binaryTree.add(new Person("Person10", 10));
        binaryTree.add(new Person("Person55", 55));
        binaryTree.add(new Person("Person70", 70));
        binaryTree.add(new Person("Person85", 85));
        binaryTree.add(new Person("Person95", 95));
        binaryTree.delete(new Person("Person80", 80));
        System.out.println(Arrays.toString(binaryTree.toArray()));
    }
}

class BinaryTree<T> {
    class Node {
        private Comparable<T> data;
        private Node parent;  // 父节点
        private Node left;  // 左子树
        private Node right;  // 右子树

        public Node(Comparable<T> data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) <= 0) { // 新节点数据小于或等于根节点 要放左子树
                if (this.left == null) { // 当前节点左子树为空 直接保存
                    this.left = newNode;
                    newNode.parent = this;
                } else { // 当前节点左子树不为空，递归查找直到找到空左子树
                    this.left.addNode(newNode);
                }
            } else { // 新节点数据大于根节点 存放右子树
                if (this.right == null) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void toArrayNode() {
            if (this.left != null) {  // 先遍历左子树
                this.left.toArrayNode();
            }
            BinaryTree.this.returnArray[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {  // 后遍历右子树
                this.right.toArrayNode();
            }
        }

        public Node getRemoveNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
                return this;
            } else if (data.compareTo((T) this.data) < 0) {
                if (this.left != null) {
                    return this.left.getRemoveNode(data);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.getRemoveNode(data);
                } else {
                    return null;
                }
            }
        }
    }

    private Node root; // 根节点
    private int count;  // 记录数据数
    private int foot = 0;
    private Object[] returnArray;

    /**
     * @param data 要添加的数据对象
     * @throws 添加数据为null时抛出NullPointerException
     */
    public void add(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException("添加数据为空!");
        }
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        count++;
    }

    public Object[] toArray() {
        if (this.count == 0) {
            return null;
        }
        this.foot = 0;
        this.returnArray = new Object[this.count];
        this.root.toArrayNode();
        return returnArray;
    }

    /**
     * 删除二叉树节点
     *
     * @param data 要删除的数据
     *             删除分三种情况
     *             -| 被删除节点无子树
     *             -| 被删除节点只有左子树或右子树
     *             -| 被删除节点左右子树全有
     */
    public void delete(Comparable<T> data) {
        Node deleteNode = root.getRemoveNode(data);  // 首先找到要删除的节点
        if (this.root == null) {
            return;
        }
        if (this.root.data.compareTo((T) data) == 0) {  // 要删除的节点是根节点
            System.out.println("要删除的是根节点");
            Node moveNode = this.root.right;
            while (moveNode.left != null) {
                moveNode = moveNode.left;
            }
            moveNode.left = this.root.left;  // 移动节点的左子树连接到根节点左子树
            moveNode.right = this.root.right;  // 移动节点右子树连接到根节点右子树
            moveNode.parent.left = null;  // 移动节点原父节点左子树清空
            this.root.left.parent = moveNode;  // 原根节点左子树父节点改为移动节点
            this.root.right.parent = moveNode;  // 原根节点右子树父节点改为移动节点
            moveNode.parent = null;  // 移动节点父节点清空
            this.root = moveNode; // 改变根节点
        } else {
            if (deleteNode.left == null && deleteNode.right == null) {  // 被删节点无左右子树
                if (deleteNode.parent.left == deleteNode) {  // 被删节点是左节点
                    deleteNode.parent.left = null;  // 断开父节点对被删节点的链接
                }
                if (deleteNode.parent.right == deleteNode) {  // 被删节点是右节点
                    deleteNode.parent.right = null;  // 断开父节点对被删节点的链接
                }
                deleteNode.parent = null; // 断开父节点链接
            } else if (deleteNode.left != null && deleteNode.right == null) { // 被删节点有左子树没有右子树
                deleteNode.parent.left = deleteNode.left; // 被删节点左子树连接到被删节点的父节点的左子树
                deleteNode.left.parent = deleteNode.parent; // 被删节点左子树的父节点改为被删节点的父节点
                deleteNode.parent = null;  // 断开父节点链接
                deleteNode.left = null; // 断开左子树链接
            } else if (deleteNode.left == null && deleteNode.right != null) {  // 被删节点有右子树没有左子树
                deleteNode.parent.right = deleteNode.right; // 被删节点右子树连接到被删节点父节点的右子树
                deleteNode.right.parent = deleteNode.parent;  // 被删节点的右子树父节点改为被删节点的父节点
                deleteNode.parent = null; //断开父节点引用
                deleteNode.right = null; // 断开右子树引用
            } else { // 当被删节点左右子树都有时，要顶替原位置的是被删节点右子树上最底层左子树的节点(也就是在右子树上大于原节点的数据中选出最小值)
                Node moveNode = deleteNode.right;  // 选取被删节点右节点作为一个移动节点
                while (moveNode.left != null) { // 当移动节点左节点不为空时，递归取得最底层左节点
                    moveNode = moveNode.left;
                }
                if (deleteNode.parent.left == deleteNode) { // 被删节点是左节点
                    deleteNode.parent.left = moveNode;  // 移动节点连接到父节点左子树
                    moveNode.parent = deleteNode.parent; // 移动节点的父节点改为被删节点父节点
                    moveNode.left = deleteNode.left; // 移动节点左子树连接到被删节点左子树
                    moveNode.right = deleteNode.right;  // 移动节点右子树连接到被删节点右子树
                    deleteNode.left.parent = moveNode; // 被删节点左子树父节点改为移动节点
                    deleteNode.right.parent = moveNode; // 被删节点右子树父节点改为移动节点

                }
                if (deleteNode.parent.right == deleteNode) { // 被删节点是右节点
                    deleteNode.parent.right = moveNode;  // 移动节点连接到父节点右子树
                    moveNode.parent = deleteNode.parent; // 同上
                    moveNode.left = deleteNode.left; // 同上
                    moveNode.right = deleteNode.right;  // 同上
                    deleteNode.left.parent = moveNode;  // 同上
                    deleteNode.right.parent = moveNode; // 同上
                }
                deleteNode.parent = null;
                deleteNode.left = null;
                deleteNode.right = null;
            }
        }
        this.count--; // 删除节点后数据量-1
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[Person对象] 姓名:" + this.name + "年龄:" + this.age + "\n";
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }
}
