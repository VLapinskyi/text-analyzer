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
    void shouldThrowBlankTextException() {
	assertThrows(BlankTextException.class, () -> textAnalyser.analyseString(""));
    }

    @Test
    void shouldReturnCorrectResut() throws BlankTextException {
	TextData expectingTextData = new TextData();
	LinkedHashMap<Character, Integer> analysingData = new LinkedHashMap<>();
	analysingData.put('h', 1);
	analysingData.put('e', 1);
	analysingData.put('l', 3);
	analysingData.put('o', 2);
	analysingData.put(' ', 1);
	analysingData.put('w', 1);
	analysingData.put('r', 1);
	analysingData.put('d', 1);
	analysingData.put('!', 1);
	expectingTextData.setAnalysingData(analysingData);

	assertEquals(expectingTextData, textAnalyser.analyseString("hello world!"));
    }
}
