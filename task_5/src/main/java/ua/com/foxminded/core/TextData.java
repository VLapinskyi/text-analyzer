package ua.com.foxminded.core;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class TextData implements Serializable {
    private static final long serialVersionUID = 1L;

    private LinkedHashMap<Character, Integer> analysingData;

    public TextData() {
	analysingData = new LinkedHashMap<>();
    }

    protected LinkedHashMap<Character, Integer> getAnalysingData() {
	return analysingData;
    }

    protected void setAnalysingData(LinkedHashMap<Character, Integer> analysingData) {
	this.analysingData = analysingData;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((analysingData == null) ? 0 : analysingData.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TextData other = (TextData) obj;
	if (analysingData == null) {
	    if (other.analysingData != null)
		return false;
	} else if (!analysingData.equals(other.analysingData))
	    return false;
	return true;
    }
    
    
}
