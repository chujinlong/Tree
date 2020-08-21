package binarytree.impl;

import binarytree.io.Node;
import com.alibaba.fastjson.JSON;

/**
 * @Class:
 * @Author:chujinlong
 * @Description:
 * @Data:2020/8/20
 */

public class AVLTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.addNode(node);
        }
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.getLeftNode() == null && root.getRightNode() == null) {
                root = null;
                return;
            }

            //先去找到要删除的结点targetNode
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }

            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.getLeftNode() == null && targetNode.getRightNode() == null) {
                //判断targetNode是父结点的左子结点还是右子结点
                if (parent.getLeftNode() != null && parent.getLeftNode().getData() == value) {
                    parent.setLeftNode(null);
                } else if (parent.getRightNode() != null && parent.getRightNode().getData() == value) {
                    parent.setRightNode(null);
                }
            } else if (targetNode.getLeftNode() != null && targetNode.getRightNode() != null) {//删除有两颗子树的结点
                int minVal = delRightTreeMin(targetNode.getRightNode());
                targetNode.setData(minVal);

            } else {//删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (targetNode.getLeftNode() != null) {
                    if (parent != null) {
                        //如果targetNode是parent的左子结点
                        if (parent.getLeftNode().getData() == value) {
                            parent.setLeftNode(targetNode.getLeftNode());
                        } else {//targetNode是parent的右子结点
                            parent.setRightNode(targetNode.getLeftNode());
                        }
                    } else {
                        root = targetNode.getLeftNode();
                    }
                } else {//如果要删除的结点有右子结点
                    if (parent != null) {
                        //    如果targetNode是parent的左子结点
                        if (parent.getLeftNode().getData() == value) {
                            parent.setLeftNode(targetNode.getRightNode());
                        } else {//targetNode是parent的右子结点
                            parent.setRightNode(targetNode.getRightNode());
                        }
                    } else {
                        root = targetNode.getRightNode();
                    }
                }
            }
        }
    }

    /**
     * 删除node为根结点的二叉排序树的最小结点
     *
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左节点，就会找到最小值
        while (target.getLeftNode() != null) {
            target = target.getLeftNode();
        }
        //这时target就指向了最小结点
        //删除最小结点
        delNode(target.getData());
        return target.getData();
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.middleTraversal();
        } else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

//
    public static void main(String[] args) {
        int arr[] = {10, 11, 7, 6, 8, 9};
        //创建一个AvlTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历:");
        avlTree.infixOrder();
        System.out.println("AVL树：" + JSON.toJSONString(avlTree));

        System.out.println("树的高度:" + avlTree.getRoot().height());
        System.out.println("树的左子树高度:" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度:" + avlTree.getRoot().rightHeight());
        System.out.println("当前根结点
