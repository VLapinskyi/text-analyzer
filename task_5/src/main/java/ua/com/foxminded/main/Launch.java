package ua.com.foxminded.main;

import ua.com.foxminded.core.ApplicationCache;
import ua.com.foxminded.core.BlankTextException;
import ua.com.foxminded.core.TextAnalyser;
import ua.com.foxminded.core.TextData;
import ua.com.foxminded.core.TextFormatter;

public class Launch {

    public static void main(String[] args) {
	ApplicationCache cache = ApplicationCache.getApplicationCache();
	TextAnalyser textAnalyser = new TextAnalyser();
	String firstText = "hello world!";
	String secondText = "hello world!";
	TextData textData = null;
	TextData otherTextData = null;
	try {
	    textData = textAnalyser.analyseString(firstText);
	    otherTextData = textAnalyser.analyseString(secondText);
	} catch (BlankTextException e) {
	    e.getMessage();
	    e.printStackTrace();
	}
	TextFormatter textFormatter = new TextFormatter();
	System.out.println(firstText);
	System.out.println(textFormatter.format(textData));
	System.out.println(secondText);
	System.out.println(textFormatter.format(otherTextData));

	cache.finishCache();
    }

}
