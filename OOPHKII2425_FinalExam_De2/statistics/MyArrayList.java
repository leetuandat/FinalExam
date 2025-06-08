package hus.oop.statistics;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double data) {
        if (size == this.data.length) {
            allocateMore();
        }
        this.data[size++] = data;
    }

    @Override
    public void insert(double data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (size == this.data.length) {
            allocateMore();
        }

        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        double[] sortedData = Arrays.copyOf(data, size);
        Arrays.sort(sortedData);
        MyArrayList sortedList = new MyArrayList();
        for (double num : sortedData) {
            sortedList.add(num);
        }
        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (this.data[mid] == data) {
                return mid;
            }
            if (this.data[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        this.data = Arrays.copyOf(this.data, this.data.length * 2);
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Position out of range");
            }
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("Next has not been called or already removed");
            }
            MyArrayList.this.remove(currentPosition - 1);
            currentPosition--;
        }
    }
}
