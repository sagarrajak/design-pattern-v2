package com.fancystore.structrual.adapter;

public class BasicCalculator {
    public double operation(double a, double b, String operation) {
        switch (operation) {
            case "add": {
                return a + b;
            }
            case "subtract": {
                return a - b;
            }
            case "divide": {
                return a/b;
            }
            default: {
                return 0;
            }
        }
    }
}


interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
}


class CalculatorAdapter implements Calculator {
    private final BasicCalculator basicCalculator;
    CalculatorAdapter(BasicCalculator calculator) {
        basicCalculator = calculator;
    }
    @Override
    public double add(double a, double b) {
        return basicCalculator.operation(a, b, "add");
    }

    @Override
    public double subtract(double a, double b) {
        return  basicCalculator.operation(a, b, "subtract");
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        CalculatorAdapter calculatorAdapter = new CalculatorAdapter(bc);
        double add = calculatorAdapter.add(10.12, 12.43);
        System.out.println(add);
    }
}

