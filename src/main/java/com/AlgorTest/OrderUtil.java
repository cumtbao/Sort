package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class OrderUtil {

    //前序：先根节点，左节点，右节点
    public static void preOrder(Node node){
        if(node != null){
            System.out.print(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    //中序：先左节点，根节点，有节点
    public static void midOrder(Node node){
        if (node != null){
            midOrder(node.left);
            System.out.print(node.value);
            midOrder(node.right);
        }
    }

    //后序：先做节点，右节点，根节点
    public static void lastOrder(Node node){
        if(node !=null){
            lastOrder(node.left);
            lastOrder(node.right);
            System.out.print(node.value);
        }

    }
}
