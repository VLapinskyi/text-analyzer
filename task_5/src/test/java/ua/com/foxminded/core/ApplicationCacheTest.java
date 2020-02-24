package ua.com.foxminded.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationCacheTest {

    private ApplicationCache applicationCache;
    LinkedHashMap<Character, Integer> data;
    private String textKey;

    @BeforeEach
    void initCache() {
	applicationCache = ApplicationCache.getApplicationCache();
    }

    @BeforeEach
    void prepareDataForCache() {
	data = new LinkedHashMap<Character, Integer>();
	textKey = "some key";
    }

    @Test
    void shouldContaintMapInCache() {
	applicationCache.writeDataInCache(textKey, data);
	assertTrue(applicationCache.containsResultInCache(textKey));
    }

    @Test
    void shouldReadMapWithExistingKey() {
	applicationCache.writeDataInCache(textKey, data);
	assertEquals(data, applicationCache.getDataFromCache(textKey));
    }

}
