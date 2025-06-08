package hus.oop.integration;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficients;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        coefficients = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index >= 0 && index < size) {
            return coefficients[index];
        }
        return 0.0;
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficients, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        if (size == coefficients.length) {
            allocateMore(); // Tăng kích thước mảng nếu cần thiết
        }
        coefficients[size++] = coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        if (index >= size) {
            while (index >= size) {
                append(0);
            }
        }
        coefficients[index] += coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        if (index >= size) {
            while (index >= size) {
                append(0);
            }
        }
        coefficients[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < size; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        MyArrayPolynomial derivative = new MyArrayPolynomial();
        for (int i = 1; i < size; i++) {
            derivative.append(coefficients[i] * i); // Đạo hàm của x^i là i * x^(i-1)
        }
        return derivative;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        int maxDegree = Math.max(this.degree(), right.degree());

        for (int i = 0; i <= maxDegree; i++) {
            double leftCoeff = i <= this.degree() ? this.coefficient(i) : 0;
            double rightCoeff = i <= right.degree() ? right.coefficient(i) : 0;
            result.append(leftCoeff + rightCoeff);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        MyArrayPolynomial result = new MyArrayPolynomial();
        int maxDegree = Math.max(this.degree(), right.degree());

        for (int i = 0; i <= maxDegree; i++) {
            double leftCoeff = i <= this.degree() ? this.coefficient(i) : 0;
            double rightCoeff = i <= right.degree() ? right.coefficient(i) : 0;
            result.append(leftCoeff - rightCoeff);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        int resultDegree = this.degree() + right.degree();
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= resultDegree; i++) {
            result.append(0);
        }
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                double product = this.coefficient(i) * right.coefficient(j);
                result.add(product, i + j);
            }
        }
        return result;
    }

    /**
     * Tăng kích thước mảng lên gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        double[] newCoefficients = new double[coefficients.length * 2];
        System.arraycopy(coefficients, 0, newCoefficients, 0, coefficients.length);
        coefficients = newCoefficients;
    }
}
