package org.example.math.algoritm;

import java.util.ArrayList;
import java.util.List;

public class PermutationAlgorithm {

    private void printList(List<Integer> list) {
        list.forEach(System.out::print);
        System.out.println();
    }

    public void generatePermutationsAux(List<Integer> currentPermutation, List<Integer> elementsToPermute) {
        if (elementsToPermute.isEmpty()) {
            printList(currentPermutation);
            return;
        }

        for (int i = 0; i < elementsToPermute.size(); i++) {
            List<Integer> newCurrentPermutation = new ArrayList<>(currentPermutation);
            newCurrentPermutation.add(elementsToPermute.get(i));

            List<Integer> newElementsToPermute = new ArrayList<>(elementsToPermute);
            newElementsToPermute.remove(i);

            generatePermutationsAux(newCurrentPermutation, newElementsToPermute);
        }
    }

    public void generatePermutationsAux2(List<Integer> currentPermutation, List<Integer> elementsToPermute) {
        if (elementsToPermute.isEmpty()) {
            printList(currentPermutation);
            return;
        }

        for (int i = 0; i < elementsToPermute.size(); i++) {
            currentPermutation.add(elementsToPermute.get(i));
            int removedElement = elementsToPermute.remove(i);
            generatePermutationsAux2(currentPermutation, elementsToPermute);

            currentPermutation.remove(currentPermutation.size() - 1);
            elementsToPermute.add(i, removedElement);
        }
    }

    public void generatePermutations(List<Integer> elementsToPermute) {
        generatePermutationsAux2(new ArrayList<>(), elementsToPermute);
    }

    public static void main(String[] args) {
        new PermutationAlgorithm().generatePermutations(new ArrayList<>(List.of(1, 2, 3)));
    }
}
