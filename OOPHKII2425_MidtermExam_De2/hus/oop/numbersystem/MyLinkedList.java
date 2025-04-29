package hus.oop.numbersystem;

public class MyLinkedList extends MyAbstractList {
    private Node start;
    private Node end;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        start = end = null;
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        /* TODO */
        return getNodeByIndex(index).data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        getNodeByIndex(index).data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */
        Node newNode = new Node(value);
        if (start == null) {
            start = end = newNode;
        } else {
            newNode.next = start;
            start = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
        Node newNode = new Node(value);
        if (start == null) {
            start = end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        if (index == 0) {
            insertAtStart(value);
        } else if (index == size) {
            insertAtEnd(value);
        } else {
            Node prev = getNodeByIndex(index - 1);
            Node newNode = new Node(value);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) throw new IndexOutOfBoundsException();
        if (index == 0) {
            start = start.next;
            if (start == null) end = null;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
            if (index == size - 1) end = prev;
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) throw new IndexOutOfBoundsException();
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */
        int[] arr = new int[size];
        Node current = start;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }
}
