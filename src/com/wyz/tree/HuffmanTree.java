package com.wyz.tree;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * com.wyz.tree
 * Created by jax on 2020/3/19 09:42
 * TODO:生成哈夫曼树，打印树（一层一层打印）
 * 编码采用左子树采用0，右子树采用1进行编码（从根结点编码）
 */
public class HuffmanTree {
    TreeNode root;

    public static void main(String[] args) {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode<String> node = new TreeNode("good", 50);
        list.add(node);
        list.add(new TreeNode("morning", 10));
        TreeNode<String> node2 = new TreeNode("afternoon", 20);
        list.add(node2);
        list.add(new TreeNode("hell", 110));
        list.add(new TreeNode("hi", 200));
        HuffmanTree tree = new HuffmanTree();
        tree.createHuffManTree(list);
        tree.showHuffman(tree.root);
        tree.getCode(node);
    }

    public TreeNode createHuffManTree(ArrayList<TreeNode> list) {
        while (list.size() > 1) {
            //首先进行排序，树重下往上构建
            Collections.sort(list);
            TreeNode left = list.get(list.size() - 1);
            TreeNode right = list.get(list.size() - 2);
            TreeNode parent = new TreeNode("p", left.weight + right.weight);
            //父节点与子节点建立连接
            parent.leftChild = left;
            left.parent = parent;
            parent.rightChild = right;
            right.parent = parent;
            //删除左右子节点，把创建的父节点作为一个节点放入到list列表中，再进行排序。。。
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        root = list.get(0);
        return list.get(0);
    }


    public void showHuffman(TreeNode treeNode) {
        //队列，先进先出
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(treeNode);//入队
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            System.out.println(node.data);
            if (node.leftChild != null) {
                list.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                list.offer(node.rightChild);
            }
        }

    }

    public void getCode(TreeNode node) {
        TreeNode tNode = node;
        Stack<String> stack = new Stack<>();
        while (tNode != null && tNode.parent != null) {
            //left 0  right 1
            if (tNode.parent.leftChild == tNode) {
                stack.push("0");
            } else if (tNode.parent.rightChild == tNode) {
                stack.push("1");
            }
            tNode = tNode.parent;
        }
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }


    /**
     * 结点
     *
     * @param <T>
     */
    public static class TreeNode<T> implements Comparable<TreeNode<T>> {
        T data;
        int weight;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(T data, int weight) {
            this.data = data;
            this.weight = weight;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        //a negative integer, zero, or a positive integer as this object is less than,
        // equal to, or greater than the specified object.
        @Override
        public int compareTo(@NotNull TreeNode<T> o) {
            if (this.weight > o.weight) {
                return -1;
            } else if (this.weight < o.weight) {
                return 1;
            }
            return 0;
        }
    }
}
