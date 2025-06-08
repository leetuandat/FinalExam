package hus.oop.matrix;

import java.io.*;
import java.util.Random;

public class TestMatrix {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */

        Random rand = new Random();

        int size = rand.nextInt(6) + 5;

        MySquareMatrix matrix1 = new MySquareMatrix(size);
        MySquareMatrix matrix2 = new MySquareMatrix(size);

        System.out.println("Matrix 1:");
        System.out.println(matrix1.toString());
        System.out.println("Transpose of Matrix 1:");
        System.out.println(matrix1.transpose().toString());

        System.out.println("Matrix 2:");
        System.out.println(matrix2.toString());
        System.out.println("Transpose of Matrix 2:");
        System.out.println(matrix2.transpose().toString());

        System.out.println("Principal Diagonal of Matrix 1:");
        int[] principalDiagonal1 = matrix1.principalDiagonal();
        for (int num : principalDiagonal1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Secondary Diagonal of Matrix 1:");
        int[] secondaryDiagonal1 = matrix1.secondaryDiagonal();
        for (int num : secondaryDiagonal1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Principal Diagonal of Matrix 2:");
        int[] principalDiagonal2 = matrix2.principalDiagonal();
        for (int num : principalDiagonal2) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Secondary Diagonal of Matrix 2:");
        int[] secondaryDiagonal2 = matrix2.secondaryDiagonal();
        for (int num : secondaryDiagonal2) {
            System.out.print(num + " ");
        }
        System.out.println();

        MySquareMatrix sumMatrix = matrix1.add(matrix2);
        System.out.println("Matrix 1 + Matrix 2:");
        System.out.println(sumMatrix.toString());

        MySquareMatrix diffMatrix = matrix1.minus(matrix2);
        System.out.println("Matrix 1 - Matrix 2:");
        System.out.println(diffMatrix.toString());

        MySquareMatrix productMatrix = matrix1.multiply(matrix2);
        System.out.println("Matrix 1 * Matrix 2:");
        System.out.println(productMatrix.toString());

        // In ra các số nguyên tố trong 2 ma trận
        System.out.println("Primes in Matrix 1:");
        int[] primes1 = matrix1.primes();
        for (int prime : primes1) {
            System.out.print(prime + " ");
        }
        System.out.println();

        System.out.println("Primes in Matrix 2:");
        int[] primes2 = matrix2.primes();
        for (int prime : primes2) {
            System.out.print(prime + " ");
        }
        System.out.println();

    }
}
