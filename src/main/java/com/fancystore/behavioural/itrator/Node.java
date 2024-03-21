package com.fancystore.behavioural.itrator;

public class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
}
