package hus.oop.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
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
    public MyLinkedList sortIncreasing() {
        /* TODO */
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
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
