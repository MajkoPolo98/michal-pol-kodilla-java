package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionModuleReader {

    public static void main(String[] args) throws FileReaderException {
        FileReader newFile = new FileReader();
        newFile.readFile("names.txt");
    }
}