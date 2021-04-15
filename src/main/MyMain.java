package main;

import implementation.MyBinarySearchTree;

public class MyMain {
    public static void main(String[] args) {
        //create binary search tree
        MyBinarySearchTree<Integer> myBinarySearchTree = new MyBinarySearchTree<>();
        myBinarySearchTree.insert(50);
        myBinarySearchTree.insert(25);
        myBinarySearchTree.insert(35);
        myBinarySearchTree.insert(60);
        myBinarySearchTree.insert(55);
        myBinarySearchTree.insert(51);
        myBinarySearchTree.insert(70);
        myBinarySearchTree.insert(80);
        // and perform insert, search, traversal, delete
        myBinarySearchTree.inOrder(myBinarySearchTree.getRoot());
        myBinarySearchTree.delete(35);
        myBinarySearchTree.inOrder(myBinarySearchTree.getRoot());
        System.out.println(myBinarySearchTree.search(51));
    }
}
