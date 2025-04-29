package hus.oop.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();

        System.out.println("Test Original Data:");
        testOriginalData();

        System.out.println("\nTest Sort Increasing Title:");
        testSortIncreasingTitle();

        System.out.println("\nTest Sort Publisher And Price:");
        testSortPublisherAndPrice();

        System.out.println("\nTest Price Increasing:");
        testPriceOfBooksIncreasing();

        System.out.println("\nTest Price Decreasing:");
        testPriceOfBooksDecreasing();

        System.out.println("\nTest Filter Books of Author:");
        testFilterBooksOfAuthor();

        System.out.println("\nTest Filter Books of Publisher:");
        testFilterBooksOfPublisher();

        System.out.println("\nTest Filter Books of Genre:");
        testFilterBooksOfGenre();

        System.out.println("\nTotal Pages: " + testTotalPages());
        System.out.println("Total Price: " + testTotalPrice());
    }

    public static void init() {
        String filePath = "OOPHKII2425_MidtermExam_De2/data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6 || dataList.get(0).equals("title")) {
                    continue;
                }
                Book newBook = new Book.BookBuilder(dataList.get(0))
                        .withAuthor(dataList.get(1))
                        .withGenre(dataList.get(2))
                        .withPages((int) Double.parseDouble(dataList.get(3)))
                        .withPrice(Double.parseDouble(dataList.get(4)))
                        .withPublisher(dataList.get(5))
                        .build();
                bookManager.append(newBook);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (String data : splitData) {
                result.add(data);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }
        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        BookManager.print(bookManager.sortIncreasingByTitle());
    }

    public static void testSortIncreasingTitle() {
        BookManager.print(bookManager.sortIncreasingByTitle());
    }

    public static void testSortPublisherAndPrice() {
        BookManager.print(bookManager.sortByPublisherAndPrice());
    }

    public static void testPriceOfBooksIncreasing() {
        BookManager.print(bookManager.sortIncreasingPrice());
    }

    public static void testPriceOfBooksDecreasing() {
        BookManager.print(bookManager.sortDecreasingPrice());
    }

    public static void testFilterBooksOfAuthor() {
        BookManager.print(bookManager.filterBooksOfAuthor("Mlodinow Leonard"));
    }

    public static void testFilterBooksOfPublisher() {
        BookManager.print(bookManager.filterBooksOfPublisher("Wiley"));
    }

    public static void testFilterBooksOfGenre() {
        BookManager.print(bookManager.filterBooksOfGenre("history"));
    }

    public static double testTotalPages() {
        return bookManager.totalPages();
    }

    public static double testTotalPrice() {
        return bookManager.totalPrice();
    }
}