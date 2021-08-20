package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String textToDecorate, String prefix, String suffix, PoemDecorator text){
        String result = text.decorate(textToDecorate, prefix, suffix);
        System.out.println("Dekorator: " + result);
    }
}
