package hus.oop.integration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        /* TODO
         - Thực hiện các yêu cầu trong từng hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        MyPolynomial polyArray = new MyArrayPolynomial();
        TestIntegrationCalculator testArray = new TestIntegrationCalculator(polyArray);
        testArray.testArrayPolynomial();

        MyPolynomial polyList = new MyListPolynomial();
        TestIntegrationCalculator testList = new TestIntegrationCalculator(polyList);
        testList.testListPolynomial();
    }

    public void testArrayPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyArrayPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 1.0 và 5.0.
         */
        Random rand = new Random();
        int size = rand.nextInt(10) + 1;
        System.out.println("Testing MyArrayPolynomial with " + size + " coefficients:");

        for (int i = 0; i < size; i++) {
            double coeff = rand.nextDouble() * 10;
            polynomial.append(coeff);
        }

        System.out.println("Original Polynomial: " + polynomial.toString());

        polynomial.append(rand.nextDouble() * 10);
        System.out.println("After appending a new coefficient: " + polynomial.toString());

        polynomial.set(rand.nextDouble() * 10, 2);
        System.out.println("After setting coefficient at index 2: " + polynomial.toString());

        MyPolynomial sum = polynomial.plus(polynomial);
        System.out.println("After adding polynomial to itself: " + sum.toString());

        MyPolynomial diff = polynomial.minus(polynomial);
        System.out.println("After subtracting polynomial from itself: " + diff.toString());

        MyPolynomial product = polynomial.multiply(polynomial);
        System.out.println("After multiplying polynomial by itself: " + product.toString());

        double value = polynomial.evaluate(2);
        System.out.println("Value of polynomial at x=2: " + value);

        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);
        double result = calculator.integrate(1.0, 5.0);
        System.out.println("Definite integral of polynomial from 1.0 to 5.0: " + result);
    }

    public void testListPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyListPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 2.0 và 6.0.
         */
        Random rand = new Random();
        int size = rand.nextInt(10) + 1;  // Tạo số lượng hệ số ngẫu nhiên (từ 1 đến 10)
        System.out.println("Testing MyListPolynomial with " + size + " coefficients:");

        for (int i = 0; i < size; i++) {
            double coeff = rand.nextDouble() * 10;
            polynomial.append(coeff);
        }

        System.out.println("Original Polynomial: " + polynomial.toString());

        polynomial.append(rand.nextDouble() * 10);
        System.out.println("After appending a new coefficient: " + polynomial.toString());

        polynomial.set(rand.nextDouble() * 10, 2);
        System.out.println("After setting coefficient at index 2: " + polynomial.toString());

        MyPolynomial sum = polynomial.plus(polynomial);
        System.out.println("After adding polynomial to itself: " + sum.toString());

        MyPolynomial diff = polynomial.minus(polynomial);
        System.out.println("After subtracting polynomial from itself: " + diff.toString());

        MyPolynomial product = polynomial.multiply(polynomial);
        System.out.println("After multiplying polynomial by itself: " + product.toString());

        double value = polynomial.evaluate(2);
        System.out.println("Value of polynomial at x=2: " + value);

        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);
        double result = calculator.integrate(2.0, 6.0);
        System.out.println("Definite integral of polynomial from 2.0 to 6.0: " + result);
    }
}
