package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){

        //Given

        //normal
        Library library = new Library("Library");
        IntStream.iterate(1, n-> n+1).limit(5)
                .forEach(n->library.getBooks()
                        .add(new Book(("Title "+n), ("Author "+n), LocalDate.of(1990+5*n, 1, 1))));

        //shallow copy
        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("Shallow copy Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //deep copy
        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("Deep copy Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().add(new Book("Title added", "New Author", LocalDate.of(2011,10,5)));


        //Then
        assertEquals(6,library.getBooks().size());
        assertEquals(6,shallowCopy.getBooks().size());
        assertEquals(5,deepCopy.getBooks().size());





    }
}
