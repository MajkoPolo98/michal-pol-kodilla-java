package com.kodilla.patterns.strategy.social;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefeaultSharingStrategies(){
        //Given
        User userMil = new Millenials("Karol");
        User userYG = new YGeneration("Maciek");
        User userZG = new ZGeneration("Darek");

        //When
        String userMilDefeaultPublisher = userMil.sharePost();
        String userYGDefeaultPublisher = userYG.sharePost();
        String userZGDefeaultPublisher = userZG.sharePost();

        System.out.println(userMilDefeaultPublisher);
        System.out.println(userYGDefeaultPublisher);
        System.out.println(userZGDefeaultPublisher);

        //Then
        assertEquals("Sharing the post on Facebook wall", userMilDefeaultPublisher);
        assertEquals("Sharing the photo on Snapchat", userYGDefeaultPublisher);
        assertEquals("Sharing on Twitter", userZGDefeaultPublisher);

    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        User userMil = new Millenials("Karol");

        //When
        userMil.setBuyingStrategy(new TwitterPublisher());
        String userMilPublisher = userMil.sharePost();

        //Then
        assertEquals("Sharing on Twitter", userMilPublisher);

    }
}
