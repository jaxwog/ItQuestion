package com.wyz.test;


import java.util.LinkedList;

/**
 * com.wyz.test
 * Created by jax on 2020/5/7 10:20
 * TODO:红黑树添加，删除
 */
public class TestBlackTree<E extends Comparable<E>> {
    private static final boolean RED   = false;
    private static final boolean BLACK = true;
    Node<E> root;
    int     size ;

    public static void main(String[] args) {
        Integer[] nums={3,2,1,4,5,6,7,10,9};
        TestBlackTree<Integer> tree=new TestBlackTree<>();
        for(int i=0;i<nums.length;i++){
            System.out.println("==================插入了元素："+nums[i]);
            tree.insertElement(nums[i]);
            tree.showAVL(tree.root);
        }

        tree.remove(1);
        System.out.println("==================删除了元素：1");
        tree.showAVL(tree.root);
//        tree.LDR(tree.root);

//        tree.showAVL(tree.root);
    }

    public void LDR(Node node){
        if (node==null){
            return;
        }else {
            LDR(node.left);
            System.out.println(node.elemet);
            LDR(node.right);
        }
    }

    public  void showAVL(Node root) {
        LinkedList<Node> list = new LinkedList<Node>();
        list.offer(root);//队列放入
        while (!list.isEmpty()) {
            Node node = list.pop();//队列的取出
            System.out.println(node.elemet+" ，"+ (node.color ? "黑色":"红色") );
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }
    }

    //按照二叉排序树的方式插入一个节点（新节点都为红色）
    public boolean insertElement(E elemet) {
      Node<E> t = root;
        if (t == null) {
            //如果插入的是根结点，直接将节点涂黑
            root = new Node<E>(elemet, null);
            root.color = BLACK;
            size = 1;
            return true;
        }
        //找到需要添加的位置信息
        int cmp;//比较大小，查找插入位置
        Node<E> parent;
        //比较大小
        Comparable<? super E> e = elemet;
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
        //循环结束后t=null，parent指向了最后位置，是child父节点
       Node<E> child = new Node<E>(elemet, parent);
        if (cmp < 0) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        //进行红黑树的调整
        fixAfterInsertion(child);
        size++;
        return true;
    }



    private void fixAfterInsertion(Node<E> x) {
        //插入的节点的父节点是红色（root节点没有父节点）
        while (x!=null && x!=root && x.parent.color==RED){
            //父节点是祖父节点的左孩子
            if (parentOf(x)==leftOf(parentOf(parentOf(x)))){
                //y表示叔叔节点，此时y是祖父节点的右子节点
                Node<E> y = rightOf(parentOf(parentOf(x)));
                //如果叔叔节点y是红色
                if (colorOf(y)==RED){
                    //叔叔和父节点涂黑，祖父节点涂红，当前节点指向祖父节点
                    setColor(parentOf(x),BLACK);
                    setColor(y,BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    x = parentOf(parentOf(x));
                }else {
                    //else 如果叔叔节点y是黑色

                    //如果当前节点是父节点的右子节点
                   if (x==rightOf(parentOf(x))){
                      // 当前节点指向父节点，当前节点进行左旋
                       x = parentOf(x);
                       left_rotate(x);
                   }
                   //父节点涂黑，祖父节点涂红，祖父节点进行右旋
                       setColor(parentOf(x), BLACK);
                       setColor(parentOf(parentOf(x)), RED);
                       right_rotate(parentOf(parentOf(x)));
                }
                //父节点是祖父节点的右子节点
            }else {
                Node<E> y = leftOf(parentOf(parentOf(x)));
                //如果叔叔节点是红色
                if (colorOf(y)==RED){
                    setColor(parentOf(x),BLACK);
                    setColor(y,BLACK);
                    setColor(parentOf(parentOf(x)),RED);
                    x = parentOf(parentOf(x));
                }else {
                    if (x==leftOf(parentOf(x))){
                        x = parentOf(x);
                        right_rotate(x);
                    }
                        setColor(parentOf(x), BLACK);
                        setColor(parentOf(parentOf(x)), RED);
                        left_rotate(parentOf(parentOf(x)));

                }
            }
        }
        root.color = BLACK;
    }

    public  void remove(E key) {
       Node<E> p = searchNode(key);
        if (p == null)
            return ;
        deleteNode(p);
    }

    private void deleteNode(Node<E> p) {
        size--;

        if (p.left != null && p.right != null) {
            Node<E> s = successor(p);
            p.elemet = s.elemet;
            p = s;
        }

        // Start fixup at replacement node, if it exists.
        Node<E> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK)
                fixAfterDeletion(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }

    }

    private void fixAfterDeletion(Node<E> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Node<E> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    left_rotate(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib))  == BLACK &&
                        colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        right_rotate(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    left_rotate(parentOf(x));
                    x = root;
                }
            } else { // symmetric
                Node<E> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    right_rotate(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                        colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        left_rotate(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    right_rotate(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }

    private Node<E> successor(Node<E> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Node<E> p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Node<E> p = t.parent;
            Node<E> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private boolean colorOf(Node<E> p) {
        return (p == null ? BLACK : p.color);
    }

    private  Node<E> parentOf(Node<E> p) {
        return (p == null ? null: p.parent);
    }

    private  void setColor(Node<E> p, boolean c) {
        if (p != null)
            p.color = c;
    }

    private  Node<E> leftOf(Node<E> p) {
        return (p == null) ? null: p.left;
    }

    private Node<E> rightOf(Node<E> p) {
        return (p == null) ? null: p.right;
    }

    public Node<E> searchNode(E elemet){
        Node<E> p = root;
        int cmp;
        while (p != null) {
            Comparable<? super E> e = elemet;
            cmp = e.compareTo(p.elemet);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
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
    
    
    
    
    
    
    
    public class Node<E extends Comparable<E>>{
      public   E elemet;
      public Node<E> left;
      public Node<E> right;
      public Node<E> parent;
      public boolean color = RED;

        public Node(E elemet, Node<E> parent) {
            this.elemet = elemet;
            this.parent = parent;
        }
    }
}
