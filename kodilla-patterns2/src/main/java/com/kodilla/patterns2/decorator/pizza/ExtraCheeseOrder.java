package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseOrder extends AbstractPizzaOrderDecorator {

    protected ExtraCheeseOrder(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + extra cheese";
    }
}
