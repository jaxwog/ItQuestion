package com.wyz.tree;

import java.util.List;
import java.util.Stack;

/**
 *    二叉树性质
 * 性质1：在二叉树的第i层上至多有2i-1个结点（i>=1）。
 * 性质2：深度为k的二叉树至多有2k-1个结点（k>=1）。
 * 性质3：对任何一颗二叉树T，如果其终端结点数为n0,度为2的	结点	数为n2，则n0 = n2+1.
 * 性质4：具有n个结点的完全二叉树深度为[log2n]+1 ([x]表示不	大于	x的最大整数)。
 * 性质5：如果对一颗有n个结点的完全二叉树（其深度为[log2n]+1）	的结点按层序编号（从第1层到第[log2n]+1层，每层从左到	右），对任意一个结点i(1<=i<=n)有：
         1）.如果i=1,则结点i是二叉树的根，无双亲；如果i>1,则其双亲是结	点[i/2]
         2）.如果2i>n,则结点i无左孩子（结点i为叶子结点）；否则其左孩	子是结点2i。
         3）.如果2i+1>n,则结点i无右孩子；否则其右孩子是结点2i+1。

 */
public class BinaryTree {
    private TreeNode root = null;

    public TreeNode getRoot() {
        return root;
    }
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public BinaryTree() {
       root = new TreeNode(1,"A");
    }

    /**
     * 构建二叉树
     *         A
     *     B       C
     * D      E        F
     */
    public void createBinaryTree(){
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;

    }


    /**
     *                      A
     *             B                 C
     *       D          E       #          F
     *   #     #     #     #            #       #
     *
     *   前序遍历为：ABDECF   增加后为：ABD##E##C#F##
     *
     * 根据list创建前序遍历二叉树
     * @param list
     */
    public void createBinaryTreePre(List<String> list){
             createBinaryTree(list.size(),list);
    }

    private TreeNode createBinaryTree(int size, List<String> list) {
       if (list.size()==0){
           return null;
       }
       String d = list.get(0);
       TreeNode node;
       int index = size - list.size();

       if (d.equals("#")){
            node = null;
            list.remove(0);
            return node;
       }

       node = new TreeNode(index,d);

       if (index==0){
           //创建根结点
           root = node;
       }
       list.remove(0);
       node.leftChild = createBinaryTree(size,list);
       node.rightChild = createBinaryTree(size,list);


       return node;
    }


    /**
     * 求二叉树的高度
     */
    public int getHight(){

        return getHight(root);
    }

    private int getHight(TreeNode node) {

        if (node==null){
            return 0;
        }else {
            int i = getHight(node.leftChild);
            int j = getHight(node.rightChild);
            getHH();
            return i < j ? j+1 : i+1;
        }

    }
     void getHH(){ }

    /**
     * 获取二叉树的结点数
     */

    public int getSize(){
        return getSize(root);
    }

    private int getSize(TreeNode node) {
        if (node==null){
            return 0;
        }else {
            return 1+getSize(node.leftChild)+getSize(node.rightChild);
        }
    }

    /**
     * 前序遍历-----迭代
     * 先打印父结点，然后在打印左子树结点，最后答应右子树结点
     */
    public void preOrder(TreeNode node){
        if (node==null){
            return;
        }else {
            System.out.println("preOrder data : "+node.getData());
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }

    }


    /**
     * 前序遍历——非迭代
     */
    public void nonRecOrder(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            //出栈和进栈
            TreeNode n = stack.pop();//弹出根结点
            //压入子结点
            System.out.println("nonRecOrder data : "+n.getData());
            if(n.rightChild!=null){
                stack.push(n.rightChild);
            }
            if(n.leftChild!=null){
                stack.push(n.leftChild);
            }
        }
    }

    /**
     *中序遍历
     * 先打印最左边的终端结点、其次打印父结点、再打印右边终端节点
     */
    public void midOrder(TreeNode node){
        if (node==null){
            return;
        }else {
            midOrder(node.leftChild);
            System.out.println("midOrder data : "+node.getData());
            midOrder(node.rightChild);
        }

    }

    /**
     * 后序遍历
     * 先打印最左边的终端结点、其次打印右边终点结点、最后打印父结点
     */
    public void postOrder(TreeNode node){
        if (node==null){
            return;
        }else {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println("postOrder data : "+node.getData());
        }
    }



    public class TreeNode{
        private int index;//标志
        private String data;//数据域
        private TreeNode leftChild;//左指针
        private TreeNode rightChild;//右指针
        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
