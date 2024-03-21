package com.fancystore.behavioural.itrator;

import java.util.Iterator;
import java.util.Stack;

public class InorderTraversalTree<T> implements Iterator<T> {
    Stack<Node<T>> stack = new Stack<>();
    Node<T> root;
    public InorderTraversalTree(Node<T> root) {
        this.root = root;
        addLeftItems(root);
    }

    private void addLeftItems(Node<T> temp) {
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
//        System.out.println(stack.size());
        Node<T> pop = stack.pop();
        if(pop.right != null)
            addLeftItems(pop.right);
        return pop.value;
    }
}
