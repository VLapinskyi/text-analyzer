package ua.com.foxminded.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextFormatterTest {

    TextFormatter textFormatter;

    @BeforeEach
    void init() {
	textFormatter = new TextFormatter();
    }

    @Test
    void shouldRetutnCorrectString() {
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

	String expected = "\"h\" - 1\r\n\"e\" - 1\r\n\"l\" - 3\r\n\"o\" - 2\r\n\" \" - 1\r\n\"w\" - 1\r\n\"r\" - 1\r\n"
		+ "\"d\" - 1\r\n\"!\" - 1";

	assertEquals(expected, textFormatter.format(analysingData));
    }

    @Test
    void shouldReturnBlankString() {
	assertEquals("", textFormatter.format(new LinkedHashMap<Character, Integer>()));
    }

}
