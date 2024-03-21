package com.fancystore.behavioural.itrator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class TreeTraversalItrator {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        System.out.println("input 1, 2, 3, 4 for inorder preorder  postorder and bfs traversal!");
        int val = Integer.parseInt(bufferedReader.readLine());
        Iterator<Integer> itr;
        if (val == 1) {
            itr = new InorderTraversalTree<>(root);
            while (itr.hasNext()) {
                Integer next = itr.next();
                System.out.println(next);
            }
        } else if (val == 2) {
            itr = new PreorderIterator<>(root);
            while (itr.hasNext()) {
                Integer next = itr.next();
                System.out.println(next);
            }
        } else if (val == 3) {
            itr = new PreorderIterator<>(root);
            while (itr.hasNext()) {
                Integer next = itr.next();
                System.out.println(next);

            }
        }
    }
}

