package org.example.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeOperationsTest {

    @Test
    public void inorder() {
        Node<Integer> root = new Node<>(5,
            new Node<>(3,
                new Node<>(1),
                new Node<>(2)),
            new Node<>(4)
        );

        List<Integer> inorder = new BinaryTreeOperations().inorder(root);

        assertThat(inorder).containsExactly(1, 3, 2, 5, 4);
    }

    @Test
    public void preorder() {
        Node<Integer> root = new Node<>(5,
            new Node<>(3,
                new Node<>(1),
                new Node<>(2)),
            new Node<>(4)
        );

        List<Integer> preorder = new BinaryTreeOperations().preorder(root);

        assertThat(preorder).containsExactly(5, 3, 1, 2, 4);
    }

    @Test
    public void postorder() {
        Node<Integer> node1Left = new Node<>(1);
        Node<Integer> node1Right = new Node<>(2);
        Node<Integer> node1 = new Node<>(3, node1Left, node1Right);
        Node<Integer> node2 = new Node<>(4);
        Node<Integer> root = new Node<>(5, node1, node2);

        List<Integer> postorder = new BinaryTreeOperations().postorder(root);

        assertThat(postorder).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void height1() {
        Node<Integer> node1Left = new Node<>(1);
        Node<Integer> node1Right = new Node<>(2);
        Node<Integer> node1 = new Node<>(3, node1Left, node1Right);
        Node<Integer> node2 = new Node<>(4);
        Node<Integer> root = new Node<>(5, node1, node2);

        Integer height = new BinaryTreeOperations().getHeight(root);

        assertThat(height).isEqualTo(2);
    }

    @Test
    public void height2() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2, node1, null);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node6 = new Node<>(6, null, node7);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5, node4, node6);
        Node<Integer> root = new Node<>(3, node2, node5);

        Integer height = new BinaryTreeOperations().getHeight(root);

        assertThat(height).isEqualTo(3);
    }

    @Test
    public void getAllNodesOnLevel() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2, node1, null);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node6 = new Node<>(6, null, node7);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5, node4, node6);
        Node<Integer> root = new Node<>(3, node2, node5);

        List<Integer> nodesOnLevel2 = new BinaryTreeOperations().getAllNodesOnLevel(root, 2);

        assertThat(nodesOnLevel2).containsExactly(1, 4, 6);
    }

    @Test
    public void areAllLeavesOnSameLevel1() {
        Node<Integer> root = new Node<>(3,
            new Node<>(2,
                new Node<>(1),
                null),
            new Node<>(5,
                new Node<>(4),
                new Node<>(6,
                    null,
                    new Node<>(7)
                )
            )
        );

        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(root);

        assertThat(areAllLeavesOnSameLevel.getSecond()).isFalse();
    }

    @Test
    public void areAllLeavesOnSameLevel2() {
        Node<Integer> root = new Node<>(1,
            new Node<>(2,
                new Node<>(3),
                new Node<>(4)),
            new Node<>(5,
                new Node<>(6,
                    new Node<>(7),
                    new Node<>(8)),
                new Node<>(9,
                    new Node<>(10),
                    new Node<>(11)
                )
            )
        );

        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(root);

        assertThat(areAllLeavesOnSameLevel.getSecond()).isFalse();
    }

    @Test
    public void areAllLeavesOnSameLevel3() {
        Node<Integer> root = new Node<>(1,
            new Node<>(2,
                new Node<>(3,
                    new Node<>(31),
                    new Node<>(32)
                ),
                new Node<>(4,
                    new Node<>(41),
                    new Node<>(42)
                )
            ),
            new Node<>(5,
                new Node<>(6,
                    new Node<>(7),
                    new Node<>(8)
                ),
                new Node<>(9,
                    new Node<>(10),
                    new Node<>(11)
                )
            )
        );

        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(root);

        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();
    }

    @Test
    public void areAllLeavesOnSameLevel_BaseCases() {
        Node<Integer> leaf = new Node<>(1);
        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(leaf);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();

        Node<Integer> nodeWithLeftLeaf = new Node<>(1, new Node<>(2), null);
        areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(nodeWithLeftLeaf);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();

        Node<Integer> nodeWithRightLeaf = new Node<>(1, null, new Node<>(2));
        areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(nodeWithRightLeaf);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();

        Node<Integer> nodeTwoLeaves = new Node<>(1, new Node<>(2), new Node<>(3));
        areAllLeavesOnSameLevel = new BinaryTreeOperations().areAllLeavesOnSameLevel(nodeTwoLeaves);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();
    }

    @Test
    public void isBalanced_BaseCases() {
        Node<Integer> leaf = new Node<>(1);
        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().isBalanced(leaf);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();

        Node<Integer> nodeWithLeftLeaf = new Node<>(1, new Node<>(2), null);
        areAllLeavesOnSameLevel = new BinaryTreeOperations().isBalanced(nodeWithLeftLeaf);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();

        Node<Integer> nodeWithRightLeaf = new Node<>(1, null, new Node<>(2));
        areAllLeavesOnSameLevel = new BinaryTreeOperations().isBalanced(nodeWithRightLeaf);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();

        Node<Integer> nodeTwoLeaves = new Node<>(1, new Node<>(2), new Node<>(3));
        areAllLeavesOnSameLevel = new BinaryTreeOperations().isBalanced(nodeTwoLeaves);
        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();
    }

    @Test
    public void isBalanced1() {
        Node<Integer> root = new Node<>(1,
            new Node<>(2,
                new Node<>(3),
                null
            ),
            null
        );

        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().isBalanced(root);

        assertThat(areAllLeavesOnSameLevel.getSecond()).isFalse();
    }

    @Test
    public void isBalanced2() {
        Node<Integer> root = new Node<>(3,
            new Node<>(2,
                new Node<>(1),
                null),
            new Node<>(5,
                new Node<>(4),
                new Node<>(6,
                    null,
                    new Node<>(7)
                )
            )
        );

        Pair<Integer, Boolean> areAllLeavesOnSameLevel = new BinaryTreeOperations().isBalanced(root);

        assertThat(areAllLeavesOnSameLevel.getSecond()).isTrue();
    }
}