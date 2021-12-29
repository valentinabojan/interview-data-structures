package org.example.tree;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BinarySearchTreeOperations {

    public boolean isBinarySearchTree(Node<Integer> root) {
        return isBinarySearchTreeAux(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBinarySearchTreeAux(Node<Integer> root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        boolean isLeftBST = isBinarySearchTreeAux(root.getLeft(), min, root.getData());
        boolean isRightBST = isBinarySearchTreeAux(root.getRight(), root.getData(), max);

        return root.getData() > min && root.getData() < max && isLeftBST && isRightBST;
    }

    public boolean isBinarySearchTree2(Node<Integer> root) {
        return isBinarySearchTreeAux1(root).getFirst();
    }

    public Pair<Boolean, Pair<Integer, Integer>> isBinarySearchTreeAux1(Node<Integer> root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return new Pair<>(true, new Pair<>(root.getData(), root.getData()));
        }

        boolean isLeftBST = true;
        boolean isRightBST = true;

        int leftMax = Integer.MIN_VALUE;
        int leftMin = Integer.MAX_VALUE;

        int rightMin = Integer.MIN_VALUE;
        int rightMax = Integer.MAX_VALUE;

        if (root.getLeft() != null) {
            Pair<Boolean, Pair<Integer, Integer>> leftResult = isBinarySearchTreeAux1(root.getLeft());
            isLeftBST = leftResult.getFirst();
            leftMax = leftResult.getSecond().getSecond();
            leftMin = leftResult.getSecond().getFirst();
        }

        if (root.getRight() != null) {
            Pair<Boolean, Pair<Integer, Integer>> rightResult = isBinarySearchTreeAux1(root.getRight());
            isRightBST = rightResult.getFirst();
            rightMin = rightResult.getSecond().getFirst();
            rightMax = rightResult.getSecond().getSecond();
        }

        boolean isCurrentBST = root.getData() > leftMax && root.getData() < rightMin;

        return new Pair<>(isLeftBST && isRightBST && isCurrentBST, new Pair<>(min(root.getData(), leftMin), max(root.getData(), rightMax)));
    }

    public Node<Integer> insertNode1(Node<Integer> root, Integer data) {
        if (root == null) {
            return new Node<>(data);
        }

        Node<Integer> node = root;
        while (node != null) {
            if (data < node.getData()) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node<>(data));
                    break;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(new Node<>(data));
                    break;
                }
                node = node.getRight();
            }
        }

        return root;
    }

    public Node<Integer> insertNode(Node<Integer> root, Integer data) {
        if (root == null) {
            return new Node<>(data);
        }

        insertNodeAux(root, data);
        return root;
    }

    public void insertNodeAux(Node<Integer> root, Integer data) {
        if (data < root.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(new Node<>(data));
            } else {
                insertNodeAux(root.getLeft(), data);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node<>(data));
            } else {
                insertNodeAux(root.getRight(), data);
            }
        }
    }

    public boolean exists(Node<Integer> root, Integer data) {
        if (root == null) {
            return false;
        }
        if (root.getData() == data) {
            return true;
        }

        if (data < root.getData()) {
            return exists(root.getLeft(), data);
        } else {
            return exists(root.getRight(), data);
        }
    }

    public Node<Integer> removeNode(Node<Integer> root, Integer data) {
        if (root == null) {
            return null;
        }

        if (root.getData() == data) {
            if (root.isLeaf()) {
                return null;
            } else if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                Node<Integer> min = root.getRight();
                while (min.getLeft() != null) {
                    min = min.getLeft();
                }
                root.setData(min.getData());
                root.setRight(removeNode(root.getRight(), min.getData()));
            }
        }

        if (data < root.getData()) {
            root.setLeft(removeNode(root.getLeft(), data));
        } else {
            root.setRight(removeNode(root.getRight(), data));
        }

        return root;
    }
}
