package com.example.project;
public class TreeUser {
public static <T> int countLeaves(BT<T> bt) {
    if (bt.empty()) {
        return 0;
    }

    int leafCount = 0;
    BTNode<T> originalPosition = bt.current; // Store the current position of the iterator.

    LinkedStack<BTNode<T>> stack = new LinkedStack<>();
    stack.push(bt.root);

    while (!stack.empty() ) {
        BTNode<T> currentNode = stack.pop();
        bt.current = currentNode;

        if (bt.isLeaf()) {
            leafCount++;
        }
        if (currentNode.right != null) {
            stack.push(currentNode.right);
        }
        if (currentNode.left != null) {
            stack.push(currentNode.left);
        }
    }

    bt.current = originalPosition;
    return leafCount;
}
}