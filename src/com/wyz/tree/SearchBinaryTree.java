package com.wyz.tree;

/**
 * 查找二叉树
 * 左边结点比父结点小，右边结点比父结点大
 */
public class SearchBinaryTree {

    private TreeNode root;

    public class TreeNode{
        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        private int key;
       private int data;
       private TreeNode leftChild;
       private TreeNode rightChild;
       private TreeNode parent;


        public TreeNode(int key, int data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }
    }


    /**
     * 创建查找二叉树，添加结点
     * @param data
     * @return
     */
    public TreeNode put(int data){

        TreeNode node = null;
        TreeNode parent = null;
        //如果根节点不存在就创建根节点
        if (root==null){
            node = new TreeNode(0,data);
            root = node;
            return node;
        }
        //从根节点开始比较，找到要摆放的位置
        node = root;
        while (node!=null){
            parent = node;
            //如果传入数据 < 根结点数据，则摆放数据到该跟结点的左边，否则摆放在右边
            //如果摆放的左边结点不为空，表示已经有左结点了，然后在把左结点作为父结点查找左节点，直到为空
            if (data < node.data){
                node = parent.leftChild;
            }else if (data>node.data){
                node = parent.rightChild;
            }else {
                return parent;
            }
        }

        //创建结点，while已经找到了位置的父结点，根据父结点的大小去判断放到左边还是放到右边
        node = new TreeNode(0,data);
        if (data < parent.data){
            parent.leftChild = node;
        }else{
            parent.rightChild = node;
        }

        node.parent = parent;

        return node;
    }

    /**
     * 删除二叉树里面的结点
     * @return
     */
    public TreeNode remove(){
        return null;
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
     * 查找元素对应的结点
     * @return
     */
    public TreeNode searchNode(int key){
        TreeNode node;
        if (root==null){
            return null;
        }
        node = root;
        //当结点不为空并且node结点的data不等于key，则继续找下去
        while (node !=null && node.getData()!= key){
           if (node.data < key){
               node = node.rightChild;
           }else if (node.data > key){
               node = node.leftChild;
           }
        }

        //返回的结点可能为空，表示没有找到结点
        return node;
    }


    /**
     * 删除key值对应的结点
     * @param key
     */
    public void delectNode(int key){
        TreeNode node = searchNode(key);
        if (node==null){
            System.out.println("该搜索二叉树中没有结点："+key);
        }else {
            delect(node);
        }

    }

    /**
     * 删除node结点，保证树还为查找二叉树
     * @param node
     */
    private void delect(TreeNode node) {
        if (node==null){
            System.out.println("该搜索二叉树中没有对应的结点");
        }else {
            TreeNode parent = node.parent;

            //1、被删除的结点没有左右孩子结点
            if (node.leftChild==null && node.rightChild==null){
                //判断是左还是右节点
                if (parent.leftChild==node){
                    parent.leftChild=null;
                }else {
                    parent.rightChild = null;
                }
            }

            //2、被删除结点有左无右结点
            if (node.leftChild!=null && node.rightChild==null){
                //判断左右结点
                if (parent.leftChild==node){
                    parent.leftChild = node.leftChild;
                }else {
                    parent.rightChild = node.leftChild;
                }

            }

            //3、被删除结点有右无左
            if (node.rightChild!=null && node.leftChild==null){

                //判断左右结点
                if (parent.leftChild==node){
                    parent.leftChild = node.rightChild;
                }else {
                    parent.rightChild = node.rightChild;
                }

            }


            //4、被删除结点左右都有
            if (node.rightChild!=null && node.leftChild!=null){
                TreeNode next = getNextNode(node);
                //递归调用
                delect(next);
                node.data = next.data;
//                next.data = node.data;
            }


        }

    }

    /**
     * 查找node结点的后继结点（排序中紧挨着的那个结点）
     * @param node
     * @return 单独抽出来的函数，不受上面影响
     */
    private TreeNode getNextNode(TreeNode node) {
        if (node==null){
            return null;
        }else {
            //如果node结点存在右孩子，根据中序遍历左父右，在右孩子结点中查找最小的作为node的后继结点
            if (node.rightChild!=null){
                //找到某结点的最小关键字结点，node.rightChild作为根节点传入方法
                return getMinTreeNode(node.rightChild);
            }else {
                //如果node结点不存在右孩子结点：根据中序遍历左父右，所以依次向上找到父结点包含右节点的就为后继结点
                TreeNode parent = node.parent;
                //如果父结点不为空并且父结点的右孩子结点为node结点，继续向上查找父结点的父结点
                //如果根结点无右子结点（父结点没有后继结点）；如果根节点有右子结点，则最右的终端结点无后继结点
                while (parent !=null && node==parent.rightChild){
                    node = parent;
                    parent = parent.parent;
                }
                return parent;

            }

        }
    }

    /**
     * 查找node为根结点中的最小结点元素
     * @param node
     * @return
     */
    private TreeNode getMinTreeNode(TreeNode node) {
        if (node==null){
            return null;
        }else {
            //查找二叉树特性，最左边终端结点一定为最小结点
            while (node.leftChild!=null){
                node = node.leftChild;
            }
            return node;
        }
    }


    public static void main(String[]args){

        SearchBinaryTree binaryTree = new SearchBinaryTree();
        int [] arr = new int[]{60,12,30,63,55,99,3};

        for (int i = 0; i < arr.length; i++) {
            binaryTree.put(arr[i]);
        }
        binaryTree.midOrder(binaryTree.root);
        System.out.println("根结点为："+binaryTree.root.getData());

//       TreeNode node =  binaryTree.searchNode(63);
//       if (node!=null){
//           System.out.println(node.data);
//       }
        System.out.println("=====================");
       binaryTree.delectNode(60);

       binaryTree.midOrder(binaryTree.root);
        System.out.println("删除后根结点为："+binaryTree.root.getData());


    }
}
