package com.wyz.test;


import java.util.LinkedList;

/**
 * com.wyz.test
 * Created by jax on 2020/4/28 14:06
 * TODO:
 */
public class SBTreeTest {
    public static TreeNode root;

    public class TreeNode {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;
        public TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }
    }

    public TreeNode put(int data) {
        TreeNode node;
        TreeNode parent = null;
        if (root == null) {
            node = new TreeNode(data);
            root = node;
            return node;
        }
        node = root;
        while (node != null) {
            parent = node;
            if (data < node.data) {
                node = node.leftChild;
            } else if (data > node.data) {
                node = node.rightChild;
            } else {
                return node;
            }
        }

        node = new TreeNode(data);

        if (data < parent.data) {
            parent.leftChild = node;
        } else {
            parent.rightChild = node;
        }
        node.parent = parent;

        return node;
    }

    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            midOrder(node.leftChild);
            System.out.print(" " + node.data);
            midOrder(node.rightChild);
        }
    }

    public TreeNode searchNode(int data) {

        TreeNode node;
        if (root == null) {
            return null;
        }
        node = root;
        while (node != null && node.data != data) {
            if (data < node.data) {
                node = node.leftChild;
            } else if (data > node.data) {
                node = node.rightChild;
            }
        }

        return node;
    }

    public void delectNode(int data) {
        TreeNode node = searchNode(data);
        if (node == null) {
            System.out.println("没有找到该元素，无法删除");
        } else {
            delect(node);
        }
    }


    private void delect(TreeNode node) {
        if (node == null) {
            System.out.println("没有找到该元素，无法删除");
        } else {
            TreeNode parent = node.parent;

            if (node.leftChild == null && node.rightChild == null) {
                if (parent.leftChild == node) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
                node.parent = null;
            }

            if (node.leftChild != null && node.rightChild == null) {
                if (parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else {
                    parent.rightChild = node.leftChild;
                }
                node.leftChild.parent = parent;
                node.parent = null;
            }

            if (node.leftChild == null && node.rightChild != null) {
                if (parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else {
                    parent.rightChild = node.rightChild;
                }
                node.rightChild.parent = parent;
                node.parent = null;
            }

            if (node.leftChild != null && node.rightChild != null) {
                TreeNode next = getNextNode(node);
                System.out.println("查找到下一个元素为：" + next.data);
                delect(next);
                node.data = next.data;
            }


        }
    }

    private TreeNode getNextNode(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            if (node.rightChild != null) {
                return getMinNode(node.rightChild);
            } else {
                //查找后继节点
                TreeNode parent = node.parent;
                while (parent.leftChild != node) {
                    node = parent;
                    parent = node.parent;
                }
                return parent;
            }
        }
    }

    private TreeNode getMinNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    public void showHierarchy(TreeNode treeNode) {
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

    public static void main(String[] args) {
        SBTreeTest tree = new SBTreeTest();
        int[] arr = new int[]{60, 12, 30, 63, 55, 99, 3};
        for (int i = 0; i < arr.length; i++) {
            tree.put(arr[i]);
        }

        tree.showHierarchy(root);
        tree.midOrder(root);

        TreeNode treeNode = tree.searchNode(30);

        System.out.println("\n查找到元素:" + (treeNode == null ? "null" : treeNode.parent.data));

        tree.delectNode(60);
        tree.showHierarchy(root);
        tree.midOrder(root);

    }
}
