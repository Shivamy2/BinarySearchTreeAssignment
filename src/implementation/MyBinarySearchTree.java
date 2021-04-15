package implementation;

import myinterface.BinarySearchTreeADT;
import myinterface.Node;

public class MyBinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
    //complete this class
    private implementation.Node<E> root;

    public implementation.Node<E> getRoot() {
        return root;
    }

    @Override
    public void insert(E data) {
        implementation.Node<E> node = new implementation.Node<>(data);
        if (isEmpty()) {
            root = node;
        } else {
            //traverse and reach the position where new node
            // will be inserted as well as keep reference of parent
            implementation.Node<E> temp = root;
            implementation.Node<E> parent = null;
            while (temp != null) {
                parent = temp;
                if (data.compareTo(temp.getData()) <= 0) {
                    //update temp to refer left subtree
                    temp = temp.getLeft();
                } else {
                    //update temp to refer right subtree
                    temp = temp.getRight();
                }
            }
            //checking whether new node will be left or right
            //child of parent
            if (data.compareTo(parent.getData()) <= 0) {
                //set new node to left child of parent
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    private boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean search(E searchElement) {
        boolean response = false;
        //traverse
        implementation.Node<E> temp = root;
        while (temp != null) {
            if (searchElement.compareTo(temp.getData()) == 0) {
                response = true;
                break;
            } else if (searchElement.compareTo(temp.getData()) < 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return response;
    }

    @Override
    public void inOrder(implementation.Node<E> node) {
        if (node != null) {
            //process the left subtree
            inOrder(node.getLeft());
            // process node data
            System.out.print(node.getData() + ", ");
            //process right subtree
            inOrder(node.getRight());
        }
    }

    @Override
    public void preOrder(Node<E> node) {

    }

    @Override
    public void postOrder(Node<E> node) {

    }

    @Override
    public void reverseInOrder(Node<E> node) {

    }

    @Override
    public void delete(E data) {

    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }
}
