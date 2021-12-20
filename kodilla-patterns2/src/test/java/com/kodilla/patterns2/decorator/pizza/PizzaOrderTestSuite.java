package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {

    @Test
    public void testPizzaOrder() {
        PizzaOrder thePizzaOrder = new BasicPizzaOrder();
        thePizzaOrder = new ExtraCheeseOrder(thePizzaOrder);
        thePizzaOrder = new HamOrder(thePizzaOrder);
        thePizzaOrder = new MushroomOrder(thePizzaOrder);

        assertEquals(new BigDecimal(24), thePizzaOrder.getCost());
        assertEquals("You ordered a basic pizza (dough + tomato sauce + cheese) + extra cheese + ham + mushrooms", thePizzaOrder.getDescription());

    }
}