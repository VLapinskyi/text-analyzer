package ua.com.foxminded.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextAnalyserTest {

    TextAnalyser textAnalyser;

    @BeforeEach
    void initAnalyzer() {
	textAnalyser = new TextAnalyser();
    }

    @Test
    void shouldThrowNullPointerException() {
	assertThrows(NullPointerException.class, () -> textAnalyser.analyseString(null));
    }

    @Test
    void shouldReturnEmptyMap() {
	LinkedHashMap<Character, Integer> expectingData = new LinkedHashMap<>();
	assertEquals(expectingData, textAnalyser.analyseString(""));
    }

    @Test
    void shouldReturnCorrectResut() throws BlankTextException {
	LinkedHashMap<Character, Integer> expectingData = new LinkedHashMap<>();
	expectingData.put('h', 1);
	expectingData.put('e', 1);
	expectingData.put('l', 3);
	expectingData.put('o', 2);
	expectingData.put(' ', 1);
	expectingData.put('w', 1);
	expectingData.put('r', 1);
	expectingData.put('d', 1);
	expectingData.put('!', 1);

	assertEquals(expectingData, textAnalyser.analyseString("hello world!"));
    }
}
