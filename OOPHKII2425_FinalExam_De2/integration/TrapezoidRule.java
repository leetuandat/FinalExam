package hus.oop.integration;

public class TrapezoidRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int n = 1;
        double h = (upper - lower);
        double previousResult = 0;
        double result = h * (polynomial.evaluate(lower) + polynomial.evaluate(upper)) / 2;


        for (int iteration = 1; iteration <= maxIterations; iteration++) {
            previousResult = result;
            result = 0;

            n *= 2;
            h = (upper - lower) / n;
            for (int i = 1; i < n; i++) {
                result += polynomial.evaluate(lower + i * h);
            }
            result = h * (polynomial.evaluate(lower) + polynomial.evaluate(upper) + 2 * result) / 2;


            if (Math.abs(result - previousResult) / 3 < precision) {
                break;
            }
        }
        return result;
    }

    /**
     * Tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double sum = 0;
        for (int i = 1; i < numOfSubIntervals; i++) {
            sum += polynomial.evaluate(lower + i * h);
        }
        return h * (polynomial.evaluate(lower) + polynomial.evaluate(upper) + 2 * sum) / 2;
    }
}
