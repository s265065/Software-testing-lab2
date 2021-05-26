package lab2.trigonometric;

import lab2.Calculator;

public class CotanCalculator extends Calculator {

    private SinCalculator sin;
    private CosCalculator cos;

    public CotanCalculator(double accuracy, SinCalculator sin, CosCalculator cos) {
        super(accuracy);
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x) {
        double cotan = cos.calculate(x) / sin.calculate(x);
        return Double.isFinite(cotan) ? cotan : Double.POSITIVE_INFINITY;
    }

}
