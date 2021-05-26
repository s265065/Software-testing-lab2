package lab2;

import lab2.logariphmic.*;
import lab2.trigonometric.*;

public class Function extends Calculator {

    private SinCalculator sin;
    private CosCalculator cos;
    private TanCalculator tan;
    private CotanCalculator cotan;
    private SecCalculator sec;
    private CosecCalculator cosec;
    private LnCalculator ln;
    private LogBaseCalculator log2;
    private LogBaseCalculator log3;
    private LogBaseCalculator log5;
    private LogBaseCalculator log10;

    public Function(double accuracy, SinCalculator sin, CosCalculator cos, TanCalculator tan, CotanCalculator cotan,
                    SecCalculator sec, CosecCalculator cosec, LnCalculator ln, LogBaseCalculator log2,
                    LogBaseCalculator log3, LogBaseCalculator log5, LogBaseCalculator log10) {
        super(accuracy);
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cotan = cotan;
        this.sec = sec;
        this.cosec = cosec;
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;

    }

    public double calculate(double x){

        if (x <= 0) {
            return (((((((sec.calculate(x) + sec.calculate(x)) * prod(sec.calculate(x),3)) * cotan.calculate(x))
                    - prod(sec.calculate(x), 2)) + ((tan.calculate(x) - sec.calculate(x)) - (sin.calculate(x)
                    + cotan.calculate(x)))) / cotan.calculate(x)) * (sec.calculate(x) + ((cosec.calculate(x)
                    / cos.calculate(x)) - cos.calculate(x))));
        } else {
            return (((prod((log5.calculate(x) * ln.calculate(x)) / log3.calculate(x), 2))
                    - (log2.calculate(x) * log10.calculate(x))) + log3.calculate(x));
        }
    }

    private static double prod(double x, int n) {
        double accum = 1;

        for (int i = 1; i <= n; i++) {
            accum *= x;
        }
        return accum;
    }
}
