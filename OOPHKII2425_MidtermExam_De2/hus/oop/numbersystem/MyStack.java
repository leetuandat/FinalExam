package hus.oop.numbersystem;

public class MyStack {
    private MyList stack;

    public MyStack() {
        this.stack = new MyArrayList();
    }

    /**
     * Thêm dữ liệu vào đầu stack.
     * @param value
     */
    public void push(int value) {
        /* TODO */
        if (stack.size() == 0) {
            stack.insertAtEnd(value);
        } else {
            stack.insertAtStart(value);
        }
    }

    /**
     * Xóa và trả lại giá trị ở vị trí đầu stack.
     * @return
     */
    public int pop() {
        /* TODO */
        int value = stack.get(0);
        stack.remove(0);
        return value;
    }

    /**
     * Kiểm tra xem stack có rỗng không.
     * @return true nếu stack rỗng, false nếu stack không rỗng.
     */
    public boolean isEmpty() {
        /* TODO */
        return stack.size() == 0;
    }

    /**
     * Trả lại giá trị ở đầu stack mà không xóa phần tử.
     * @return giá trị ở vị trí đầu stack.
     */
    public int peek() {
        /* TODO */
        return stack.get(0);
    }

    /**
     * Lấy kích thước của stack.
     * @return
     */
    public int size() {
        /* TODO */
        return stack.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int[] arr = stack.toArray();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
