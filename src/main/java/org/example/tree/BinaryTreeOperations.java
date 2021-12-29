package org.example.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class BinaryTreeOperations {

    public <T> List<T> inorder(Node<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<T> leftData = inorder(root.getLeft());
        List<T> rootData = List.of(root.getData());
        List<T> rightData = inorder(root.getRight());

        return Stream.of(leftData, rootData, rightData)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    public <T> List<T> preorder(Node<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<T> rootData = List.of(root.getData());
        List<T> leftData = preorder(root.getLeft());
        List<T> rightData = preorder(root.getRight());

        return Stream.of(rootData, leftData, rightData)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    public <T> List<T> postorder(Node<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<T> leftData = postorder(root.getLeft());
        List<T> rightData = postorder(root.getRight());
        List<T> rootData = List.of(root.getData());

        return Stream.of(leftData, rightData, rootData)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    public <T> Integer getHeight(Node<T> root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public <T> List<T> getAllNodesOnLevel(Node<T> root, int level) {
        if (level == 0) {
            return List.of(root.getData());
        }

        List<T> leftData = ofNullable(root.getLeft())
            .map(left -> getAllNodesOnLevel(left, level - 1))
            .orElse(List.of());
        List<T> rightData = ofNullable(root.getRight())
            .map(right -> getAllNodesOnLevel(right, level - 1))
            .orElse(List.of());

        return Stream.of(leftData, rightData)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    public <T> Pair<Integer, Boolean> areAllLeavesOnSameLevel(Node<T> root) {
        if (root.isLeaf()) {
            return new Pair<>(0, true);
        }
        if (root.getLeft() == null && root.getRight().isLeaf()) {
            return new Pair<>(1, true);
        }
        if (root.getRight() == null && root.getLeft().isLeaf()) {
            return new Pair<>(1, true);
        }
        if (root.getLeft().isLeaf() && root.getRight().isLeaf()) {
            return new Pair<>(1, true);
        }

        Pair<Integer, Boolean> leftResult = areAllLeavesOnSameLevel(root.getLeft());
        Pair<Integer, Boolean> rightResult = areAllLeavesOnSameLevel(root.getRight());

        return new Pair<>(
            1 + Math.max(leftResult.getFirst(), rightResult.getFirst()),
            leftResult.getSecond() && rightResult.getSecond() && leftResult.getFirst().equals(rightResult.getFirst())
        );
    }

    public <T> Pair<Integer, Boolean> isBalanced(Node<T> root) {
        if (root == null) {
            return new Pair<>(-1, true);
        }

        Pair<Integer, Boolean> leftResult = isBalanced(root.getLeft());
        Pair<Integer, Boolean> rightResult = isBalanced(root.getRight());

        Boolean isLeftBalanced = leftResult.getSecond();
        Boolean isRightBalanced = rightResult.getSecond();
        int leftHeight = leftResult.getFirst();
        int rightHeight = rightResult.getFirst();

        return new Pair<>(
            1 + Math.max(leftHeight, rightHeight),
            isLeftBalanced && isRightBalanced && Math.abs(leftHeight - rightHeight) <= 1
        );
    }

    public <T> Node<T> getLowestAncestor(Node<T> root, T node1Data, T node2Data) {
        if (root == null) {
            return null;
        }

        if (root.getData() == node1Data || root.getData() == node2Data) {
            return root;
        }

        Node<T> lca1 = getLowestAncestor(root.getLeft(), node1Data, node2Data);
        Node<T> lca2 = getLowestAncestor(root.getRight(), node1Data, node2Data);

        if (lca1 != null && lca2 != null) {
            return root;
        }

        return lca1 != null ? lca1 : lca2;
    }
}
