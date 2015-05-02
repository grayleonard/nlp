package com.leonard.nlp;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Knowledgebase {

	private Map<String, String[]> keywords = new HashMap<String, String[]>();

	public Knowledgebase(String[] keywords) {
		for(int i = 0; i < keywords.length; i++) {
			this.keywords.put(keywords[i], null);
		}
	}

	public String[] getRandomKeyword() {
		Random rand = new Random();
		int pos = rand.nextInt(keywords.size());
		return keywords.get(pos);
	}

	public void storeResult(String keyword, ArrayList<String> result) {
		String[] tmpRes = new String[result.size()];
		tmpRes = result.toArray(tmpRes);
		keywords.put(keyword, tmpRes);
	}

	public void printResults() {
		System.out.println(keywords.toString());
	}

}
