package binarytree.io;

import lombok.Data;

/**
 * @Class:Node
 * @Author:chujinlong
 * @Description:
 * @Data:2020/8/14
 */
@Data
public class Node {

    private int data;

    private Node leftNode;

    private Node rightNode;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }


    /**
     * 返回左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (leftNode == null) {
            return 0;
        }
        return leftNode.height();
    }

    /**
     * 返回右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (rightNode == null) {
            return 0;
        }
        return rightNode.height();
    }

    /**
     * 返回以该结点为根结点的树的高度
     *
     * @return
     */
    public int height() {
        int left, right;
        if (leftNode == null) {
            left = 0;
        } else {
            left = leftNode.height();
        }
        if (rightNode == null) {
            right = 0;
        } else {
            right = rightNode.height();
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 左旋
     */
    private void leftRotate() {
        //创建新的结点，赋值当前根结点的值
        Node newNode = new Node(data);
        //把当前结点的左子树设置为新结点的左子树
        newNode.leftNode = leftNode;
        //把当前结点右子树的左子树设置为新结点的右子树
        newNode.rightNode = rightNode.leftNode;
        //把当前结点的值替换成当前右子树结点的值
        data = rightNode.data;
        // 将当前结点的右子树的右子树设置为当前结点的右子树
        rightNode = rightNode.rightNode;
        //把当前结点的左子树设置为新的结点
        leftNode = newNode;
    }


    /**
     * 右旋
     */
    private void rightRotate() {
        //创建新的结点，赋值当前根结点的值
        Node newNode = new Node(data);
        //把当前结点的右子树设置为新结点的右子树
        newNode.rightNode = rightNode;
        //把当前结点左子树的右子树设置为新结点的左子树
        newNode.leftNode = leftNode.rightNode;
        //把当前结点的值替换成当前左子树结点的值
        data = leftNode.data;
        // 将当前结点的左子树的左子树设置为当前结点的左子树
        leftNode = leftNode.leftNode;
        //把当前结点的右子树设置为新的结点
        rightNode = newNode;
    }

    /**
     * 查找要删除的结点
     *
     * @param data
     * @return
     */
    public Node search(int data) {
        if (data == this.data) {//找到该结点
            return this;
        } else if (data < this.data) {//如果查找的值小于当前结点，向左子树递归查找
            //如果左子结点为空
            if (this.leftNode == null) {
                return null;
            }
            return this.leftNode.search(data);
        } else {//如果查找的值不小于当前结点，向右子树递归查找
            if (this.rightNode == null) {
                return null;
            }
            return this.rightNode.search(data);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param data
     * @return
     */
    public Node searchParent(int data) {
        //如果当前节点就是要删除的结点的父结点
        if ((this.leftNode != null && this.leftNode.data == data) || (this.rightNode != null && this.rightNode.data == data)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前结点的左子结点不为空
            if (data < this.data && this.leftNode != null) {
                return this.leftNode.searchParent(data);
            } else if (data > this.data && this.rightNode != null) {//如果查找的值大于当前节点的值，并且当前结点的右子结点不为空
                return this.rightNode.searchParent(data);
            } else {
                return null;// 没有找到父结点
            }
        }
    }


    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.data < this.data) {
            //如果当前结点左子结点为null
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.addNode(node);
            }
        } else {//添加的结点的值大于当前结点的值
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                //递归的向右子树添加
                this.rightNode.addNode(node);
            }
        }
        //当添加完一个结点后，如果（右子树的高度-左子树的高度）> 1,左旋转
        if ((rightHeight() - leftHeight()) > 1) {//右旋再左旋 RL
            if (rightNode != null && rightNode.leftHeight() > rightNode.rightHeight()) {
                rightNode.rightRotate();
                leftRotate();
            } else {//左旋 LL
                leftRotate();
            }
            return;
        }

        //当添加完一个结点后，如果（左子树的高度-右子树的高度）> 1,右旋转
        if ((leftHeight() - rightHeight()) > 1) {//左旋再右旋 LR
            if (leftNode != null && leftNode.rightHeight() > leftNode.leftHeight()) {
                leftNode.leftRotate();
                rightRotate();
            } else {//右旋 RR
                rightRotate();
            }
            return;
        }
    }

    //中序遍历
    public void middleTraversal() {
        if (this.leftNode != null) {
            this.leftNode.middleTraversal();
        }
        System.err.println(this);
        if (this.rightNode != null) {
            this.rightNode.middleTraversal();
        }
    }

}
