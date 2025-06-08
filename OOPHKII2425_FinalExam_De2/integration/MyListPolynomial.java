package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        if (index >= 0 && index < coefficients.size()) {
            return coefficients.get(index);
        }
        return 0.0;
    }

    @Override
    public double[] coefficients() {
        double[] coeffs = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coeffs[i] = coefficients.get(i);
        }
        return coeffs;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        while (coefficients.size() <= index) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficients.get(index) + coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        while (coefficients.size() <= index) {
            coefficients.add(0.0); // Thêm hệ số 0 nếu cần thiết
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial derivative = new MyListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            derivative.append(coefficients.get(i) * i);
        }
        return derivative;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        int maxDegree = Math.max(this.degree(), right.degree());

        for (int i = 0; i <= maxDegree; i++) {
            double leftCoeff = i <= this.degree() ? this.coefficient(i) : 0;
            double rightCoeff = i <= right.degree() ? right.coefficient(i) : 0;
            result.append(leftCoeff + rightCoeff);
        }
        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        MyListPolynomial result = new MyListPolynomial();
        int maxDegree = Math.max(this.degree(), right.degree());

        for (int i = 0; i <= maxDegree; i++) {
            double leftCoeff = i <= this.degree() ? this.coefficient(i) : 0;
            double rightCoeff = i <= right.degree() ? right.coefficient(i) : 0;
            result.append(leftCoeff - rightCoeff);
        }
        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        int resultDegree = this.degree() + right.degree();
        MyListPolynomial result = new MyListPolynomial();

        for (int i = 0; i <= resultDegree; i++) {
            result.append(0.0); // Khởi tạo các hệ số bằng 0
        }

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= right.degree(); j++) {
                double product = this.coefficient(i) * right.coefficient(j);
                result.add(product, i + j);
            }
        }
        return result;
    }
}
