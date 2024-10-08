package com.wyz.tree;

import java.util.LinkedList;

/**
 * com.wyz.tree
 * Created by jax on 2020/3/31 17:16
 * TODO:VAL平衡二叉树，平衡因子绝对值小于2
 * 最小不平衡树：距离插入节点最近，切平衡因子的绝对值大于1的节点为根的子树
 */
public class AVLBTree<E extends Comparable<E>> {
    Node<E> root;
    int size = 0;
    private static final int LH = 1;
    private static final int RH = -1;
    private static final int EH = 0;

    public static void main(String[] args) {
//        Integer[] nums={5,8,2,0,1,-2};
        Integer[] nums = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
        AVLBTree<Integer> tree = new AVLBTree<>();
        for (int i = 0; i < nums.length; i++) {
            tree.insertElement(nums[i]);
        }
        showAVL((Node) tree.root);

    }

    //左旋转
    public void left_rotate(Node<E> x) {
        if (x != null) {
            Node<E> y = x.right;//先取到Y结点
            // 1、把贝塔作为X的右孩子
            x.right = y.left;
            if (y.left != null) {
                y.left.parent = x;
            }
            // 2、把Y移到原来X的位置
            y.parent = x.parent;
            if (x.parent == null) {
                root = y;
            } else {
                if (x.parent.left == x) {
                    x.parent.left = y;
                } else if (x.parent.right == x) {
                    x.parent.right = y;
                }
            }
            //3、X作为Y的左孩子
            y.left = x;
            x.parent = y;
        }
    }

    //右旋转
    public void right_rotate(Node<E> y) {
        if (y != null) {
            Node<E> x = y.left;
            //1、把贝塔作为y的左子节点
            y.left = x.right;
            if (x.right != null) {
                x.right.parent = y;
            }

            // 2、把X移到原来y的位置
            x.parent = y.parent;
            if (y.parent == null) {
                root = x;
            } else {
                if (y.parent.left == y) {
                    y.parent.left = x;
                } else if (y.parent.right == y) {
                    y.parent.right = x;
                }
            }
            // 3、把y作为x的右子节点
            x.right = y;
            y.parent = x;
        }
    }

    //左平衡
    public void leftBalance(Node<E> t) {
        Node<E> tl = t.left;
        switch (tl.balance) {
            case LH:
                right_rotate(t);
                tl.balance = EH;
                t.balance = EH;
                break;
            case RH:
                Node<E> tlr = tl.right;
                switch (tlr.balance) {
                    case LH:
                        t.balance = RH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;
                    case RH:
                        t.balance = EH;
                        tl.balance = LH;
                        tlr.balance = EH;
                        break;
                    case EH:
                        t.balance = EH;
                        tl.balance = EH;
                        tlr.balance = EH;
                        break;

                    default:
                        break;
                }
                left_rotate(t.left);
                right_rotate(t);
                break;
        }

    }

    public void rightBalance(Node<E> t) {
        Node<E> tr = t.right;
        switch (tr.balance) {
            case RH://新的结点插入到t的右孩子的右子树中
                left_rotate(t);
                t.balance = EH;
                tr.balance = EH;
                break;
            case LH://新的结点插入到t的右孩子的左子树中
                Node<E> trl = tr.left;
                switch (trl.balance) {
                    case RH:
                        t.balance = LH;
                        tr.balance = EH;
                        trl.balance = EH;
                        break;
                    case LH:
                        t.balance = EH;
                        tr.balance = RH;
                        trl.balance = EH;
                        break;
                    case EH:
                        tr.balance = EH;
                        trl.balance = EH;
                        t.balance = EH;
                        break;

                }
                right_rotate(t.right);
                left_rotate(t);
                break;

        }
    }

    public boolean insertElement(E element) {
        Node<E> t = root;
        if (t == null) {
            root = new Node<E>(element, null);
            size = 1;
            root.balance = 0;
            return true;
        } else {
            //开始找到要插入的位置
            int cmp = 0;
            Node<E> parent;
            Comparable<? super E> e = (Comparable<? super E>) element;
            do {
                parent = t;
                cmp = e.compareTo(t.elemet);
                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return false;
                }
            } while (t != null);
            //开始插入数据
            Node<E> child = new Node<E>(element, parent);
            if (cmp < 0) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            //节点已经放到了树上
            //检查平衡，回溯查找
            while (parent != null) {
                cmp = e.compareTo(parent.elemet);
                if (cmp < 0) {
                    parent.balance++;
                } else {
                    parent.balance--;
                }
                if (parent.balance == 0) {//如果插入后还是平衡树，不用调整
                    break;
                }
                if (Math.abs(parent.balance) == 2) {
                    //出现了平衡的问题，需要修正
                    fixAfterInsertion(parent);
                    break;
                } else {
                    parent = parent.parent;
                }
            }
        }
        size++;
        return true;
    }

    private void fixAfterInsertion(Node<E> parent) {
        if (parent.balance == 2) {
            leftBalance(parent);
        }
        if (parent.balance == -2) {
            rightBalance(parent);
        }
    }


    public static void showAVL(Node root) {
        LinkedList<Node> list = new LinkedList<Node>();
        list.offer(root);//队列放入
        while (!list.isEmpty()) {
            Node node = list.pop();//队列的取出
            System.out.println(node.elemet);
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }
    }

    public static class Node<E extends Comparable<E>> {
        E elemet;
        int balance = 0;//平衡因子
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E elem, Node<E> pare) {
            this.elemet = elem;
            this.parent = pare;
        }

        public E getElemet() {
            return elemet;
        }

        public void setElemet(E elemet) {
            this.elemet = elemet;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

    }
}
