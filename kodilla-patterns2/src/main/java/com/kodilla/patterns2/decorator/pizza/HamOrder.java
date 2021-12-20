package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamOrder extends AbstractPizzaOrderDecorator {

    protected HamOrder(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}
