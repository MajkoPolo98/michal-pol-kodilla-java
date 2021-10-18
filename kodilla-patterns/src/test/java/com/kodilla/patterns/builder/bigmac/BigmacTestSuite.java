package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder(){

        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Sezame")
                .burgers(2)
                .sauce("Ketchup")
                .ingredient("Tomato")
                .ingredient("Salad")
                .build();

        //When
        String bunType = bigmac.getBun();
        int burgersQuantity = bigmac.getBurgers();
        String sauceType = bigmac.getSauce();
        int ingredientsQuantity = bigmac.getIngredients().size();

        //Then
        assertEquals("Sezame", bunType);
        assertEquals(2, burgersQuantity);
        assertEquals("Ketchup", sauceType);
        assertEquals(2, ingredientsQuantity);
    }
}
