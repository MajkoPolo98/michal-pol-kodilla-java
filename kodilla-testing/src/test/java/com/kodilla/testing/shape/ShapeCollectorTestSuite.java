package com.kodilla.testing.shape;

import com.kodilla.testing.shape.shapes.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Collection tests")
    class TestCollection {

        @Test
        void testAddFigure(){
            //Given
            Square figure1 = new Square(5);
            ShapeCollector collection = new ShapeCollector();
            //When
            collection.addFigure(figure1);
            //Then
            Assertions.assertEquals(1, collection.getFiguresQuantity());
        }

        @Test
        void testRemoveFigure(){
            //Given
            Square figure1 = new Square(5);
            ShapeCollector collection = new ShapeCollector();
            collection.addFigure(figure1);
            //When
            boolean result = collection.removeFigure(figure1);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, collection.getFiguresQuantity());
        }

        @Test
        void testRemoveNotExistingFigure(){
            //Given
            Square figure1 = new Square(5);
            ShapeCollector collection = new ShapeCollector();
            //When
            boolean result = collection.removeFigure(figure1);
            //Then
            Assertions.assertFalse(result);
        }
        @Test
        void testGetFigure(){
            //Given
            Square figure1 = new Square(5);
            ShapeCollector collection = new ShapeCollector();
            collection.addFigure(figure1);
            //When
            Shape figure = collection.getFigure(0);
            //Then
            Assertions.assertEquals(figure1, figure);
        }
        @Test
        void testGetFigureOutOfIndex(){
            //Given
            Square figure1 = new Square(5);
            ShapeCollector collection = new ShapeCollector();
            collection.addFigure(figure1);
            //When
            Shape figure = collection.getFigure(2);
            //Then
            Assertions.assertNull(figure);
        }
        @Test
        void testGetFigureMinusIndex(){
            //Given
            Square figure1 = new Square(5);
            ShapeCollector collection = new ShapeCollector();
            collection.addFigure(figure1);
            //When
            Shape figure = collection.getFigure(-3);
            //Then
            Assertions.assertNull(figure);
        }
        @Test
        void testShowFigures(){
            //Given
            Square figure1 = new Square(5);
            Triangle figure2 = new Triangle(5, 4);
            ShapeCollector collection = new ShapeCollector();
            collection.addFigure(figure1);
            collection.addFigure(figure2);
            //When
            List<String> figuresNamesCollection = collection.showFigures();
            //Then
            Assertions.assertEquals(Arrays.asList("Square", "Triangle"), figuresNamesCollection);
        }
    }
    @Nested
    @DisplayName("Figures tests")
    class TestFigures{
        @Test
        void testFigureNameGetter(){
            //Given
            Triangle figure = new Triangle(5, 4);
            //When
            String name = figure.getShapeName();
            //Then
            Assertions.assertEquals("Triangle",name);
        }
        @Test
        void testFieldGetter(){
            //Given
            Triangle figure = new Triangle(5, 4);
            //When
            double field = figure.getField();
            //Then
            Assertions.assertEquals(10, field);
        }
    }
}
