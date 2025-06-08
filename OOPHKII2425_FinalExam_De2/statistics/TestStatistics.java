package hus.oop.statistics;


import java.util.Random;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */

        TestStatistics testStatistics = new TestStatistics(null);

        testStatistics.testMyArrayList();

        testStatistics.testMyLinkedList();
    }

    public void testMyArrayList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */

        Random rand = new Random();
        int length = rand.nextInt(21) + 30;
        System.out.println("Testing MyArrayList with length: " + length);

        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double value = rand.nextDouble() * 20 + 1;
            list.add(value);
        }

        statistics = new Statistics(list);

        System.out.println("Original Data: " + list.toString());

        MyArrayList sortedList = list.sortIncreasing();
        System.out.println("Sorted Data: " + sortedList.toString());

        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());

        double searchValue = 15.0;
        int index = statistics.search(searchValue);
        System.out.println("Search for " + searchValue + ": " + (index != -1 ? "Found at index " + index : "Not found"));

        double[] ranks = statistics.rank();
        System.out.print("Ranks: ");
        for (double rank : ranks) {
            System.out.print(rank + " ");
        }
        System.out.println();

    }

    public void testMyLinkedList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */

        Random rand = new Random();

        int length = rand.nextInt(21) + 30;
        System.out.println("Testing MyLinkedList with length: " + length);

        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double value = rand.nextDouble() * 20 + 1;
            list.add(value);
        }

        statistics = new Statistics(list);

        System.out.println("Original Data: " + list.toString());

        MyLinkedList sortedList = list.sortIncreasing();
        System.out.println("Sorted Data: " + sortedList.toString());

        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());

        double searchValue = 15.0;
        int index = statistics.search(searchValue);
        System.out.println("Search for " + searchValue + ": " + (index != -1 ? "Found at index " + index : "Not found"));

        double[] ranks = statistics.rank();
        System.out.print("Ranks: ");
        for (double rank : ranks) {
            System.out.print(rank + " ");
        }
        System.out.println();

    }
}
