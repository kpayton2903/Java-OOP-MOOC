
public class LinkedList<E> {

    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void add(int index, E data) {
        int currentIndex = 0;
        Node<E> current = head;
        Node<E> node;

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        
        switch (index) {
            case 0:
                head = new Node<>(data, head);
                break;
            case 1:
                node = new Node<>(data, head.next);
                head.next = node;
                break;
            default:
                while (currentIndex < index - 1) {
                    current = current.next;
                    currentIndex++;
                }
                node = new Node<>(data, current.next);
                current.next = node;
                break;
        }
        size++;
    }

    public void add(E data) {
        add(size, data);
    }

    public boolean contains(Object data) {
        Node<E> current = head;

        if (isEmpty()) {
            return false;
        }
        else {
            while (current != null) {
                if (data == null) {
                    if (current.data == null) {
                        return true;
                    }
                }
                else if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            }

            return false;
        }
    }

    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        switch (index) {
            case 0:
                return head.data;
            case 1:
                return head.next.data;
            default:
                while (currentIndex < index - 1) {
                    current = current.next;
                    currentIndex++;
                }
                return current.next.data;
        }
    }

    public int indexOf(Object data) {
        Node<E> current = head;
        int currentIndex = 0;

        if (isEmpty()) {
            return -1;
        }
        else {
            while (current != null) {
                if (data == null) {
                    if (current.data == null) {
                        return currentIndex;
                    }
                }
                else if (data.equals(current.data)) {
                    return currentIndex;
                }
                current = current.next;
                currentIndex++;
            }

            return -1;
        }
    }

    public E remove(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        Node<E> removeNode;

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        size--;

        switch (index) {
            case 0:
                removeNode = head;
                head = removeNode.next;
                return removeNode.data;
            case 1:
                removeNode = head.next;
                head.next = removeNode.next;
                return removeNode.data;
            default:
                while (currentIndex < index - 1) {
                    current = current.next;
                    currentIndex++;
                }

                removeNode = current.next;
                current.next = removeNode.next;
                return removeNode.data;
        }
    }

    public boolean remove(Object data) {
        Node<E> current = head;
        Node<E> nextNode;

        if (isEmpty()) {
            return false;
        }

        if (data == null) {
            if (head.data == null) {
                head = head.next;
                size--;
                return true;
            }
        }
        else {
            if (data.equals(head.data)) {
                head = head.next;
                size--;
                return true;
            }
        }

        while (current.next != null) {
            nextNode = current.next;
            if (data == null) {
                if (nextNode.data == null) {
                    current.next = nextNode.next;
                    size--;
                    return true;
                }
            }
            else if (data.equals(nextNode.data)) {
                current.next = nextNode.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public E set(int index, E data) {
        int currentIndex = 0;
        Node<E> current = head;
        Node<E> node;

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        
        switch (index) {
            case 0:
                head = new Node<>(data, head.next);
                return current.data;
            case 1:
                current = head.next;
                node = new Node<>(data, current.next);
                head.next = node;
                return current.data;
            default:
                while (currentIndex < index - 1) {
                    current = current.next;
                    currentIndex++;
                }

                Node<E> removeNode = current.next;
                node = new Node<>(data, removeNode.next);
                current.next = node;
                return removeNode.data;
        }
    }

    @Override
    public String toString() {
        String returnString;
        Node<E> current = head;

        if (isEmpty()) {
            returnString = "[]";
        }
        else {
            returnString = "[";
            while(current.next != null) {
                returnString += String.valueOf(current.data) + ", ";
                current = current.next;
            }
            returnString += String.valueOf(current.data) + "]";
        }

        return returnString;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }
}
