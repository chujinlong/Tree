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

    public Node(int data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}
