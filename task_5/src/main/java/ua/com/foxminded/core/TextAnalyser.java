package ua.com.foxminded.core;

import java.util.LinkedHashMap;

public class TextAnalyser {
    public TextData analyseString(String text) throws BlankTextException {
	if (text.equals(""))
	    throw new BlankTextException();
	ApplicationCache applicationCache = ApplicationCache.getApplicationCache();
	TextData textData;
	if (applicationCache.containsResultInCache(text)) {
	    textData = applicationCache.getDataFromCache(text);
	} else {
	    LinkedHashMap<Character, Integer> analysingData = fillData(text);
	    textData = new TextData();
	    textData.setAnalysingData(analysingData);
	    applicationCache.writeDataInCache(text, textData);
	}

	return textData;
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
