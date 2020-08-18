package binarytree.api;

import binarytree.io.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class:
 * @Author:chujinlong
 * @Description:
 * @Data:2020/8/17
 * @Since:v1.0.1
 */
public interface Tree {

    public int size();

    public boolean isEmpty();

    /**
     * 树的深度
     *
     * @return
     */
    public int getHeight();

    /**
     * 前序（递归算法）
     */
    public List<Integer> preTraversal(Node root);

    /**
     * 中序（递归算法）
     */
    public List<Integer> middleTraversal(Node root);

    /**
     * 后序（递归算法）
     */
    public List<Integer> postTraversal(Node root);

    /**
     * 层级遍历（队列）
     */
    public ArrayList<ArrayList<Integer>> orderByQueue(Node root);

    /**
     * 前序（栈，非递归）
     */
    public List<Integer> preTraByStack(Node root);

    /**
     * 中序（栈，非递归）
     */
    public List<Integer> inOrderByStack(Node root);

    /**
     * 后序（栈，非递归）
     */
    public List<Integer> postTraByStack(Node root);

}
