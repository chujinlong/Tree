package binarytree.impl;


import binarytree.api.Tree;
import binarytree.io.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Class:
 * @Author:chujinlong
 * @Description:
 * @Data:2020/8/14
 * @Since:v1.0.0
 */
public class BinaryTree implements Tree {


    private static final List<Integer> list1 = new ArrayList<>();
    private static final List<Integer> list2 = new ArrayList<>();
    private static final List<Integer> list3 = new ArrayList<>();

    public static Node init() {
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;//返回根结点
    }

    public static void printRootNode(Node node) {
        System.out.println("结点数据：" + node.getData());
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    /**
     * 前序遍历:根左右
     *
     * @param root
     * @return
     */
    @Override
    public List<Integer> preTraversal(Node root) {
        list1.add(root.getData());
        if (root.getLeftNode() != null) {
            preTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            preTraversal(root.getRightNode());
        }
        return list1;
    }

    /**
     * 中序遍历:左根右
     *
     * @param root
     * @return
     */
    @Override
    public List<Integer> middleTraversal(Node root) {
        if (root.getLeftNode() != null) {
            middleTraversal(root.getLeftNode());
        }
        list2.add(root.getData());
        if (root.getRightNode() != null) {
            middleTraversal(root.getRightNode());
        }
        return list2;
    }

    /**
     * 后序遍历:左右根
     *
     * @param root
     * @return
     */
    @Override
    public List<Integer> postTraversal(Node root) {
        if (root.getLeftNode() != null) {
            middleTraversal(root.getLeftNode());
        }
        list3.add(root.getData());
        if (root.getRightNode() != null) {
            middleTraversal(root.getRightNode());
        }
        return list3;
    }

    /**
     * 层级遍历（队列）
     *
     * @param root
     * @return
     */
    @Override
    public ArrayList<ArrayList<Integer>> orderByQueue(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.getData());
                if (node.getLeftNode() != null) {
                    queue.offer(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    queue.offer(node.getRightNode());
                }
            }
            result.add(level);
        }
        return result;
    }

    @Override
    public List<Integer> preTraByStack(Node root) {
        return null;
    }

    @Override
    public List<Integer> inOrderByStack(Node root) {
        return null;
    }

    @Override
    public List<Integer> postTraByStack(Node root) {
        return null;
    }

}
