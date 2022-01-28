package com.kodilla.patterns2.adapter.library;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void testMedian(){
        //Given
        Book book1 = new Book("Author1", "Title1", 1990, "Signature1");
        Book book2 = new Book("Author2", "Title2", 1995, "Signature2");
        Book book3 = new Book("Author3", "Title3", 2000, "Signature3");
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);

        MedianAdapter adapter = new MedianAdapter();

        //When
        int median = adapter.publicationYearMedian(bookSet);

        //Then
        Assertions.assertEquals(1995, median);
    }
}
