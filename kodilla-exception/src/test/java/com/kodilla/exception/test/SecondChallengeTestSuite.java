package com.kodilla.exception.test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {
    @Test
    public void probablyIWillThrowException(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),
                () -> assertDoesNotThrow(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(5, 5))
        );
    }
}
