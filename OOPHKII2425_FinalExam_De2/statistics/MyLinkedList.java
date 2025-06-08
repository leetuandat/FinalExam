package hus.oop.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        this.top = null;
    }

    @Override
    public int size() {
        int size = 0;
        MyNode current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            MyNode newNode = new MyNode(data);
            newNode.next = top;
            if (top != null) {
                top.previous = newNode;
            }
            top = newNode;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            MyNode newNode = new MyNode(data);
            newNode.next = prev.next;
            if (prev.next != null) {
                prev.next.previous = newNode;
            }
            prev.next = newNode;
            newNode.previous = prev;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        MyNode current = getNodeByIndex(index);
        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            top = current.next;
        }
        if (current.next != null) {
            current.next.previous = current.previous;
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        MyLinkedList sortedList = new MyLinkedList();
        MyNode current = top;
        while (current != null) {
            sortedList.add(current.data);
            current = current.next;
        }

        for (MyNode outer = sortedList.top; outer != null; outer = outer.next) {
            for (MyNode inner = outer.next; inner != null; inner = inner.next) {
                if (outer.data > inner.data) {
                    double temp = outer.data;
                    outer.data = inner.data;
                    inner.data = temp;
                }
            }
        }
        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        MyLinkedList sortedList = sortIncreasing();
        int left = 0, right = sortedList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            MyNode midNode = sortedList.getNodeByIndex(mid);
            if (midNode.data == data) {
                return mid;
            } else if (midNode.data < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        MyNode current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;
        private MyNode currentNode;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            if (position < 0 || position >= size()) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            this.currentPosition = position;
            this.currentNode = getNodeByIndex(position);
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size();
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            double data = currentNode.data;
            currentNode = currentNode.next;
            currentPosition++;
            return data;
        }

        @Override
        public void remove() {
            if (currentNode == null) {
                throw new IllegalStateException("Next has not been called or already removed");
            }
            MyLinkedList.this.remove(currentPosition);
            currentPosition--;
        }
    }
}
