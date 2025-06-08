package hus.oop.integration;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int degree = this.degree();

        for (int i = degree; i >= 0; i--) {
            double coefficient = this.coefficient(i);
            if (coefficient != 0) {
                if (sb.length() > 0 && coefficient > 0) {
                    sb.append(" + ");
                } else if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                }
                if (i == 0) {
                    sb.append(coefficient);
                } else if (i == 1) {
                    sb.append(coefficient).append("x");
                } else {
                    sb.append(coefficient).append("x^").append(i);
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        int degree = this.degree();
        double[] derivativeCoefficients = new double[degree];

        for (int i = 1; i <= degree; i++) {
            derivativeCoefficients[i - 1] = this.coefficient(i) * i; // Đạo hàm của x^i là i * x^(i-1)
        }

        return derivativeCoefficients;
    }
}
