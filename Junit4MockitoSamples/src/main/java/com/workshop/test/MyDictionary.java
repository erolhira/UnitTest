package com.workshop.test;

import java.util.Map;
import java.util.HashMap;

public class MyDictionary {
	
	Map<String, String> wordMap;

	public MyDictionary() {
		wordMap = new HashMap<String, String>();
	}

	public void add(final String word, final String meaning) {
		wordMap.put(word, meaning);
	}

	public String getMeaning(final String word) {
		return wordMap.get(word);
	}
}