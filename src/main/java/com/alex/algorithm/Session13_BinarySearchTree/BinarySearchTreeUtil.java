package com.alex.algorithm.Session13_BinarySearchTree;

public class BinarySearchTreeUtil {

    private Node root = null;

    public BinarySearchTreeUtil() {
        root = null;
    }


    public void createTree(int[] arrKeys, final int numOfNode) {
        root = null;
        for (int i = 0; i < numOfNode; i++) {
            root = insertNode(root, arrKeys[i]);
        }
    }

    public void insertNode(final int insertKey) {
        root = insertNode(root, insertKey);
    }

    public Node searchNode(final int searchKey) {
        return searchKey(root, searchKey);
    }

    public void deleteNode(final int deleteKey) {
        root = deleteNode(root, deleteKey);
    }

    public void deleteTree() {
        deleteTree(root);
    }

    private void deleteTree(Node root) {
        if (root == null) {
            return;
        }
        deleteTree(root.left);
        deleteTree(root.right);
        root = null;
    }

    public void traversalTree() {
        traversalTree(this.root);
    }

    private void traversalTree(Node root) {
        if (root != null) {
            traversalTree(root.left);
            System.out.println(root.key + " ");
            traversalTree(root.right);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    private Node searchKey(Node root, int searchKey) {
        if (root == null || root.key == searchKey) {
            return root;
        }

        if (searchKey < root.key) {
            return searchKey(root.left, searchKey);
        }

        return searchKey(root.right, searchKey);
    }

    private Node insertNode(Node root, int insertKey) {
        if (root == null) {
            return createNode(insertKey);
        }

        if (insertKey < root.key) {
            return insertNode(root.left, insertKey);
        }

        if (insertKey > root.key) {
            return insertNode(root.right, insertKey);
        }

        return root;

    }

    private Node createNode(final int key) {
        final Node temp = new Node(key);
        return temp;
    }

    private Node deleteNode(Node root, int deleteKey) {
        if (root == null) {
            return root;
        }

        //traverse to delete key
        if (deleteKey < root.key) {
            root.left = deleteNode(root.left, deleteKey);
        } else if (deleteKey > root.key) {
            root.right = deleteNode(root.right, deleteKey);
        } else { // came to delete key, now we delete node
            if (root.left == null) {
                Node temp = root.right;
                root = null; //delete current root
                return temp; //replace by temp;
            } else if (root.right == null) {
                Node temp = root.left;
                root = null; //delete current root
                return temp; //replace by temp
            }
            //replace root by left most node
            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }
        return root;

    }

    private Node minValueNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    static class Node {
        private int key;
        private Node left, right;

        public Node(final int item) {
            this.key = item;
            left = right = null;
        }
    }
}
