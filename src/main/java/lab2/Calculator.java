package lab2;

import lombok.Data;

@Data
public abstract class Calculator {

    private double accuracy;

    public Calculator(double accuracy) {
        this.accuracy = accuracy;
    }

    public abstract double calculate(double x);
}
