package hus.oop.integration;

public class IntegrationCalculator {
    private MyIntegrator integrator;
    private MyPolynomial poly;

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     * @param poly
     */
    public IntegrationCalculator(MyPolynomial poly) {
        this.poly = poly;
        this.integrator = new SimpsonRule(0.0001, 1000);
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     * @param integrator
     * @param poly
     */
    public IntegrationCalculator(MyIntegrator integrator, MyPolynomial poly) {
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(MyPolynomial poly) {
        this.poly = poly;
    }

    public void setIntegrator(MyIntegrator integrator) {
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        if (poly == null || integrator == null) {
            throw new IllegalStateException("Poly or integrator is not set");
        }
        return integrator.integrate(poly, lower, upper);
    }
}
