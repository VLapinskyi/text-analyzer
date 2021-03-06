package ua.com.foxminded.core;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TextFormatter {

    public String format(LinkedHashMap<Character, Integer> analysingData) {
	StringBuilder resultText = new StringBuilder();
	int mapSize = analysingData.size();
	int countOfIteration = 0;
	if (mapSize > 0) {
	    for (Entry<Character, Integer> entry : analysingData.entrySet()) {
		countOfIteration++;
		if (mapSize - countOfIteration > 0) {
		    resultText.append("\"" + entry.getKey() + "\" - " + entry.getValue() + "\r\n");
		} else {
		    resultText.append("\"" + entry.getKey() + "\" - " + entry.getValue());
		}
	    }
	}

	return resultText.toString();
    }
}
