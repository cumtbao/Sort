package com.AlgorTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class TestNode {

    private int[] array = {1,2,3,4,5,6,7,8,9};

    private static List<Node> nodeList = null;

    public static void main(String[] args) {

        TestNode testNode = new TestNode();
        testNode.createErchatTree();

        Node root = nodeList.get(0);
        System.out.println("先序遍历：");
        OrderUtil.preOrder(root);

        System.out.println("中序遍历：");
        OrderUtil.midOrder(root);

        System.out.println("后序遍历：");
        OrderUtil.lastOrder(root);



    }

    public void createErchatTree(){

        nodeList = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new Node(array[i]));
        }

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            //左节点
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            //右节点
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }

        //最后一个父节点单独处理
        int lastParentIndex = array.length/2 -1;
        //左节点
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 +1);
        //如果为奇数的话，才有右节点
        if(array.length % 2 == 1){
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex*2+2);
        }


    }

}
