package ua.com.foxminded.core;

import java.util.LinkedHashMap;
import java.util.Map;

public class TextAnalyser {
    public Map<Character, Integer> analyseString(String text) {
	if (text.equals(""))
	    return new LinkedHashMap<>();
	ApplicationCache applicationCache = ApplicationCache.getApplicationCache();
	if (applicationCache.containsResultInCache(text)) {
	    return applicationCache.getDataFromCache(text);
	} else {
	    LinkedHashMap<Character, Integer> analysingData = fillData(text);
	    applicationCache.writeDataInCache(text, analysingData);
	    return analysingData;
	}
    }

    private LinkedHashMap<Character, Integer> fillData(String text) {
	LinkedHashMap<Character, Integer> analysingData = new LinkedHashMap<>();
	char[] arrayText = text.toCharArray();
	for (int i = 0; i < arrayText.length; i++) {
	    analysingData.put(arrayText[i], 0);
	}
	for (Character key : analysingData.keySet()) {
	    int countOfCharacter = 0;
	    for (int i = 0; i < arrayText.length; i++) {
		if (key == arrayText[i])
		    countOfCharacter++;
	    }
	    analysingData.put(key, countOfCharacter);
	}

	return analysingData;
    }
}
