package ua.com.foxminded.main;

import java.util.LinkedHashMap;

import ua.com.foxminded.core.ApplicationCache;
import ua.com.foxminded.core.TextAnalyser;
import ua.com.foxminded.core.TextFormatter;

public class Launch {

    public static void main(String[] args) {
	TextAnalyser textAnalyser = new TextAnalyser();
	String firstText = "hello world!";
	String secondText = "hello world!";
	LinkedHashMap<Character, Integer> textData = (LinkedHashMap<Character, Integer>)
		textAnalyser.analyseString(firstText);
	LinkedHashMap<Character, Integer> otherTextData = (LinkedHashMap<Character, Integer>)
		textAnalyser.analyseString(secondText);
	TextFormatter textFormatter = new TextFormatter();
	System.out.println(firstText);
	System.out.println(textFormatter.format(textData));
	System.out.println(secondText);
	System.out.println(textFormatter.format(otherTextData));

	ApplicationCache.getApplicationCache().finishCache();
    }

}
