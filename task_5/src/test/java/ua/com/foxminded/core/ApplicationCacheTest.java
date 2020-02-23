package ua.com.foxminded.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationCacheTest {

    private ApplicationCache applicationCache;
    private TextData textData;
    private String textKey;

    @BeforeEach
    void initCache() {
	applicationCache = ApplicationCache.getApplicationCache();
    }

    @BeforeEach
    void prepareDataForCache() {
	textData = new TextData();
	textKey = "some key";
    }

    @Test
    void shouldContaintObjectInCache() {
	applicationCache.writeDataInCache(textKey, textData);
	assertTrue(applicationCache.containsResultInCache(textKey));
    }

    @Test
    void shouldReadObjectWithExistingKey() {
	applicationCache.writeDataInCache(textKey, textData);
	assertEquals(textData, applicationCache.getDataFromCache(textKey));
    }

}
