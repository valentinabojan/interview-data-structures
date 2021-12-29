package org.example.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeOperationsTest {

    @Test
    public void isBinarySearchTree1() {
        Node<Integer> root = new Node<>(1,
            new Node<>(2,
                new Node<>(3),
                null),
            new Node<>(4,
                new Node<>(5),
                new Node<>(6,
                    null,
                    new Node<>(7)
                )
            )
        );

        boolean isBinarySearchTree = new BinarySearchTreeOperations().isBinarySearchTree(root);

        assertThat(isBinarySearchTree).isFalse();
    }

    @Test
    public void isBinarySearchTree2() {
        Node<Integer> root = new Node<>(5,
            new Node<>(4),
            new Node<>(7,
                new Node<>(6),
                new Node<>(8)
            )
        );

        boolean isBinarySearchTree = new BinarySearchTreeOperations().isBinarySearchTree(root);

        assertThat(isBinarySearchTree).isTrue();
    }

    @Test
    public void isBinarySearchTree3() {
        Node<Integer> root = new Node<>(6,
            new Node<>(2,
                new Node<>(1),
                new Node<>(8)),
            new Node<>(9)
        );

        boolean isBinarySearchTree = new BinarySearchTreeOperations().isBinarySearchTree(root);

        assertThat(isBinarySearchTree).isFalse();
    }

    @Test
    public void insertNode1() {
        Node<Integer> root = new Node<>(5,
            new Node<>(4),
            new Node<>(7,
                new Node<>(6),
                new Node<>(8)
            )
        );

        Node<Integer> tree = new BinarySearchTreeOperations().insertNode(root, 3);

        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(3, 4, 5, 6, 7, 8);
    }

    @Test
    public void insertNode2() {
        Node<Integer> tree = new BinarySearchTreeOperations().insertNode(null, 3);
        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(3);

        tree = new BinarySearchTreeOperations().insertNode(tree, 1);
        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(1, 3);

        tree = new BinarySearchTreeOperations().insertNode(tree, 5);
        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(1, 3, 5);

        tree = new BinarySearchTreeOperations().insertNode(tree, 4);
        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(1, 3, 4, 5);

        tree = new BinarySearchTreeOperations().insertNode(tree, 2);
        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void removeNode() {
        Node<Integer> tree = new Node<>(20,
            new Node<>(10,
                new Node<>(5),
                null
            ),
            new Node<>(30,
                new Node<>(25),
                new Node<>(40,
                    new Node<>(35,
                        new Node<>(34,
                            new Node<>(32,
                                null,
                                new Node<>(33)
                            ),
                            null
                        ),
                        null
                    ),
                    new Node<>(50,
                        null,
                        new Node<>(60)
                    )
                )
            )
        );
        assertThat(new BinaryTreeOperations().inorder(tree)).containsExactly(5, 10, 20, 25, 30, 32, 33, 34, 35, 40, 50, 60);

        assertThat(new BinarySearchTreeOperations().isBinarySearchTree(tree)).isTrue();

        Node<Integer> newTree = new BinarySearchTreeOperations().removeNode(tree, 5);
        assertThat(new BinaryTreeOperations().inorder(newTree)).containsExactly(10, 20, 25, 30, 32, 33, 34, 35, 40, 50, 60);

        newTree = new BinarySearchTreeOperations().removeNode(tree, 25);
        assertThat(new BinaryTreeOperations().inorder(newTree)).containsExactly(10, 20, 30, 32, 33, 34, 35, 40, 50, 60);

        newTree = new BinarySearchTreeOperations().removeNode(tree, 30);
        assertThat(new BinaryTreeOperations().inorder(newTree)).containsExactly(10, 20, 32, 33, 34, 35, 40, 50, 60);

        newTree = new BinarySearchTreeOperations().removeNode(tree, 50);
        assertThat(new BinaryTreeOperations().inorder(newTree)).containsExactly(10, 20, 32, 33, 34, 35, 40, 60);
    }
}