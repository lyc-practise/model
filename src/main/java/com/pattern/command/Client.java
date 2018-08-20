package com.pattern.command;

public class Client {

    public static void main(String[] args) {

        CalculatorForm form = new CalculatorForm();
        Data data = new Data();
        AbstractCommand add = new AddCommand();
        AbstractCommand minus = new MinusCommand();
        add.setData(data);
        minus.setData(data);
        form.executeAdd(add, 1);
        form.executeAdd(add, 5);
        form.executeMinus(minus, 2);
        form.executeMinus(minus, 3);
    }
}
