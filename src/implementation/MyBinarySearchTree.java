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
            inOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            inOrder(node.getRight());
        }
    }

    @Override
    public void preOrder(implementation.Node<E> node) {
        if (node != null) {
            System.out.print(node.getData() + ", ");
            inOrder(node.getLeft());
            inOrder(node.getRight());
        }
    }

    @Override
    public void postOrder(implementation.Node<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            inOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

    @Override
    public void reverseInOrder(implementation.Node<E> node) {
        if (node != null) {
            inOrder(node.getRight());
            System.out.print(node.getData() + ", ");
            inOrder(node.getLeft());
        }
    }

    @Override
    public void delete(E data) {
        implementation.Node<E> temp = root;
        implementation.Node<E> parent = null;
        while (temp != null) {
            if (data.compareTo(temp.getData()) == 0) {
                break;
            } else {
                parent = temp;
                if (data.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        if(temp != null){
            //case 1

            if(isLeaf(temp)){
                //root node
                if(parent == null){
                    root = null;
                }
                else{
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(null);
                    }
                    else{
                        parent.setRight(null);
                    }
                }
            }
            //case 2
            //left child
            else if(hasLeftChild(temp)){
                //root node
                if(parent == null){
                    root = root.getLeft();
                }
                else{
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(temp.getLeft());
                    }
                    else{
                        parent.setRight(temp.getLeft());
                    }
                }
            }
            //right child
            else if(hasRightChild(temp)){
                //root case
                if(parent == null){
                    root = root.getRight();
                }
                else {
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(temp.getRight());
                    }
                    else{
                        parent.setRight(temp.getRight());
                    }
                }
            }
            //case 3 two children
            else{
                implementation.Node<E> successor = getSuccessor(temp);
                //delete successor
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                //root case
                if(parent == null){
                    root = successor;
                }
                else{
                    if(data.compareTo(parent.getData()) < 0){
                        parent.setLeft(successor);
                    }
                    else{
                        parent.setRight(successor);
                    }
                }
            }
            //root node
        }
        else{
            System.out.println("cannot delete");
        }
    }

    private implementation.Node<E> getSuccessor(implementation.Node<E> node) {
        implementation.Node<E> response = null;
        implementation.Node<E> temp = node.getRight();
        while (temp.getLeft() != null){
            temp = temp.getLeft();
        }
        response = temp;
        return response;
    }

    private boolean hasRightChild(implementation.Node<E> temp) {
        if(temp.getRight() != null && temp.getLeft() == null){
            return true;
        }
        return false;
    }

    private boolean hasLeftChild(implementation.Node<E> temp) {
        if(temp.getLeft() != null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    private boolean isLeaf(implementation.Node<E> temp) {
        if(temp.getLeft() == null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }
}
