package hus.oop.numbersystem;

import java.io.FileWriter;
import java.util.Random;

public class TestNumberSystem {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số tự nhiện n1, n2, n3:

        - Thực hiện chạy chương trình bằng cách set các số vừa sinh ra vào MyNumber.
          Chương trình sẽ in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:

          Original number: n1
          Binary: 1111111
          Octal: 7777777

          Original number: n2
          Binary: 1111111
          Octal: 7777777

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Random random = new Random();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(1000);
        int n3 = random.nextInt(1000);

        MyNumber[] numbers = {new MyNumber(n1), new MyNumber(n2), new MyNumber(n3)};

        for (MyNumber number : numbers) {
            System.out.println("Original number: " + number.getNumber());

            BinaryConverter binaryConverter = new BinaryConverter(number);
            OctalConverter octalConverter = new OctalConverter(number);

            number.addConverter(binaryConverter);
            number.addConverter(octalConverter);

            binaryConverter.display();
            octalConverter.display();
        }
    }
}
