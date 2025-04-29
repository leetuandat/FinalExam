package hus.oop.numbersystem;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(MyNumber originalNumber) {
        /* TODO */
        super(originalNumber);
        decimalTo(originalNumber.getNumber());
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Số được chuyển đổi được lưu vào trong stack convertedNumber.
     */
    @Override
    public void decimalTo(int decimal) {
        /* TODO */
        convertedNumber = new MyStack();
        if (decimal == 0) {
            convertedNumber.push(0);
            return;
        }
        while (decimal > 0) {
            convertedNumber.push(decimal % 2);
            decimal /= 2;
        }
    }

    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(2).
     */
    @Override
    public void update() {
        /* TODO */
        decimalTo(originalNumber.getNumber());
        display();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println(convertedNumber.toString() + "(2)");
    }
}
