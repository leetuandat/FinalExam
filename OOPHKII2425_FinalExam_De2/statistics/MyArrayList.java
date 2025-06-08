package hus.oop.statistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
    }

    @Override
    public int size() {
        /* TODO */
    }

    @Override
    public void add(double data) {
        /* TODO */
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
    }

    @Override
    public void remove(int index) {
        /* TODO */
    }

    @Override
    public MyArrayList sortIncreasing() {
        /* TODO */
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
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
            /* TODO */
        }

        @Override
        public boolean hasNext() {
            /* TODO */
        }

        @Override
        public Number next() {
            /* TODO */
        }

        @Override
        public void remove() {
            /* TODO */
        }
    }
}
