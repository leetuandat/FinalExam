//package hus.oop.book;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//public class App {
//    private static final String COMMA_DELIMITER = ",";
//
//    private static final BookManager bookManager = new BookManager();
//
//    public static void main(String[] args) {
//        init();
//        testOriginalData();
//
//        /* Yêu cầu:
//        - Hoàn thiện code chương trình theo mẫu đã cho.
//        - Viết code để test cho tất cả các hàm test bên dưới.
//
//        - Thực hiện chạy từng hàm test theo format:
//              Tên test:
//              Kết quả chạy chương trình.
//
//          Lưu kết quả chạy chương trình và file text được đặt tên
//          là <TenSinhVien_MaSinhVien_BookManager>.txt (Ví dụ, NguyenVanA_123456_BookManager.txt).
//        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
//          <TenSinhVien_MaSinhVien_BookManager>.zip (Ví dụ, NguyenVanA_123456_BookManager.zip),
//          nộp lên classroom.
//         */
//    }
//
//    public static void init() {
//        String filePath = "data/books.csv";
//        readListData(filePath);
//    }
//
//    public static void readListData(String filePath) {
//        BufferedReader dataReader = null;
//        try {
//            String line;
//            dataReader = new BufferedReader(new FileReader(filePath));
//
//            // Read file line by line?
//            while ((line = dataReader.readLine()) != null) {
//                List<String> dataList = parseDataLineToList(line);
//                if (dataList.size() != 6) {
//                    continue;
//                }
//
//                if (dataList.get(0).equals("title")) {
//                    continue;
//                }
//
//                /*
//                TODO
//                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào bookManager để quản lý.
//
//                Gợi ý:
//                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
//                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
//                Book newBook = new Book.BookBuilder(title).
//                    .withAuthor(author)
//                    .withGenre(genre)
//                    ...
//                    .build();
//                */
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (dataReader != null)
//                    dataReader.close();
//            } catch (IOException crunchifyException) {
//                crunchifyException.printStackTrace();
//            }
//        }
//    }
//
//    public static List<String> parseDataLineToList(String dataLine) {
//        List<String> result = new ArrayList<>();
//        if (dataLine != null) {
//            String[] splitData = dataLine.split(COMMA_DELIMITER);
//            for (int i = 0; i < splitData.length; i++) {
//                result.add(splitData[i]);
//            }
//        }
//        return result;
//    }
//
//    public static String[] parseDataLineToArray(String dataLine) {
//        if (dataLine == null) {
//            return null;
//        }
//
//        return dataLine.split(COMMA_DELIMITER);
//    }
//
//    /*
//     * In ra danh sách book theo thứ tự đọc vào ban đầu, mỗi book được in trên 1 dòng theo format book
//     * được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testOriginalData() {
//        /* TODO */
//    }
//
//    /*
//     * In ra danh sách book theo thứ tự tăng dần của title, mỗi book được in trên 1 dòng theo format book
//     * được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testSortIncreasingTitle() {
//        /* TODO */
//    }
//
//    /*
//     * Test in ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
//     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testSortPublisherAndPrice() {
//        /* TODO */
//    }
//
//    /*
//     * Test in ra danh sách book theo giá tăng dần.
//     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testPriceOfBooksIncreasing() {
//        /* TODO */
//    }
//
//    /*
//     * Test in ra danh sách book theo giá giảm dần.
//     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testPriceOfBooksDecreasing() {
//        /* TODO */
//    }
//
//    /*
//     * Test in ra danh sách book theo tác giả.
//     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testFilterBooksOfAuthor() {
//        /* TODO */
//    }
//
//    /*
//     * Test in ra danh sách book theo nhà xuất bản.
//     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testFilterBooksOfPublisher() {
//        /* TODO */
//    }
//
//    /*
//     * Test in ra danh sách book theo thể loại.
//     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
//     */
//    public static void testFilterBooksOfGenre() {
//        /* TODO */
//    }
//
//    /*
//     * In ra tổng số trang của tất cả các book.
//     */
//    public static int testTotalPages() {
//        /* TODO */
//    }
//
//    /*
//     * In ra tổng giá của tất cả các sách.
//     */
//    public static double testTotalPrice() {
//        /* TODO */
//    }
//}
