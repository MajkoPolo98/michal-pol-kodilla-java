package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

   /*
   Polecenie nr 1
   @Test
    void testGetLastLog(){
        //Given
        Logger logger = new Logger();
        //When
        logger.log("log");
        //Then
        assertEquals(logger.getLastLog(), "log");
    }
    */

    private static Logger logger;

    @BeforeAll
    public static void open(){
        logger = Logger.INSTANCE;
        logger.newLog("log");
    }

    @AfterAll
    public static void close(){
        logger.deleteLog();
    }

    @Test
    void testGetLastLog(){
        //Given
        Logger logger = Logger.INSTANCE;
        //When
        //Then
        assertEquals(logger.getLastLog(), "log");
    }



}
