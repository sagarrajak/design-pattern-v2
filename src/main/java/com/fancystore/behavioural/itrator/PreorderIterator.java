package com.fancystore.behavioural.itrator;

import java.util.Iterator;
import java.util.Stack;

public class PreorderIterator<T> implements Iterator<Integer> {
    Stack<Node<Integer>> stk = new Stack<>();

    public PreorderIterator(Node<Integer> root) {
        stk.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    @Override
    public Integer next() {
        Node<Integer> pop = stk.pop();
        if (pop.right != null)
            stk.push(pop.right);
        if (pop.left != null)
            stk.push(pop.left);
        return pop.value;
    }
}
