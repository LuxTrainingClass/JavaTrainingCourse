package com.luxoft.tests

import com.luxoft.search.binarytree.BinaryTree

class Task04Test extends GroovyTestCase {
    BinaryTree<Integer, String> binaryTree
    @Override
    protected void setUp() throws Exception {
        super.setUp()
        binaryTree = new BinaryTree<>()

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
    }

    void testBiaryTree() {
        assert binaryTree.toString() == "[4:3, 5:2, 6:4, 10:1, 11:8, 12:7, 13:6, 14:9, 15:5, 17:10, 20:12, 40:11]" as String

        binaryTree.delete(17);
        assert binaryTree.toString() == "[4:3, 5:2, 6:4, 10:1, 11:8, 12:7, 13:6, 14:9, 15:5, 20:12, 40:11]" as String

        assert binaryTree.get(12).getValue() == "7"
    }
}
