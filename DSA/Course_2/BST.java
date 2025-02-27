import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }

        root = addHelper(root, data);
    }

    private BSTNode<T> addHelper(BSTNode<T> current, T data) {
        if (current == null) {
            size++;
            return new BSTNode<T>(data);
        }

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(addHelper(current.getLeft(), data));
        }
        else if (data.compareTo(current.getData()) > 0) {
            current.setRight(addHelper(current.getRight(), data));
        }
        else {
            return current;
        }

        return current;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }

        BSTNode<T> removed = new BSTNode<>(null);
        root = removeHelper(root, data, removed);
        return removed.getData();
    }

    private BSTNode<T> removeHelper(BSTNode<T> current, T data, BSTNode<T> removed) {
        if (current == null) {
            throw new NoSuchElementException("Data not found in the tree.");
        }

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(removeHelper(current.getLeft(), data, removed));
        }
        else if (data.compareTo(current.getData()) > 0) {
            current.setRight(removeHelper(current.getRight(), data, removed));
        }
        else {
            removed.setData(current.getData());
            size--;

            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            else if (current.getLeft() == null && current.getRight() != null) {
                current = current.getRight();
            }
            else if (current.getLeft() != null && current.getRight() == null) {
                current = current.getLeft();
            }
            else{
                BSTNode<T> temp = new BSTNode<>(null);

                current.setRight(removeMin(current.getRight(), temp));
                current.setData(temp.getData());
            }
        }

        return current;
    }

    private BSTNode<T> removeMin(BSTNode<T> current, BSTNode<T> min) {
        if (current.getLeft() == null) {
            min.setData(current.getData());
            return current.getRight();
        }
        else {
            current.setLeft(removeMin(current.getLeft(), min));
            return current;
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}