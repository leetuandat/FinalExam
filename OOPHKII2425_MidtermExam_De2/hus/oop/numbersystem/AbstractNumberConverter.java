package hus.oop.numbersystem;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;   // Số gốc
    protected MyStack convertedNumber;   // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberConverter(MyNumber originalNumber) {
        /* TODO */
        this.originalNumber = originalNumber;
        this.convertedNumber = new MyStack();
    }

    /*
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Số được chuyển đổi được lưu vào trong stack convertedNumber.
     */
    public abstract void decimalTo(int decimal);
}
