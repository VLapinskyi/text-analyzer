package ua.com.foxminded.core;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

public class ApplicationCache {
    private CachingProvider cachingProvider = Caching.getCachingProvider();
    private CacheManager cacheManager = cachingProvider.getCacheManager();
    private MutableConfiguration<String, TextData> configuration = new MutableConfiguration<>();
    private Cache<String, TextData> cache = cacheManager.createCache("AnalysedString", configuration);

    private static ApplicationCache applicationCache;

    private ApplicationCache() {

    }

    public static synchronized ApplicationCache getApplicationCache() {
	if (applicationCache == null)
	    applicationCache = new ApplicationCache();
	return applicationCache;
    }

    protected Cache<String, TextData> getCache() {
	return cache;
    }

    protected void writeDataInCache(String textKey, TextData textData) {
	cache.put(textKey, textData);
    }

    protected TextData getDataFromCache(String textKey) {
	return cache.get(textKey);
    }

    protected boolean containsResultInCache(String textKey) {
	return cache.containsKey(textKey);
    }

    public void finishCache() {
	cache.clear();
	cache.close();
    }
}
