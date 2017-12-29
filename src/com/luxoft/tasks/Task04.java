package com.luxoft.tasks;

import com.luxoft.search.binarytree.BinaryTree;

public class Task04 {

    public static void main(String[] args) {
        new Task04().Do();
    }

    public void Do() {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.add(10, "1");
        binaryTree.add(5, "2");
        binaryTree.add(4, "3");
        binaryTree.add(6, "4");
        binaryTree.add(15, "5");
        binaryTree.add(13, "6");
        binaryTree.add(12, "7");
        binaryTree.add(11, "8");
        binaryTree.add(14, "9");
        binaryTree.add(17, "10");
        binaryTree.add(40, "11");
        binaryTree.add(20, "12");
        binaryTree.delete(20);

        System.out.print("value of key 40:");
        System.out.println(null != binaryTree.get(40) ? binaryTree.get(40).getValue() : null);
        System.out.print("value of key 20:");
        System.out.println(null != binaryTree.get(20) ? binaryTree.get(20).getValue() : "null");

        System.out.print("horizontal:");
        System.out.println(binaryTree);

        System.out.println("vertical:");
        System.out.println(binaryTree.toVerticalString());
    }
}
