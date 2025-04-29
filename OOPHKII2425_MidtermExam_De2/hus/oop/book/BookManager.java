package hus.oop.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        /* TODO */
        this.bookList = new ArrayList<>();
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAtPosition(Book book, int index) {
        /* TODO */
        bookList.add(index, book);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return bookList.get(index);
    }

    /**
     * Trả ra số book trong danh sách.
     * @return
     */
    public int numberOfBooks() {
        /* TODO */
        return bookList.size();
    }

    /**
     * Tổng giá của tất cả các book.
     * @return
     */
    public double totalPrice() {
        /* TODO */
        double total = 0;
        for (Book book : bookList) {
            total += book.getPrice();
        }
        return total;
    }

    /**
     * Tổng số trang của tất cả các book.
     * @return
     */
    public double totalPages() {
        /* TODO */
        double total = 0;
        for (Book book : bookList) {
            total += book.getPages();
        }
        return total;
    }

    /**
     * Trả ra danh sách book theo thứ tự tăng dần theo title.
     * @return
     */
    public List<Book> sortIncreasingByTitle() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        Collections.sort(sorted);
        return sorted;
    }

    /**
     * Trả ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortByPublisherAndPrice() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        sorted.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int pubCompare = b1.getPublisher().compareTo(b2.getPublisher());
                if (pubCompare != 0) {
                    return pubCompare;
                }
                return Double.compare(b2.getPrice(), b1.getPrice());
            }
        });
        return sorted;
    }

    /**
     * Trả ra danh sách book sắp xếp theo giá tăng dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        sorted.sort(Comparator.comparingDouble(Book::getPrice));
        return sorted;
    }

    /**
     * Trả ra danh sách book theo giá giảm dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        List<Book> sorted = new ArrayList<>(bookList);
        sorted.sort((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice()));
        return sorted;
    }

    /**
     * Trả ra danh sách book theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        List<Book> filtered = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    /**
     * Trả ra danh sách book theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        List<Book> filtered = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    /**
     * Trả ra danh sách book theo publisher.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        List<Book> filtered = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
